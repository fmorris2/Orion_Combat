package org.data.monster;

public abstract class Monster
{
	public final int[] LOOT;
	public final int REQUIRED_COMBAT_LVL;
	public final String[] NAMES;
	
	public Monster()
	{
		LOOT = getLoot();
		REQUIRED_COMBAT_LVL = getRequiredCombatLvl();
		NAMES = getNames();
	}
	
	protected abstract int[] getLoot();
	protected abstract int getRequiredCombatLvl();
	protected abstract String[] getNames();
}
