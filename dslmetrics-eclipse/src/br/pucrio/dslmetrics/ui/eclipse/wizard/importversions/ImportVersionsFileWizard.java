package br.pucrio.dslmetrics.ui.eclipse.wizard.importversions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import br.pucrio.dlsmetrics.ui.eclipse.views.metrics.MetricsViewPart;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.ProjectBuilderException;
import br.pucrio.dslmetrics.core.domain.ProjectReader;
import br.pucrio.dslmetrics.core.mtbl.XmlMtblDomainBuilder;
import br.pucrio.dslmetrics.ui.eclipse.Activator;

public class ImportVersionsFileWizard extends Wizard {

	private ImportVersionsFileWizardPage page;

	public ImportVersionsFileWizard() {
		setWindowTitle("Import Versions File");
		setNeedsProgressMonitor(true);
	}

	@Override
	public boolean performFinish() {

		try {
			getContainer().run(false, false, new IRunnableWithProgress() {

				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask(
							"Loading all project versions and metrics...",
							monitor.UNKNOWN);

					ProjectReader projectReader;

					try {
						projectReader = new ProjectReader(
								new XmlMtblDomainBuilder(page.getFileName()));
						Project project = projectReader.readProject();

						MetricsViewPart metricView = (MetricsViewPart) PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getActivePage().showView(MetricsViewPart.ID);
						metricView.setProject(project);

					} catch (ProjectBuilderException e) {
						throw new InvocationTargetException(e);
					} catch (PartInitException e) {
						ErrorDialog.openError(getShell(),
								"Error opening Metrics View", "An error occured while initializing Metric View.",
								new Status(IStatus.ERROR, Activator.PLUGIN_ID,
										e.getMessage(), e));
					}
				}
			});
		} catch (InvocationTargetException e) {
			ErrorDialog.openError(getShell(), "Error loading project.",
					"Project could not be loaded because an error.",
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, 0, e
							.getTargetException().getMessage(), e
							.getTargetException()));
			return true;
		} catch (InterruptedException e) {
			return false;
		}

		return true;
	}

	@Override
	public void addPages() {
		page = new ImportVersionsFileWizardPage("ImportVersionsFileWizardPage");
		addPage(page);
	}

}
