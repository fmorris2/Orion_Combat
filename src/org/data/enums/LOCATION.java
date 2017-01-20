package org.data.enums;

import org.data.location.CombatLocation;
import org.data.location.chicken.FaladorChickens;
import org.data.location.chicken.LumbridgeChickens;
import org.data.location.chicken.WindmillChickens;
import org.data.location.cow.FaladorCows;
import org.data.location.cow.LumbridgeCows;
import org.data.location.cow.WindmillCows;
import org.data.location.goblin.EastLumbridgeGoblins;
import org.data.location.goblin.PortSarimGoblins;
import org.data.location.impl.LumbridgeSwamp;
import org.data.location.impl.PortSarimSeagulls;

public enum LOCATION
{
	OC_LUM_CHICKENS(new LumbridgeChickens()),
	OC_LUM_COWS(new LumbridgeCows()),
	OC_WIN_COWS(new WindmillCows()),
	OC_FAL_COWS(new FaladorCows()),
	OC_LUM_SWAMP(new LumbridgeSwamp()),
	OC_LUM_EAST_GOB(new EastLumbridgeGoblins()),
	OC_WIN_CHICKS(new WindmillChickens()),
	OC_FAL_CHICKS(new FaladorChickens()),
	OC_PORT_SEAGULLS(new PortSarimSeagulls()),
	OC_PORT_GOBLINS(new PortSarimGoblins());
	
	public final CombatLocation LOCATION;
	LOCATION(CombatLocation location)
	{
		LOCATION = location;
	}
}
