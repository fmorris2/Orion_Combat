package org.worker.impl.location;

import org.OrionCombat;
import org.worker.OCWorker;

public class OC_GoToLocation extends OCWorker
{

	public OC_GoToLocation(OrionCombat mission)
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
