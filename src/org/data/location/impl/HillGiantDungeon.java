package org.data.location.impl;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class HillGiantDungeon extends CombatLocation
{
	private static final Position NE_CORNER = new Position(3135, 9860, 0);
	private static final Position SW_CORNER = new Position(3090, 9820, 0);
	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.HILL_GIANT};
	}

	@Override
	protected int[] getRequiredItems()
	{
		return new int[]{983};
	}

	@Override
	protected Position[] getSafeSpots()
	{
		return null;
	}

	@Override
	protected BankLocation getBank()
	{
		return BankLocation.VARROCK_WEST;
	}

	@Override
	public Area constructArea()
	{
		return new Area(SW_CORNER, NE_CORNER);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3113, 9836, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
