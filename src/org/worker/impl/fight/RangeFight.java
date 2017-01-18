package org.worker.impl.fight;

import org.OrionCombat;
import org.worker.OCWorker;

public class RangeFight extends OCWorker
{

	public RangeFight(OrionCombat mission)
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
