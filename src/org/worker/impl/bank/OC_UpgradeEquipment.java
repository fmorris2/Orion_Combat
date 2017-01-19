package org.worker.impl.bank;

import java.util.List;

import org.OrionCombat;
import org.worker.OCWorker;

public class OC_UpgradeEquipment extends OCWorker
{
	public OC_UpgradeEquipment(OrionCombat mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return !mission.EQUIPMENT_MANAGER.getUpgrades().isEmpty();
	}

	@Override
	public void work()
	{
		List<Integer> upgrades = mission.EQUIPMENT_MANAGER.getUpgrades();
		script.log(this, false, "Upgrade equipment - " + upgrades.size() + " upgrades");
		
		if(bank.isOpen())
			bank.close();
		else
		{
			script.log(this, false, "Equip upgrades");
		}
		
	}
	
	public boolean needsBankTrip()
	{
		List<Integer> upgrades = mission.EQUIPMENT_MANAGER.getUpgrades();
		for(Integer i : upgrades)
			if(!inventory.contains(i))
				return true;
		
		return false;
	}

}
