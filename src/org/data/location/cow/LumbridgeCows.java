package org.data.location.cow;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class LumbridgeCows extends CombatLocation
{

	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.COW};
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
		return new Area(new int[][] { { 3263, 3298 }, { 3261, 3298 }, { 3260, 3298 }, { 3260, 3299 }, { 3257, 3299 },
				{ 3257, 3298 }, { 3241, 3298 }, { 3241, 3295 }, { 3242, 3295 }, { 3242, 3293 }, { 3243, 3293 },
				{ 3243, 3289 }, { 3242, 3289 }, { 3242, 3287 }, { 3241, 3287 }, { 3241, 3284 }, { 3242, 3284 },
				{ 3242, 3283 }, { 3243, 3283 }, { 3243, 3282 }, { 3244, 3282 }, { 3244, 3281 }, { 3245, 3281 },
				{ 3245, 3279 }, { 3249, 3279 }, { 3249, 3278 }, { 3250, 3278 }, { 3250, 3277 }, { 3251, 3277 },
				{ 3251, 3276 }, { 3252, 3276 }, { 3252, 3273 }, { 3254, 3273 }, { 3254, 3255 }, { 3265, 3255 },
				{ 3265, 3296 } });
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3258, 3279, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

	@Override
	protected BankLocation getBank()
	{
		return BankLocation.LUMBRIDGE_UPPER;
	}

}
