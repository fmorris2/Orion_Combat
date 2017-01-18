package org.data.enums;

import org.data.location.CombatLocation;
import org.data.location.chicken.LumbridgeChickens;

public enum LOCATION
{
	OC_LUM_CHICKENS(new LumbridgeChickens());
	
	public final CombatLocation LOCATION;
	LOCATION(CombatLocation location)
	{
		LOCATION = location;
	}
}
