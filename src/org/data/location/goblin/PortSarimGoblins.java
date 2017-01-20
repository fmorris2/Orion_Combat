package org.data.location.goblin;

import org.data.enums.MONSTER;
import org.data.location.CombatLocation;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

import viking.api.banking.enums.BankLocation;

public class PortSarimGoblins extends CombatLocation
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
	protected BankLocation getBank()
	{
		return BankLocation.PORT_SARIM_DEPOSIT_BOX;
	}

	@Override
	public Area constructArea()
	{
		return new Area(2984, 3225, 3008, 3201);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3000, 3202, 0);
	}

	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	}

}
