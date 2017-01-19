package org.data.location.cow;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class FaladorCows extends CombatLocation
{

	@Override
	protected MONSTER getSupportedMonster()
	{
		return MONSTER.COW;
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
		return new Area(new int[][] { { 3022, 3297 }, { 3022, 3311 }, { 3023, 3312 }, { 3041, 3312 }, { 3042, 3311 },
				{ 3042, 3300 }, { 3040, 3298 }, { 3039, 3299 }, { 3032, 3299 }, { 3031, 3298 }, { 3029, 3298 },
				{ 3028, 3297 } });
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3031, 3305, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
