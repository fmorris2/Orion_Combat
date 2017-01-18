package org.worker.impl.fight;

import org.OrionCombat;
import org.worker.OCWorker;

public class MagicFight extends OCWorker
{

	public MagicFight(OrionCombat mission)
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
