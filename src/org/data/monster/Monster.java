package org.data.monster;

public abstract class Monster
{
	public final int[][] LOOT;
	public final int[] LOOT_IDS;
	public final int REQUIRED_COMBAT_LVL;
	public final String[] NAMES;
	public final boolean NEEDS_FOOD;
	
	public Monster()
	{
		LOOT = getLoot();
		LOOT_IDS = parseLootIds();
		REQUIRED_COMBAT_LVL = getRequiredCombatLvl();
		NAMES = getNames();
		NEEDS_FOOD = needsFood();
	}
	
	protected abstract int[][] getLoot();
	protected abstract int getRequiredCombatLvl();
	protected abstract String[] getNames();
	protected abstract boolean needsFood();
	
	private int[] parseLootIds()
	{
		int[] ids = new int[LOOT.length];
		for(int i = 0; i < LOOT.length; i++)
			ids[i] = LOOT[i][0];
		
		return ids;
	}
}
