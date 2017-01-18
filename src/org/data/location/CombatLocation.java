package org.data.location;

import org.data.enums.MONSTER;
import org.osbot.rs07.api.map.Position;

import viking.api.location.Location;

public abstract class CombatLocation extends Location
{
	public final MONSTER SUPPORTED_MONSTER;
	public final int[] REQUIRED_ITEMS;
	public final Position[] SAFE_SPOTS;
	
	public CombatLocation()
	{
		super();
		SUPPORTED_MONSTER = getSupportedMonster();
		REQUIRED_ITEMS = getRequiredItems();
		SAFE_SPOTS = getSafeSpots();
	}
	
	protected abstract MONSTER getSupportedMonster();
	protected abstract int[] getRequiredItems();
	protected abstract Position[] getSafeSpots();
}
