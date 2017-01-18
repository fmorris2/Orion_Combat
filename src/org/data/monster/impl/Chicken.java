package org.data.monster.impl;

import org.data.monster.Monster;

public class Chicken extends Monster
{
	@Override
	protected int[] getLoot()
	{
		//bones, feather, raw chicken
		return new int[]{526, 314, 2138};
	}

	@Override
	protected int getRequiredCombatLvl()
	{
		return 3;
	}

	@Override
	protected String[] getNames()
	{
		return new String[]{"Chicken"};
	}

}
