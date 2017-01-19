package org.data.location;

import org.data.enums.MONSTER;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;
import viking.api.location.Location;

public abstract class CombatLocation extends Location
{
	public final MONSTER[] SUPPORTED_MONSTERS;
	public final int[] REQUIRED_ITEMS;
	public final Position[] SAFE_SPOTS;
	public final BankLocation BANK;
	
	public CombatLocation()
	{
		super();
		SUPPORTED_MONSTERS = getSupportedMonsters();
		REQUIRED_ITEMS = getRequiredItems();
		SAFE_SPOTS = getSafeSpots();
		BANK = getBank();
	}
	
	protected abstract MONSTER[] getSupportedMonsters();
	protected abstract int[] getRequiredItems();
	protected abstract Position[] getSafeSpots();
	protected abstract BankLocation getBank();
}
