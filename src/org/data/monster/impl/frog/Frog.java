package org.data.monster.impl.frog;

import org.data.monster.Monster;

public abstract class Frog extends Monster
{

	@Override
	protected int[][] getLoot()
	{
		return new int[][]{{526, 0}};
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
