package org.data.monster.impl;

import org.data.monster.Monster;

public class Cow extends Monster
{

	@Override
	protected int[][] getLoot()
	{
		//cowhide is only thing worth looting
		return new int[][]{{1739, 0}};
	}

	@Override
	protected int getRequiredCombatLvl()
	{
		return 12;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Cow", "Cow calf"};
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
