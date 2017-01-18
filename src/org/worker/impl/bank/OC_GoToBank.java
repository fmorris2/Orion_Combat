package org.worker.impl.bank;

import org.OrionCombat;
import org.worker.OCWorker;

public class OC_GoToBank extends OCWorker
{

	public OC_GoToBank(OrionCombat mission)
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
		script.log(this, false, "Go to bank");
		walking.webWalk(bankUtils.getAllBanks(false, false));
	}

}
