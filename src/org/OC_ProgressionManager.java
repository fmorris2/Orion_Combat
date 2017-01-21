package org;

import java.util.List;

import org.data.enums.LOCATION;
import org.data.enums.MONSTER;
import org.data.enums.equipment.Food;
import org.osbot.rs07.script.MethodProvider;

public class OC_ProgressionManager
{
	private OrionCombat mission;
	
	public OC_ProgressionManager(OrionCombat mission)	
	{
		this.mission = mission;
	}
	
	public boolean progress()
	{
		mission.food = Food.getApprop(mission.combat.getCombatLevel());
		
		final MONSTER APPROP = MONSTER.getAppropriate(mission.combat);
		
		final MONSTER OLD = mission.getMonsterEnum() == null ? null : mission.getMonsterEnum();
		final MONSTER TARGET = mission.TARGET == null ? null : mission.TARGET;	
		
		if(OLD != null && (OLD == TARGET || OLD == APPROP))
			return false;
		
		if(OLD != null && OLD.MONSTER.REQUIRED_COMBAT_LVL == APPROP.MONSTER.REQUIRED_COMBAT_LVL && APPROP != TARGET)
			return false;
		
		if(TARGET != null && mission.combat.getCombatLevel() >= TARGET.MONSTER.REQUIRED_COMBAT_LVL)
		{
			mission.setMonster(TARGET);
			setLocation(TARGET);
		}
		else
		{
			mission.setMonster(APPROP);
			setLocation(APPROP);
		}
		//TODO QUERY OCC FOR APPROPRIATE LOCATION
		
		
		mission.getScript().log(this, false, "Progessing to " + APPROP + " at location " + mission.getLocEnum());
		
		return true;
	}
	
	private void setLocation(MONSTER m)
	{
		List<LOCATION> supported = MONSTER.getSupportedLocs(m);
		mission.setLocation(supported.get(MethodProvider.random(0, supported.size() - 1)));
	}
}
