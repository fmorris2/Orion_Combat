package org.data.location.goblin;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class EastLumbridgeGoblins extends CombatLocation
{

	@Override
	protected MONSTER[] getSupportedMonsters()
	{
		return new MONSTER[]{MONSTER.WEAK_GOBLIN};
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
		return new Area(3239, 3258, 3267, 3214);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3254, 3239, 0);
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
