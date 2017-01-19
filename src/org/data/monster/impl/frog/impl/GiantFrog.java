package org.data.monster.impl.frog.impl;

import org.data.monster.impl.frog.Frog;

public class GiantFrog extends Frog
{

	@Override
	protected int getRequiredCombatLvl()
	{
		return 16;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Giant frog"};
	}

}
