package br.pucrio.dslmetrics.core.domain.walker;

import br.pucrio.dslmetrics.core.domain.Class;
import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.Method;
import br.pucrio.dslmetrics.core.domain.Package;
import br.pucrio.dslmetrics.core.domain.Project;

public interface ProjectVisitor {
	
	public void acceptEntity(Entity entity, int level);
	
	public void acceptProject(Project project, int level);
	
	public void acceptPackage(Package packg, int level);
	
	public void acceptClass(Class clazz, int level);
	
	public void acceptMethod(Method method, int level);

}
