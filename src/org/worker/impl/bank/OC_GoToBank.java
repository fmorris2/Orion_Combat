package org.worker.impl.bank;

import org.OrionCombat;
import org.worker.OCWorker;

import viking.api.banking.enums.BankLocation;

public class OC_GoToBank extends OCWorker
{
	private final boolean ACCEPT_DEPOSIT_BOX;
	public OC_GoToBank(OrionCombat mission, boolean b)
	{
		super(mission);
		ACCEPT_DEPOSIT_BOX = b;
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}

	@Override
	public void work()
	{
		script.log(this, false, "Go to bank");
		BankLocation bank = mission.getLocation().BANK;
		if(!ACCEPT_DEPOSIT_BOX && bank.isDepositBox())
			walking.webWalk(bankUtils.getAllBanks(false, false));
		else
			walkUtils.walkToArea(bank.getArea());
	}

}
