package org.data.location.impl;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class PortSarimSeagulls extends CombatLocation
{

	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.SEAGULL};
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
		return new Area(3024, 3241, 3044, 3222);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3028, 3235, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
