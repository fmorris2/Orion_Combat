package org.data.monster.impl;

import org.data.monster.Monster;

public class HillGiant extends Monster
{

	@Override
	protected int[][] getLoot()
	{
		return new int[][]{{532, 1}, {225, 1}};
	}

	@Override
	protected int getRequiredCombatLvl()
	{
		return 50;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Hill Giant"};
	}

	@Override
	protected boolean needsFood()
	{
		return true;
	}

	@Override
	protected int[] getRequiredItems()
	{
		return null;
	}

}
