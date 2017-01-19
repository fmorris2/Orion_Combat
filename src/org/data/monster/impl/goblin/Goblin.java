package org.data.monster.impl.goblin;

import org.data.monster.Monster;

public abstract class Goblin extends Monster
{

	@Override
	protected int[][] getLoot()
	{
		return new int[][]{{526, 0}};
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Goblin"};
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
