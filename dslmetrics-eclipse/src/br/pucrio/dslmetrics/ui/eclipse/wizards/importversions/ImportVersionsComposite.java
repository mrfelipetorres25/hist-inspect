package br.pucrio.dslmetrics.ui.eclipse.wizards.importversions;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class ImportVersionsComposite extends Composite {

	private Label label = null;
	private Text text = null;

	public ImportVersionsComposite(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		label = new Label(this, SWT.NONE);
		label.setText("Label");
		text = new Text(this, SWT.BORDER);
		this.setLayout(gridLayout);
		setSize(new Point(300, 200));
	}

}
