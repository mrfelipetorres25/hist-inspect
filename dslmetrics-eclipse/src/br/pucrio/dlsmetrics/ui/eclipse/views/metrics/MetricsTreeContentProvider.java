package br.pucrio.dlsmetrics.ui.eclipse.views.metrics;

import java.util.LinkedList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;
import br.pucrio.dslmetrics.core.domain.Version;

public class MetricsTreeContentProvider implements ITreeContentProvider {

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

	private Project project;

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
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
			return !(((VersionEntityPair) element).entity instanceof Method);
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof Version)
			return getProject();
		else {
			return ((VersionEntityPair) element).parent;
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		LinkedList<Entity> list = new LinkedList<Entity>();

		if (parentElement instanceof Version) {
			Version version = (Version) parentElement;

			list.addAll(getProject().getClasses(version));
			list.addAll(getProject().getPackages(version));

		} else if (parentElement instanceof VersionEntityPair) {
			VersionEntityPair versionEntityPair = (VersionEntityPair) parentElement;
			if (versionEntityPair.entity instanceof Package) {
				Package p = (Package) versionEntityPair.entity;
				list.addAll(p.getClasses(versionEntityPair.version));
				list.addAll(p.getPackages(versionEntityPair.version));
			} else if (versionEntityPair.entity instanceof br.pucrio.dslmetrics.core.domain.Class) {
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

		if (parentElement instanceof Version)
			v = (Version) parentElement;
		else
			v = ((VersionEntityPair) parentElement).version;

		Object[] ret = new Object[list.size()];

		int i = 0;
		for (Entity entity : list)
			ret[i++] = new VersionEntityPair(parentElement, v, entity);

		return ret;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getProject() {
		return project;
	}
}