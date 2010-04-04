package br.pucrio.dlsmetrics.ui.eclipse.views.metrics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.bindings.keys.ParseException;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalListener2;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.part.ViewPart;

import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.metrics.Metric;
import br.pucrio.dslmetrics.core.domain.metrics.MetricsRepository;

public class MetricsViewPart extends ViewPart {

	private class TextListener extends KeyAdapter implements
			IContentProposalListener2 {

		boolean closedPopup = false;

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.keyCode == SWT.CR && !closedPopup)
				addColumn();

			closedPopup = false;
		}

		@Override
		public void proposalPopupClosed(ContentProposalAdapter adapter) {
			closedPopup = true;
		}

		@Override
		public void proposalPopupOpened(ContentProposalAdapter adapter) {

		}

	}

	private final class MetricsContentProposalProvider implements
			IContentProposalProvider {
		@Override
		public IContentProposal[] getProposals(String contents, int position) {
			Set<IContentProposal> proposals = new TreeSet<IContentProposal>();
			Set<IContentProposal> priorityProposals = new TreeSet<IContentProposal>();

			for (Metric metric : allAvailableMetrics) {

				String name = metric.getName().toLowerCase();
				String nickname = metric.getNickname().toLowerCase();
				contents = contents.toLowerCase();

				if (name.startsWith(contents) || nickname.startsWith(contents))
					priorityProposals.add(new MetricContentProposal(metric));
				else if (name.contains(contents) || nickname.contains(contents))
					proposals.add(new MetricContentProposal(metric));
			}

			IContentProposal[] array = new IContentProposal[proposals.size()
					+ priorityProposals.size()];

			int beginCopyIndex = 0;

			beginCopyIndex = copyToArray(array, beginCopyIndex,
					priorityProposals.iterator());
			copyToArray(array, beginCopyIndex, proposals.iterator());

			return array;
		}

		private int copyToArray(IContentProposal[] array, int i,
				Iterator<IContentProposal> iterator) {
			while (iterator.hasNext()) {
				IContentProposal contentProposal = (IContentProposal) iterator
						.next();
				array[i] = contentProposal;
				i++;
			}
			return i;
		}
	}

	private final class MetricContentProposal implements IContentProposal,
			Comparable<MetricContentProposal> {

		private final Metric metric;

		public MetricContentProposal(Metric metric) {
			this.metric = metric;
		}

		@Override
		public String getLabel() {
			return metric.getName() + " (" + metric.getNickname() + ")";
		}

		@Override
		public String getDescription() {
			return null;
		}

		@Override
		public int getCursorPosition() {
			return metric.getNickname().length();
		}

		@Override
		public String getContent() {
			return metric.getNickname();
		}

		@Override
		public int compareTo(MetricContentProposal o) {
			return getLabel().compareTo(o.getLabel());
		}
	}

	public static final String ID = "br.pucrio.dlsmetrics.ui.eclipse.views.metrics.MetricsViewPart";

	private TreeViewer treeViewer;
	private Project project;

	private MetricsRepository metricsRepository = MetricsRepository
			.getInstance();

	private MetricsTreeContentProvider contentProvider = new MetricsTreeContentProvider();

	private Set<Metric> allAvailableMetrics;

	private Label labelColumns;

	private Text text;

	private Button button;

	private Map<Metric, TreeColumn> columnMap = new HashMap<Metric, TreeColumn>();

	private KeyListener textListener = new TextListener();

	private Menu headerMenu;

	public static int WIDTH_ENTITIES_COLUMN = 300;
	public static final int WIDTH_METRIC_COLUMN = 50;

	public MetricsViewPart() {
		allAvailableMetrics = new HashSet<Metric>(metricsRepository
				.listAllMetrics());
	}

	public void setProject(Project project) {
		this.project = project;
		treeViewer.setInput(this.project);
		contentProvider.setProject(project);
	}

	@Override
	public void createPartControl(Composite parent) {

		parent.setLayout(new FormLayout());

		labelColumns = new Label(parent, SWT.NONE);
		labelColumns.setText("Enter a metric name or nickname: ");

		text = new Text(parent, SWT.BORDER);
		setAutoCompletion(text);

		button = new Button(parent, SWT.PUSH);
		button.setText("Add");

		configureTable(parent);

		configureLayout();

		configureEvents();

	}

	private void configureEvents() {
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addColumn();
			}

		});

		text.addKeyListener(textListener);
	}

	private void addColumn() {
		Metric metric = metricsRepository.getMetricByNickname(text.getText());

		if (metric != null) {
			if (!columnAlreadyExists(metric))
				createColumn(metric);

		}
	}

	private void createColumn(Metric metric) {

		TreeColumn column = new TreeColumn(treeViewer.getTree(), SWT.NONE);

		column.setText(metric.getNickname());
		column.setToolTipText(metric.getName());
		column.setWidth(WIDTH_METRIC_COLUMN);
		column.setResizable(true);
		column.setData(metric);
		column.setMoveable(true);

		columnMap.put(metric, column);

		text.setText("");
		createMenuItem(headerMenu, column);

		treeViewer.refresh();
	}

	private boolean columnAlreadyExists(Metric metric) {
		return columnMap.containsKey(metric);
	}

	private void configureLayout() {
		FormData formData = new FormData();

		final int offset = 5;

		formData.top = new FormAttachment(text, offset, SWT.CENTER);
		formData.left = new FormAttachment(0, offset);
		labelColumns.setLayoutData(formData);

		formData = new FormData();
		formData.top = new FormAttachment(button, 0, SWT.CENTER);
		formData.right = new FormAttachment(50);
		formData.left = new FormAttachment(labelColumns, 0);
		text.setLayoutData(formData);

		formData = new FormData();
		formData.left = new FormAttachment(text);
		formData.top = new FormAttachment(0, offset);
		button.setLayoutData(formData);

		formData = new FormData();
		formData.top = new FormAttachment(text, offset);
		formData.bottom = new FormAttachment(100);
		formData.right = new FormAttachment(100);
		formData.left = new FormAttachment(0, 0);
		treeViewer.getTree().setLayoutData(formData);
	}

	private void configureTable(Composite parent) {

		treeViewer = new TreeViewer(parent, SWT.VIRTUAL);
		contentProvider = new MetricsTreeContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setUseHashlookup(true);
		treeViewer.setLabelProvider(new MetricsTreeTableLabelProvider(
				treeViewer));

		final Tree tree = treeViewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		TreeColumn column = new TreeColumn(tree, SWT.NONE);
		column.setText("Entities");
		column.setWidth(WIDTH_ENTITIES_COLUMN);
		column.setResizable(true);

		headerMenu = new Menu(parent);

		tree.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				tree.setMenu(headerMenu);
			}
		});

	}

	@Override
	public void setFocus() {
		treeViewer.getTree().forceFocus();
	}

	private void setAutoCompletion(Text textColumns) {

		final String KEY_PRESS = "Ctrl+Space";

		IContentProposalProvider proposalProvider = new MetricsContentProposalProvider();

		try {
			ContentProposalAdapter adapter = new ContentProposalAdapter(
					textColumns, new TextContentAdapter(), proposalProvider,
					KeyStroke.getInstance(KEY_PRESS),
					createAutoActivationChars());
			adapter
					.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
			adapter
					.addContentProposalListener((IContentProposalListener2) textListener);
		} catch (ParseException e) {
			e.printStackTrace(); // nunca acontecerá
		}

	}

	private char[] createAutoActivationChars() {
		char[] chars = new char[2 * ('z' - 'a') + 2];

		for (char i = 'a'; i < 'z'; i++) {
			chars[2 * (i - 'a')] = i;
			chars[2 * (i - 'a') + 1] = Character.toUpperCase(i);
		}

		chars[chars.length - 1] = ' ';
		chars[chars.length - 2] = SWT.BS;

		return chars;
	}

	private void createMenuItem(Menu parent, final TreeColumn column) {
		final MenuItem itemName = new MenuItem(parent, SWT.CHECK);
		itemName.setText("Show " + column.getText());
		itemName.setSelection(column.getResizable());
		itemName.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				if (itemName.getSelection()) {
					column.setWidth(WIDTH_METRIC_COLUMN);
					column.setResizable(true);
				} else {
					column.setWidth(0);
					column.setResizable(false);
				}
			}
		});

	}

}
