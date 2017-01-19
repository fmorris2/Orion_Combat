package org.data.enums;

import org.data.location.CombatLocation;
import org.data.location.chicken.LumbridgeChickens;
import org.data.location.cow.LumbridgeCows;

public enum LOCATION
{
	OC_LUM_CHICKENS(new LumbridgeChickens()),
	OC_LUM_COWS(new LumbridgeCows());
	
	public final CombatLocation LOCATION;
	LOCATION(CombatLocation location)
	{
		LOCATION = location;
	}
}
