package org.data.enums;

import java.util.ArrayList;
import java.util.List;

import org.data.monster.Monster;
import org.data.monster.impl.Chicken;
import org.data.monster.impl.Cow;
import org.data.monster.impl.Seagull;
import org.data.monster.impl.frog.impl.BigFrog;
import org.data.monster.impl.frog.impl.GiantFrog;
import org.data.monster.impl.frog.impl.NormalFrog;
import org.data.monster.impl.giant_rat.impl.StrongGiantRat;
import org.data.monster.impl.giant_rat.impl.WeakGiantRat;
import org.data.monster.impl.goblin.impl.WeakGoblin;
import org.osbot.rs07.api.Combat;
import org.osbot.rs07.script.MethodProvider;

public enum MONSTER
{
	CHICKEN(new Chicken()),
	COW(new Cow()),
	WEAK_GIANT_RAT(new WeakGiantRat()),
	STRONG_GIANT_RAT(new StrongGiantRat()),
	NORMAL_FROG(new NormalFrog()),
	BIG_FROG(new BigFrog()),
	GIANT_FROG(new GiantFrog()),
	WEAK_GOBLIN(new WeakGoblin()),
	SEAGULL(new Seagull());
	
	public final Monster MONSTER;
	
	MONSTER(Monster monster)
	{
		MONSTER = monster;
	}
	
	public static MONSTER getAppropriate(Combat combat)
	{
		List<MONSTER> potentials = new ArrayList<>();
		int bestLvl = -1;
		final int PLAYER_LVL = combat.getCombatLevel();
		for(MONSTER m : values())
		{
			final int REQ_LVL = m.MONSTER.REQUIRED_COMBAT_LVL;
			if(REQ_LVL < bestLvl)
				continue;
			
			if(REQ_LVL <= PLAYER_LVL)
			{
				if(!potentials.isEmpty() && potentials.get(0).MONSTER.REQUIRED_COMBAT_LVL < REQ_LVL)
					potentials.clear();
				
				potentials.add(m);
				bestLvl = REQ_LVL;
			}
		}
		
		return potentials.get(MethodProvider.random(0, potentials.size() - 1));
	}
	
	public static List<LOCATION> getSupportedLocs(MONSTER m)
	{
		List<LOCATION> supported = new ArrayList<>();
		for(LOCATION loc : LOCATION.values())
			for(MONSTER mo : loc.LOCATION.SUPPORTED_MONSTERS)
				if(mo == m)
					supported.add(loc);
		
		return supported;
	}
}
