package org.worker.impl.fight;

import org.OrionCombat;
import org.osbot.rs07.api.filter.Filter;
import org.osbot.rs07.api.filter.NameFilter;
import org.osbot.rs07.api.model.NPC;
import org.worker.OCWorker;

import viking.api.Timing;
import viking.api.condition.VCondition;
import viking.api.filter.VFilters;

public class MeleeFight extends OCWorker
{

	public MeleeFight(OrionCombat mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void work()
	{
		if(combat.isFighting())
		{
			script.log(this, false, "Is fighting...");
			mission.MANAGER.needsToLoot = true;
		}
		else
		{
			script.log(this, false, "Searching for target");
			Filter<NPC> nameFilter = new NameFilter<NPC>(mission.getMonster().NAMES);
			Filter<NPC> combined = VFilters.and(nameFilter, filters.ABLE_TO_ATTACK_NPC);
			NPC target = npcs.closest(combined);
			if(target != null && iFact.clickNpc("Attack", target).execute())
			{
				VCondition condition = conditions.IN_COMBAT.or(conditions.stolenEntity(target));
				Timing.waitCondition(condition, 4500);
				mission.MANAGER.needsToLoot = false;
			}
			else
				script.log(this, false, "No targets found..");
		}
	}

}
