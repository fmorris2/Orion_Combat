package org;

import org.data.enums.MONSTER;
import org.data.enums.equipment.Food;
import org.data.monster.Monster;

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
		
		final Monster OLD = mission.getMonster();
		final Monster NEW = APPROP.MONSTER;
		final Monster TARGET = mission.TARGET.MONSTER;
		
		if(OLD == TARGET || OLD == NEW)
			return false;
		
		mission.setMonster(APPROP);
		
		//TODO QUERY OCC FOR APPROPRIATE LOCATION
		mission.setLocation(MONSTER.getSupportedLocs(APPROP).get(0));
		
		mission.getScript().log(this, false, "Progessing to " + APPROP + " at location " + mission.getLocEnum());
		
		return true;
	}
}
