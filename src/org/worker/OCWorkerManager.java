package org.worker;

import org.OrionCombat;
import org.data.enums.CombatType;
import org.data.location.CombatLocation;
import org.worker.impl.bank.OC_DepositItems;
import org.worker.impl.bank.OC_GoToBank;
import org.worker.impl.bank.OC_UpgradeEquipment;
import org.worker.impl.fight.MagicFight;
import org.worker.impl.fight.MeleeFight;
import org.worker.impl.fight.RangeFight;
import org.worker.impl.location.OC_GoToLocation;
import org.worker.impl.loot.Loot;

import viking.framework.worker.Worker;
import viking.framework.worker.WorkerManager;

public class OCWorkerManager extends WorkerManager<OrionCombat>
{
	private final OCWorker DEPOSIT_ITEMS, GO_TO_BANK, MAGIC_FIGHT, MELEE_FIGHT, RANGE_FIGHT,
		LOOT, UPGRADE_EQUIPMENT, GO_TO_LOCATION;
	
	public OCWorkerManager(OrionCombat mission)
	{
		super(mission);
		DEPOSIT_ITEMS = new OC_DepositItems(mission);
		GO_TO_BANK = new OC_GoToBank(mission);
		MAGIC_FIGHT = new MagicFight(mission);
		MELEE_FIGHT = new MeleeFight(mission);
		RANGE_FIGHT = new RangeFight(mission);
		LOOT = new Loot(mission);
		UPGRADE_EQUIPMENT = new OC_UpgradeEquipment(mission);
		GO_TO_LOCATION = new OC_GoToLocation(mission);
	}

	@Override
	public Worker<OrionCombat> decide()
	{
		//check bank if cache is empty, if it is we need to go check the bank
		if(mission.getScript().BANK_CACHE.get().isEmpty())
		{
			debug("Bank cache is empty, going to bank to fill it...");
			return mission.bankUtils.isInBank(false) ? DEPOSIT_ITEMS : GO_TO_BANK;
		}
		
		//check for equipment upgrades
		if(!mission.EQUIPMENT_MANAGER.getUpgrades().isEmpty())
		{
			debug("Equipment upgrades available...");
			return UPGRADE_EQUIPMENT;
		}
		
		if(inventory.isFull()) //inventory full checks
		{
			debug("Inventory full checks");
			
			if(mission.bankUtils.isInBank(false))
				return DEPOSIT_ITEMS;
			
			return GO_TO_BANK;
		}
		
		//has required equipment, inventory is not full
		return locChecks();
	}
	
	private OCWorker locChecks()
	{
		CombatLocation loc = mission.getLocation();
		if(loc.isIn(myPlayer()))
		{
			debug("Player is at location");
			if(mission.COMBAT_TYPE == CombatType.MELEE) return MELEE_FIGHT;
			if(mission.COMBAT_TYPE == CombatType.RANGE) return RANGE_FIGHT;
			return MAGIC_FIGHT;
		}
		else
		{
			debug("Player is not at location");
			return GO_TO_LOCATION;
		}
	}
	
	private void debug(String s)
	{
		mission.getScript().log(this, false, s);
	}

}
