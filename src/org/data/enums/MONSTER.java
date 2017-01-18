package org.data.enums;

import java.util.ArrayList;
import java.util.List;

import org.data.monster.Monster;
import org.data.monster.impl.Chicken;
import org.data.monster.impl.Cow;
import org.osbot.rs07.api.Combat;

public enum MONSTER
{
	CHICKEN(new Chicken()),
	COW(new Cow());
	
	public final Monster MONSTER;
	
	MONSTER(Monster monster)
	{
		MONSTER = monster;
	}
	
	public static MONSTER getAppropriate(Combat combat)
	{
		final int PLAYER_LVL = combat.getCombatLevel();
		for(int i = values().length - 1; i >= 0; i--)
			if(values()[i].MONSTER.REQUIRED_COMBAT_LVL <= PLAYER_LVL)
				return values()[i];
		
		return CHICKEN;
	}
	
	public static List<LOCATION> getSupportedLocs(MONSTER m)
	{
		List<LOCATION> supported = new ArrayList<>();
		for(LOCATION loc : LOCATION.values())
			if(loc.LOCATION.SUPPORTED_MONSTER == m)
				supported.add(loc);
		
		return supported;
	}
}
