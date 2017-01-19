package org.data.enums;

import org.data.location.CombatLocation;
import org.data.location.chicken.LumbridgeChickens;
import org.data.location.cow.FaladorCows;
import org.data.location.cow.LumbridgeCows;
import org.data.location.cow.WindmillCows;

public enum LOCATION
{
	OC_LUM_CHICKENS(new LumbridgeChickens()),
	OC_LUM_COWS(new LumbridgeCows()),
	OC_WIN_COWS(new WindmillCows()),
	OC_FAL_COWS(new FaladorCows());
	
	public final CombatLocation LOCATION;
	LOCATION(CombatLocation location)
	{
		LOCATION = location;
	}
}
