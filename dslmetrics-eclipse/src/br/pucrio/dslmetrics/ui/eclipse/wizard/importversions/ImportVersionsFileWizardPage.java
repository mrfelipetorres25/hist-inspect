package br.pucrio.dslmetrics.ui.eclipse.wizard.importversions;

import java.io.File;
import java.text.MessageFormat;

import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class ImportVersionsFileWizardPage extends WizardPage {

	private Text textControl;

	protected ImportVersionsFileWizardPage(String pageName) {
		super(pageName);
		setTitle("Import Versions File");

		setPageComplete(false);
	}

	@Override
	public void createControl(Composite root) {
		Composite parent = new Composite(root, SWT.NONE);
		parent.setLayout(new FormLayout());

		FileFieldEditor fileFieldEditor = new FileFieldEditor(
				"VersionsFileFieldEditor", "Versions File path:", parent);
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 0);
		formData.top = new FormAttachment(0, 0);

		textControl = fileFieldEditor.getTextControl(parent);
		textControl.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				
				setMessage("  ");
				setPageComplete(false);
				
				String filename = textControl.getText();
				if (!filename.endsWith(".ver.xml"))
					setErrorMessage(MessageFormat.format(
							"Versions File {0} must ends with \".ver.xml\".",
							filename));
				else if (!new File(filename).exists())
					setErrorMessage("Versions File specified does not exists.");
				else
					setPageComplete(true);
			}
		});

		setControl(parent);
	}

	public String getFileName() {
		return textControl.getText();
	}

}
