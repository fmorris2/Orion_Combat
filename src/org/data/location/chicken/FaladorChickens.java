package org.data.location.chicken;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class FaladorChickens extends CombatLocation
{

	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.CHICKEN};
	}

	@Override
	protected int[] getRequiredItems()
	{
		return null;
	}

	@Override
	protected Position[] getSafeSpots()
	{
		return null;
	}

	@Override
	protected BankLocation getBank()
	{
		return BankLocation.PORT_SARIM_DEPOSIT_BOX;
	}

	@Override
	public Area constructArea()
	{
		return new Area(3020, 3282, 3014, 3298);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3017, 3290, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
