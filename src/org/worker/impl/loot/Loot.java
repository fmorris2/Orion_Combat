package org.worker.impl.loot;

import org.OrionCombat;
import org.osbot.rs07.api.model.GroundItem;
import org.worker.OCWorker;

import viking.api.Timing;

public class Loot extends OCWorker
{
	private boolean mandatoryLoot;
	
	public Loot(OrionCombat mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}

	@Override
	public void work()
	{
		script.log(this, false, "Loot");
		int[][] loot = mission.getMonster().LOOT;
		for(int i = 0; i < loot.length; i++)
		{
			if(mandatoryLoot && loot[i][1] == 0)
				continue;
			
			final int ID = loot[i][0];
			GroundItem item = groundItems.closest(ID);
			long invCount = inventory.getAmount(ID);
			if(item != null && iFact.clickGroundItem("Take", item).execute())
				Timing.waitCondition(() -> inventory.getAmount(ID) != invCount, 3500);
		}
		
		mandatoryLoot = false;
	}
	
	//this method is for if something appears on the ground that we NEED to loot
	public boolean needsToLoot()
	{
		int[][] loot = mission.getMonster().LOOT;
		for(int i = 0; i < loot.length; i++)
		{
			if(loot[i][1] == 1 && groundItems.closest(loot[i][0]) != null)
			{
				mandatoryLoot = true;
				return true;
			}
		}
		return false;
	}

}
