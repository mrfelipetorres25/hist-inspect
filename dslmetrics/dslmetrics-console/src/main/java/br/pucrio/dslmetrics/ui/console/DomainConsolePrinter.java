package br.pucrio.dslmetrics.ui.console;

import br.pucrio.dslmetrics.core.domain.Entity;
import br.pucrio.dslmetrics.core.domain.walker.DomainVisitorAdapter;

public class DomainConsolePrinter extends DomainVisitorAdapter {

	@Override
	public void acceptEntity(Entity entity, int level) {
		for (int i = 0; i < level; i++)
			System.out.print("  ");

		System.out.println(entity.getName());
	}
}
