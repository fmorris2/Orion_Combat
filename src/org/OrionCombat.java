package org;

import org.data.enums.CombatType;
import org.data.enums.LOCATION;
import org.data.enums.MONSTER;
import org.data.enums.equipment.EquipmentIMGenerator;
import org.data.enums.equipment.Food;
import org.data.location.CombatLocation;
import org.data.monster.Monster;
import org.worker.OCWorkerManager;

import viking.framework.goal.Goal;
import viking.framework.goal.GoalList;
import viking.framework.item_management.IMEntry;
import viking.framework.item_management.ItemManagement;
import viking.framework.mission.Mission;
import viking.framework.mule.MuleManagement;
import viking.framework.mule.MuleOrder;
import viking.framework.script.VikingScript;

public class OrionCombat extends Mission implements ItemManagement, MuleManagement
{
	private static final int CYCLE_TIME = 600;
	
	public final CombatType COMBAT_TYPE;
	public final OC_EquipmentManager EQUIPMENT_MANAGER;
	public final boolean IS_LOOTING;
	public final MONSTER TARGET;
	public final OCWorkerManager MANAGER;
	
	private final OC_ProgressionManager PROGRESSION;
	
	public Food food;
	
	private MONSTER monster;
	private LOCATION location;
	
	public OrionCombat(VikingScript script, CombatType combatType, MONSTER target, boolean isLooting, Goal... goals)
	{
		super(script);
		this.goals = new GoalList(goals);
		COMBAT_TYPE = combatType;
		TARGET = target;
		IS_LOOTING = isLooting;
		MANAGER = new OCWorkerManager(this);
		PROGRESSION = new OC_ProgressionManager(this);
		EQUIPMENT_MANAGER = new OC_EquipmentManager(this);
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
		return MANAGER.getCurrent().toString();
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
	{return null;}

	@Override
	public int execute()
	{
		PROGRESSION.progress();
		MANAGER.work();
		return CYCLE_TIME;
	}

	@Override
	public void onMissionStart()
	{}

	@Override
	public void resetPaint()
	{}

	@Override
	public MuleOrder getOrder()
	{
		return new MuleOrder(script, getMonster().LOOT_IDS);
	}

	@Override
	public IMEntry[] itemsToBuy()
	{
		return EquipmentIMGenerator.generate(this, COMBAT_TYPE);
	}

	@Override
	public int[] itemsToSell()
	{
		return getMonster().LOOT_IDS;
	}
	
	public Monster getMonster()
	{	
		if(monster == null)
			PROGRESSION.progress();
		
		return monster.MONSTER;
	}
	
	public void setMonster(MONSTER m)
	{
		monster = m;
	}
	
	public CombatLocation getLocation()
	{
		if(location == null)
			PROGRESSION.progress();
		
		return location.LOCATION;
	}
	
	public LOCATION getLocEnum()
	{
		return location;
	}
	
	public MONSTER getMonsterEnum()
	{
		return monster;
	}
	
	public void setLocation(LOCATION loc)
	{
		location = loc;
	}
}
