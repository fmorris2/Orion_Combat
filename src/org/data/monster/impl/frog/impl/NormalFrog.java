package org.data.monster.impl.frog.impl;

import org.data.monster.impl.frog.Frog;

public class NormalFrog extends Frog
{

	@Override
	protected int getRequiredCombatLvl()
	{
		return 7;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Frog"};
	}

}
