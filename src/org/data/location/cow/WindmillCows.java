package org.data.location.cow;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class WindmillCows extends CombatLocation
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
		return new Area(new int[][] { { 3155, 3316 }, { 3156, 3315 }, { 3161, 3315 }, { 3162, 3316 }, { 3163, 3317 },
				{ 3164, 3318 }, { 3165, 3319 }, { 3169, 3319 }, { 3169, 3318 }, { 3170, 3317 }, { 3176, 3317 },
				{ 3176, 3316 }, { 3179, 3316 }, { 3179, 3315 }, { 3185, 3315 }, { 3185, 3314 }, { 3188, 3311 },
				{ 3190, 3311 }, { 3190, 3310 }, { 3192, 3309 }, { 3195, 3309 }, { 3195, 3308 }, { 3199, 3308 },
				{ 3200, 3309 }, { 3202, 3309 }, { 3203, 3310 }, { 3208, 3310 }, { 3208, 3309 }, { 3210, 3309 },
				{ 3209, 3316 }, { 3203, 3322 }, { 3202, 3326 }, { 3201, 3328 }, { 3202, 3331 }, { 3201, 3332 },
				{ 3200, 3333 }, { 3199, 3334 }, { 3194, 3334 }, { 3193, 3335 }, { 3192, 3335 }, { 3191, 3336 },
				{ 3190, 3336 }, { 3186, 3340 }, { 3185, 3340 }, { 3184, 3341 }, { 3183, 3341 }, { 3182, 3342 },
				{ 3181, 3342 }, { 3179, 3344 }, { 3177, 3342 }, { 3165, 3342 }, { 3164, 3343 }, { 3163, 3343 },
				{ 3162, 3344 }, { 3161, 3344 }, { 3160, 3345 }, { 3159, 3346 }, { 3158, 3346 }, { 3157, 3347 },
				{ 3155, 3347 }, { 3154, 3346 }, { 3154, 3344 }, { 3153, 3343 }, { 3153, 3338 }, { 3154, 3337 },
				{ 3154, 3334 }, { 3155, 3333 }, { 3155, 3331 }, { 3154, 3330 }, { 3154, 3327 }, { 3153, 3326 },
				{ 3153, 3323 }, { 3154, 3322 }, { 3154, 3319 }, { 3155, 3318 } });
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3180, 3326, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
