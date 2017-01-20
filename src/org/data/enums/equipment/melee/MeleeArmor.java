package org.data.enums.equipment.melee;

public enum MeleeArmor
{
	WOODEN_SHIELD(0, 50, 1171, false),
	LEATHER_BOOTS(1, 100, 1061, true),
	LEATHER_GLOVES(1, 100, 1059, true),
	RED_CAPE(1, 200, 1007, true),
	AMULET_OF_STRENGTH(1, 2000, 1725, true),
	IRON_FULL_HELM(1, 300, 1153, false),
	IRON_PLATEBODY(1, 300, 1115, false),
	IRON_PLATELEGS(1, 300, 1067, false),
	IRON_KITESHIELD(1, 150, 1191, false),
	STEEL_FULL_HELM(1, 750, 1157, false),
	STEEL_PLATEBODY(1, 1350, 1119, false),
	STEEL_PLATELEGS(1, 750, 1069, false),
	STEEL_KITESHIELD(1, 650, 1193, false),
	MITHRIL_FULL_HELM(20, 1000, 1159, false),
	MITHRIL_PLATEBODY(20, 3750, 1121, false),
	MITHRIL_PLATELEGS(20, 2000, 1071, false),
	MITHRIL_KITESHIELD(20, 1750, 1197, false),
	ADAMANT_FULL_HELM(30, 2500, 1161, false),
	ADAMANT_PLATEBODY(30, 12500, 1123, false),
	ADAMANT_PLATELEGS(30, 5500, 1073, false),
	ADAMANT_KITESHIELD(30, 4250, 1199, false),
	RUNE_FULL_HELM(40, 27500, 1163, false),
	RUNE_CHAINBODY(40, 40000, 1113, false),
	RUNE_PLATELEGS(40, 50000, 1079, false),
	RUNE_KITESHIELD(40, 45000, 1201, false);
	
	public final int DEF_LVL, PRICE, ITEM_ID;
	public final boolean OVERRIDE;
	MeleeArmor(int defLvl, int price, int itemID, boolean overrideOthers)
	{
		DEF_LVL = defLvl;
		PRICE = price;
		ITEM_ID = itemID;
		OVERRIDE = overrideOthers;
	}
}
