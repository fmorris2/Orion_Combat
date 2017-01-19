package org.worker;

import java.util.List;

import org.OrionCombat;
import org.data.enums.CombatType;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.model.Item;
import org.worker.impl.bank.OC_DepositItems;
import org.worker.impl.bank.OC_GoToBank;
import org.worker.impl.bank.OC_UpgradeEquipment;
import org.worker.impl.bank.OC_WithdrawUpgrades;
import org.worker.impl.fight.MagicFight;
import org.worker.impl.fight.MeleeFight;
import org.worker.impl.fight.RangeFight;
import org.worker.impl.location.OC_GoToLocation;
import org.worker.impl.loot.Loot;

import viking.framework.worker.Worker;
import viking.framework.worker.WorkerManager;

public class OCWorkerManager extends WorkerManager<OrionCombat>
{
	private final OCWorker GO_TO_BANK, MAGIC_FIGHT, MELEE_FIGHT, RANGE_FIGHT,
		LOOT, GO_TO_LOCATION, WITHDRAW_UPGRADES;
	
	private final OC_DepositItems DEPOSIT_ITEMS;
	private final OC_UpgradeEquipment UPGRADE_EQUIPMENT;
	
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
		WITHDRAW_UPGRADES = new OC_WithdrawUpgrades(mission);
	}

	@Override
	public Worker<OrionCombat> decide()
	{
		final boolean IN_BANK = mission.bankUtils.isInBank(false);
		//check bank if cache is empty, if it is we need to go check the bank
		if(mission.getScript().BANK_CACHE.get().isEmpty())
		{
			debug("Bank cache is empty, going to bank to fill it...");
			return IN_BANK ? DEPOSIT_ITEMS : GO_TO_BANK;
		}
		
		//check for equipment upgrades
		if(!mission.EQUIPMENT_MANAGER.getUpgrades().isEmpty())
		{
			debug("Equipment upgrades available...");
			if(UPGRADE_EQUIPMENT.needsBankTrip())
				return IN_BANK ? WITHDRAW_UPGRADES : GO_TO_BANK;
			
			return UPGRADE_EQUIPMENT;
		}
		
		if(inventory.isFull()) //inventory full checks
		{
			debug("Inventory full checks");
			
			if(IN_BANK)
				return DEPOSIT_ITEMS;
			
			return GO_TO_BANK;
		}
		
		if(IN_BANK && hasErroneousItems())
		{
			debug("Depositing erroneous items...");
			return DEPOSIT_ITEMS;
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
	
	private boolean hasErroneousItems()
	{
		List<Integer> dontDeposit = DEPOSIT_ITEMS.getDontDepositList();
		for(Item i : inventory.getItems())
			if(i != null && !dontDeposit.contains(i.getId()))
				return true;
			
		return false;
	}
	
	private void debug(String s)
	{
		mission.getScript().log(this, false, s);
	}

}
