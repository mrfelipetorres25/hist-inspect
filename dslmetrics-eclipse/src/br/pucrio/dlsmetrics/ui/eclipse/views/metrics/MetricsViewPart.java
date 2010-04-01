package br.pucrio.dlsmetrics.ui.eclipse.views.metrics;

import java.util.LinkedList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;

public class MetricsViewPart extends ViewPart {

	class VersionEntityPair {
		
		public Object parent;
		public Version version;
		public Entity entity;
		
		public VersionEntityPair(Object parent, Version version, Entity entity) {
			this.parent = parent;
			this.version = version;
			this.entity = entity;
		}
		
	}
	
	public static final String ID = "br.pucrio.dlsmetrics.ui.eclipse.views.metrics.MetricsViewPart";

	private TreeViewer treeViewer;
	private Project project;

	public MetricsViewPart() {
		// TODO Auto-generated constructor stub
	}

	public void setProject(Project project) {
		this.project = project;
		treeViewer.setInput(project);
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent);

		treeViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			@Override
			public void dispose() {

			}

			@Override
			public Object[] getElements(Object inputElement) {
				Project project = (Project) inputElement;
				return project.getVersions().toArray();
			}

			@Override
			public boolean hasChildren(Object element) {
				if (element instanceof Version)
					return true;
				else
					return !(((VersionEntityPair)element).entity instanceof Method);
			}

			@Override
			public Object getParent(Object element) {
				if (element instanceof Version)
					return project;
				else {
					return ((VersionEntityPair) element).parent;
				}
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				LinkedList<Entity> list = new LinkedList<Entity>();

				if (parentElement instanceof Version) {
					Version version = (Version) parentElement;

					list.addAll(project.getClasses(version));
					list.addAll(project.getPackages(version));
					
				} else if(parentElement instanceof VersionEntityPair) {
					VersionEntityPair versionEntityPair = (VersionEntityPair) parentElement;
					if(versionEntityPair.entity instanceof Package) {
						Package p = (Package) versionEntityPair.entity;
						list.addAll(p.getClasses(versionEntityPair.version));
						list.addAll(p.getPackages(versionEntityPair.version));
					} else if(versionEntityPair.entity instanceof br.pucrio.dslmetrics.core.domain.Class) {
						br.pucrio.dslmetrics.core.domain.Class c = (Class) versionEntityPair.entity;
						list.addAll(c.getClasses(versionEntityPair.version));
						list.addAll(c.getMethods(versionEntityPair.version));
					}
						
						
				}

				return applyVersionEntityPair(parentElement, list); 
			}

			private Object[] applyVersionEntityPair(Object parentElement,
					LinkedList<Entity> list) {
				
				Version v = null;
				
				if(parentElement instanceof Version)
					v = (Version) parentElement;
				else
					v = ((VersionEntityPair)parentElement).version;
				
				Object [] ret = new Object[list.size()];
				
				int i =0;
				for (Entity entity : list) 
					ret[i++] = new VersionEntityPair(parentElement,v,entity);

				return ret;
			}
		});

		treeViewer.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(
						ISharedImages.IMG_OBJ_FOLDER);
			}

			@Override
			public String getText(Object element) {
				if (element instanceof Version) {
					Version version = (Version) element;
					return version.getName();
				} else {
					return ((VersionEntityPair) element).entity.getName();
				}
			}
		});
	}

	@Override
	public void setFocus() {

	}

}
