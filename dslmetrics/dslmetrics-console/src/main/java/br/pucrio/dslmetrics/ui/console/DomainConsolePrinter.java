package br.pucrio.dslmetrics.ui.console;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.walker.ProjectVisitorAdapter;

public class DomainConsolePrinter extends ProjectVisitorAdapter {

	@Override
	public void acceptEntity(Entity entity, int level) {
		for (int i = 0; i < level; i++)
			System.out.print("  ");

		System.out.println(entity.getName());
	}
}
