package br.pucrio.dlsmetrics.ui.eclipse.views.metrics;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.handlers.HandlerUtil;

public class CopyMetricsHandler extends AbstractHandler {

	private static final char COLUMN_DELIMITER = '\t';
	private static final char LINE_DELIMITER = '\n';
	private final TreeViewer treeViewer;

	public CopyMetricsHandler(TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Clipboard clipboard = new Clipboard(HandlerUtil.getActiveShell(event)
				.getDisplay());
		try {
			return execute(event, clipboard);
		} finally {
			clipboard.dispose();
		}
	}

	private Object execute(ExecutionEvent event, Clipboard clipboard) {
		ISelection selection = treeViewer.getSelection();

		if (selection instanceof IStructuredSelection) {

			Tree tree = treeViewer.getTree();
			int[] columnOrder = tree.getColumnOrder();

			StringBuffer buff = new StringBuffer();

			for (int i = 0; i < columnOrder.length; i++) {
				TreeColumn col = tree.getColumn(columnOrder[i]);
				if (isColumnVisible(col)) {
					if (!isFirst(i))
						buff.append(COLUMN_DELIMITER);
					buff.append(col.getText());

				}
			}

			buff.append(LINE_DELIMITER);

			Object[] array = ((IStructuredSelection) selection).toArray();

			for (Object obj : array) {
				for (int i = 0; i < columnOrder.length; i++) {
					TreeColumn col = tree.getColumn(columnOrder[i]);
					if (isColumnVisible(col)) {
						if (!isFirst(i))
							buff.append(COLUMN_DELIMITER);
						buff.append(((MetricsTreeTableLabelProvider) treeViewer
								.getLabelProvider()).getColumnText(obj,
								columnOrder[i]));

					}
				}
				buff.append(LINE_DELIMITER);
			}

			clipboard.setContents(new Object[] { buff.toString() },
					new Transfer[] { TextTransfer.getInstance() });
		}
		return null;
	}

	private boolean isFirst(int i) {
		return i == 0;
	}

	private boolean isColumnVisible(TreeColumn col) {
		return col.getWidth() != 0;
	}

}
