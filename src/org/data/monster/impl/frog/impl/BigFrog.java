package org.data.monster.impl.frog.impl;

import org.data.monster.impl.frog.Frog;

public class BigFrog extends Frog
{

	@Override
	protected int getRequiredCombatLvl()
	{
		return 13;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Big frog"};
	}

}
