package br.pucrio.dlsmetrics.ui.eclipse.views.metrics;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE.SharedImages;

import br.pucrio.dlsmetrics.ui.eclipse.views.metrics.MetricsTreeContentProvider.VersionEntityPair;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;
import br.pucrio.dslmetrics.core.domain.metrics.Metric;

public class MetricsTreeTableLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	private final TreeViewer viewer;

	public MetricsTreeTableLabelProvider(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		
		Object data = viewer.getTree().getColumn(columnIndex).getData();
		
		if (data == null) {
			
			if(element instanceof VersionEntityPair) {
				
				Entity entity = ((VersionEntityPair)element).entity;
				
				if(entity instanceof br.pucrio.dslmetrics.core.domain.Class)
					return getPlatformImage(ISharedImages.IMG_OBJ_FILE); 
				else if(entity instanceof Package)
					return getPlatformImage(ISharedImages.IMG_OBJ_FOLDER);				
			} 
			else
				return getPlatformImage(SharedImages.IMG_OBJ_PROJECT);			
		} 
		
		return null;
	}

	public Image getPlatformImage(String s) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(s);
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		TreeColumn column = viewer.getTree().getColumn(columnIndex);

		if (element instanceof Version)
			return displayVersionText(element, column);
		else
			return displayEntitiesText(element, column);
	}

	private String displayEntitiesText(Object element, TreeColumn column) {

		VersionEntityPair versionEntityPair = (VersionEntityPair) element;
		Entity entity = versionEntityPair.entity;

		if (column.getData() == null) {
			return entity.getName();
		} else {
			Double metricValue = entity.getMetricValue(
					versionEntityPair.version, (Metric) column.getData());
			if (metricValue == null)
				return "N/A";
			else
				return metricValue.toString();
		}
	}

	private String displayVersionText(Object element, TreeColumn column) {
		Version version = (Version) element;
		Object data = column.getData();
		
		if (data == null)
			return version.getName();
		else {
			Metric metric = ((Metric)column.getData());
			Project project = (Project) viewer.getInput();
			if (project.getMetricValue(version, metric)!=null)
				return project.getMetricValue(version, metric).toString();
			return "";
		}
	}
}