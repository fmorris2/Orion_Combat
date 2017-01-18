package org;

import java.util.ArrayList;
import java.util.List;

import org.data.enums.equipment.melee.MeleeArmor;
import org.data.enums.equipment.melee.MeleeWeapon;
import org.osbot.rs07.api.Skills;
import org.osbot.rs07.api.ui.Skill;

public class OC_EquipmentManager
{
	private OrionCombat mission;
	
	public OC_EquipmentManager(OrionCombat mission)
	{
		this.mission = mission;
	}
	
	public List<Integer> getUpgrades()
	{	
		switch(mission.COMBAT_TYPE)
		{
			case MELEE:
				return getMeleeUpgrades();
			case RANGE:
				return getRangeUpgrades();
			default:
				return getMagicUpgrades();
		}
	}
	
	private List<Integer> getMeleeUpgrades()
	{
		List<Integer> upgrades = new ArrayList<>();
		
		final MeleeWeapon[] WEPS = MeleeWeapon.values();
		final MeleeArmor[] ARMOR = MeleeArmor.values();
		
		Skills s = mission.skills;
		int bestWepAttReq = -1;
		int bestArmorDefReq = -1;
		
		//weapons first
		for(int i = WEPS.length - 1; i >= 0; i--)
		{
			MeleeWeapon wep = WEPS[i];
			if(wep.ATT_REQ <= s.getStatic(Skill.ATTACK) && !hasEquipped(wep.ITEM_ID) && hasItem(wep.ITEM_ID)
					&& wep.ATT_REQ > bestWepAttReq)
			{
				upgrades.add(wep.ITEM_ID);
				bestWepAttReq = wep.ATT_REQ;
			}
		}
		
		//armor next
		for(int i = ARMOR.length - 1; i >= 0; i--)
		{
			MeleeArmor arm = ARMOR[i];
			if(arm.DEF_LVL <= s.getStatic(Skill.DEFENCE) && !hasEquipped(arm.ITEM_ID) && hasItem(arm.ITEM_ID)
					&& arm.DEF_LVL > bestArmorDefReq)
			{
				upgrades.add(arm.ITEM_ID);
				bestArmorDefReq = arm.DEF_LVL;
			}
		}
				
		return upgrades;
	}
	
	private List<Integer> getMagicUpgrades()
	{
		return null;
	}
	
	private List<Integer> getRangeUpgrades()
	{
		return null;
	}
	
	private boolean hasEquipped(int id)
	{
		return mission.equipment.contains(id);
	}
	
	private boolean hasItem(int id)
	{
		return mission.inventory.contains(id)
				|| mission.getScript().BANK_CACHE.get().containsKey(id);
	}

}
