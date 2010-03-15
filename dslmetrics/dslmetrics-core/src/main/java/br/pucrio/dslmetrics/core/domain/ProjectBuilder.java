package br.pucrio.dslmetrics.core.domain;

import java.util.Map;


public interface ProjectBuilder {

	public Package buildPackage(Package pack) throws ProjectBuilderException;

	public Class buildClass(Class clazz) throws ProjectBuilderException;

	public Method buildMethod(Method method) throws ProjectBuilderException;

	public Project buildProject() throws ProjectBuilderException;

	public Map<String, Entity> getIdentityMap();
}
