package org.worker;

import org.OrionCombat;

import viking.framework.worker.Worker;

public abstract class OCWorker extends Worker<OrionCombat>
{

	public OCWorker(OrionCombat mission)
	{
		super(mission);
	}
}
