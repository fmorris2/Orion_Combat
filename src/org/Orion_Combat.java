package org;

import org.data.enums.CombatType;
import org.data.enums.LOCATION;
import org.data.enums.MONSTER;
import org.data.enums.equipment.EquipmentIMGenerator;
import org.data.location.CombatLocation;
import org.data.monster.Monster;

import viking.framework.goal.Goal;
import viking.framework.goal.GoalList;
import viking.framework.item_management.IMEntry;
import viking.framework.item_management.ItemManagement;
import viking.framework.mission.Mission;
import viking.framework.mule.MuleManagement;
import viking.framework.mule.MuleOrder;
import viking.framework.script.VikingScript;

public class Orion_Combat extends Mission implements ItemManagement, MuleManagement
{
	public final CombatType COMBAT_TYPE;
	
	private final MONSTER TARGET;
	
	private MONSTER monster;
	private LOCATION location;
	
	public Orion_Combat(VikingScript script, CombatType combatType, MONSTER target, Goal... goals)
	{
		super(script);
		this.goals = new GoalList(goals);
		COMBAT_TYPE = combatType;
		TARGET = target;
	}

	@Override
	public boolean canEnd()
	{
		return goals.hasReachedGoals();
	}

	@Override
	public String getMissionName()
	{
		return "Orion Combat";
	}

	@Override
	public String getCurrentTaskName()
	{
		return null;
	}

	@Override
	public String getEndMessage()
	{
		return "Orion Combat has ended";
	}

	@Override
	public GoalList getGoals()
	{
		return goals;
	}

	@Override
	public String[] getMissionPaint()
	{
		return null;
	}

	@Override
	public int execute()
	{
		return 600;
	}

	@Override
	public void onMissionStart()
	{
		//set appropriate monster if necessary
		
		//set appropriate location if necessary
	}

	@Override
	public void resetPaint()
	{
	}

	@Override
	public MuleOrder getOrder()
	{
		return new MuleOrder(script, getMonster().LOOT);
	}

	@Override
	public IMEntry[] itemsToBuy()
	{
		return EquipmentIMGenerator.generate(this, COMBAT_TYPE);
	}

	@Override
	public int[] itemsToSell()
	{
		return getMonster().LOOT;
	}
	
	public Monster getMonster()
	{
		return monster.MONSTER;
	}
	
	public CombatLocation getLocation()
	{
		return location.LOCATION;
	}
}
