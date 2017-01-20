package org;

import java.util.List;

import org.data.enums.LOCATION;
import org.data.enums.MONSTER;
import org.data.enums.equipment.Food;
import org.data.monster.Monster;
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
		
		final Monster OLD = mission.getMonsterEnum() == null ? null : mission.getMonster();
		final Monster NEW = APPROP.MONSTER;
		final Monster TARGET = mission.TARGET == null ? null : mission.TARGET.MONSTER;
		
		if(OLD != null && (OLD == TARGET || OLD == NEW))
			return false;
		
		if(OLD.REQUIRED_COMBAT_LVL == NEW.REQUIRED_COMBAT_LVL)
			return false;
		
		mission.setMonster(APPROP);
		
		//TODO QUERY OCC FOR APPROPRIATE LOCATION
		List<LOCATION> supported = MONSTER.getSupportedLocs(APPROP);
		mission.setLocation(supported.get(MethodProvider.random(0, supported.size() - 1)));
		
		mission.getScript().log(this, false, "Progessing to " + APPROP + " at location " + mission.getLocEnum());
		
		return true;
	}
}
