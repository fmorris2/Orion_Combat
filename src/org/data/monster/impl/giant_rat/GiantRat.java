package org.data.monster.impl.giant_rat;

import org.data.monster.Monster;

public abstract class GiantRat extends Monster
{

	@Override
	protected int[][] getLoot()
	{
		//just bones
		return new int[][]{{526, 0}};
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Giant rat"};
	}

	@Override
	protected int[] getRequiredItems()
	{
		return null;
	}
	
	@Override
	protected boolean needsFood()
	{
		return false;
	}

}
