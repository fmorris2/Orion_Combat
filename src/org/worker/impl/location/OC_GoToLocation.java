package org.worker.impl.location;

import org.OrionCombat;
import org.data.location.CombatLocation;
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
		script.log(this, false, "Going to location!");
		CombatLocation l = mission.getLocation();
		walkUtils.walkTo(l.getCenterTile(), mission.conditions.inAreaCondition(l.getArea()), null, 400, 400);
	}

}
