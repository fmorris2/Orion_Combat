package org.worker.impl.loot;

import org.OrionCombat;
import org.osbot.rs07.api.model.GroundItem;
import org.worker.OCWorker;

import viking.api.Timing;

public class Loot extends OCWorker
{

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
			final int ID = loot[i][0];
			GroundItem item = groundItems.closest(ID);
			long invCount = inventory.getAmount(ID);
			if(item != null && iFact.clickGroundItem("Take", item).execute())
				Timing.waitCondition(() -> inventory.getAmount(ID) != invCount, 3500);	
		}
	}
	
	//this method is for if something appears on the ground that we NEED to loot
	public boolean needsToLoot()
	{
		int[][] loot = mission.getMonster().LOOT;
		for(int i = 0; i < loot.length; i++)
			if(loot[i][1] == 1 && groundItems.closest(loot[i][0]) != null)
				return true;
		
		return false;
	}

}
