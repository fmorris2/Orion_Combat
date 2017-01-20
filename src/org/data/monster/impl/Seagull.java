package org.data.monster.impl;

import org.data.monster.Monster;

public class Seagull extends Monster
{

	@Override
	protected int[][] getLoot()
	{
		return new int[][]{{526, 0}};
	}

	@Override
	protected int getRequiredCombatLvl()
	{
		return 3;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Seagull"};
	}

	@Override
	protected boolean needsFood()
	{
		return false;
	}

	@Override
	protected int[] getRequiredItems()
	{
		return null;
	}

}
