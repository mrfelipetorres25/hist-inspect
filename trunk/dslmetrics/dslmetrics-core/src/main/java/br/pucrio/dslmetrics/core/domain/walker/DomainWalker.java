package br.pucrio.dslmetrics.core.domain.walker;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;

public class DomainWalker {

	private List<DomainVisitor> visitors = new LinkedList<DomainVisitor>();

	private int level = 0;

	public DomainWalker() {

	}
	
	public DomainWalker(Collection<DomainVisitor> visitors) {
		this.visitors.addAll(visitors);
	}
	
	public DomainWalker(DomainVisitor ... visitors) {
		this.visitors.addAll(Arrays.asList(visitors));
	}

	public void walk(Project project) {

		level = 0;

		for (DomainVisitor visitor : visitors) {
			visitor.acceptEntity(project, level);
			visitor.acceptProject(project, level);
		}

		for (Package p : project.getPackagesOfAllVersions())
			visitPackage(p);

		for (Class c : project.getClassesOfAllVersions())
			visitClass(c);
	}

	private void visitClass(Class c) {

		level++;

		for (DomainVisitor visitor : visitors) {
			visitor.acceptEntity(c, level);
			visitor.acceptClass(c, level);
		}

		for (Method method : c.getMethodsOfAllVersions())
			visitMethod(method);

		for (Class clazz : c.getClassesOfAllVersions())
			visitClass(clazz);

		level--;
	}

	private void visitPackage(Package p) {

		level++;

		for (DomainVisitor visitor : visitors) {
			visitor.acceptEntity(p, level);
			visitor.acceptPackage(p, level);
		}

		for (Package packg : p.getPackagesOfAllVersions())
			visitPackage(packg);

		for (Class c : p.getClassesOfAllVersions())
			visitClass(c);

		level--;
	}

	private void visitMethod(Method method) {
		level++;

		for (DomainVisitor visitor : visitors) {
			visitor.acceptEntity(method, level);
			visitor.acceptMethod(method, level);
		}

		level--;
	}

	public boolean addVisitor(DomainVisitor e) {
		return visitors.add(e);
	}

	public boolean removeVisitor(Object o) {
		return visitors.remove(o);
	}

	public void clearVisitors() {
		visitors.clear();
	}

	public List<DomainVisitor> getVisitors() {
		return Collections.unmodifiableList(visitors);
	}
}
