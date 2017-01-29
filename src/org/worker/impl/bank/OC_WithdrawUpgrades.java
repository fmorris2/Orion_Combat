package org.worker.impl.bank;

import java.util.List;

import org.OrionCombat;
import org.worker.OCWorker;

public class OC_WithdrawUpgrades extends OCWorker
{

	public OC_WithdrawUpgrades(OrionCombat mission)
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
		if(!bank.isOpen())
			bankUtils.open();
		else if(inventory.isFull())
			bank.depositAll();
		else
		{
			try
			{
				List<Integer> upgrades = mission.EQUIPMENT_MANAGER.getUpgrades();
				for(int i : upgrades)
					if(!inventory.contains(i))
						bank.withdraw(i, 1);
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				script.log(this, false, "There was an ArrayIndexOutOfBoundsException thrown by bank.withdraw in the OSBot API");
			}
		}
		
	}

}
