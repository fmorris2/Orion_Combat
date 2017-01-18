package org.data.enums.equipment;

public enum Food
{
	TROUT(333, 3),
	TUNA(361, 50),
	LOBSTER(379, 75),
	SWORDFISH(373, 100);
	
	
	public final int ID, USE_AT;
	
	Food(int itemID, int useAtLevel)
	{
		ID = itemID;
		USE_AT= useAtLevel;
	}
	
	public static Food getApprop(int combatLevel)
	{
		final Food[] VALS = values();
		for(int i = VALS.length - 1; i >= 0; i--)
			if(VALS[i].USE_AT <= combatLevel)
				return VALS[i];
		
		return TROUT;
	}
}
