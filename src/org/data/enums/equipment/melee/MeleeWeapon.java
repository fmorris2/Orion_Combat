package org.data.enums.equipment.melee;

public enum MeleeWeapon
{
	IRON_SCIMITAR(1, 150, 1323),
	STEEL_SCIMITAR(5, 200, 1325),
	MITHRIL_SCIMITAR(20, 750, 1329),
	ADAMANT_SCIMITAR(30, 3000, 1331),
	RUNE_SCIMITAR(40, 22000, 1333);
	
	public final int ATT_REQ, PRICE, ITEM_ID;
	MeleeWeapon(int attReq, int price, int itemID)
	{
		ATT_REQ = attReq;
		PRICE = price;
		ITEM_ID = itemID;
	}
}
