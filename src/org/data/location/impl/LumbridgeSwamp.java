package org.data.location.impl;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class LumbridgeSwamp extends CombatLocation
{

	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.WEAK_GIANT_RAT, MONSTER.NORMAL_FROG, MONSTER.BIG_FROG, MONSTER.GIANT_FROG};
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
	public Area constructArea()
	{
		return new Area(3156, 3201, 3237, 3159);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3200, 3179, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
