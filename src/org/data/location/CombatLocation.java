package org.data.location;

import org.data.enums.MONSTER;

import viking.api.location.Location;

public abstract class CombatLocation extends Location
{
	public final MONSTER SUPPORTED_MONSTER;
	
	public CombatLocation()
	{
		super();
		SUPPORTED_MONSTER = getSupportedMonster();
	}
	
	protected abstract MONSTER getSupportedMonster();
}
