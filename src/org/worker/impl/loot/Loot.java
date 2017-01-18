package org.worker.impl.loot;

import org.OrionCombat;
import org.worker.OCWorker;

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
	}

}
