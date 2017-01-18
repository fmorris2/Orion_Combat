package org.worker.impl.bank;

import org.OrionCombat;
import org.worker.OCWorker;

public class OC_DepositItems extends OCWorker
{

	public OC_DepositItems(OrionCombat mission)
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
	}

}
