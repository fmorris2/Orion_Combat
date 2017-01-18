package org.worker.impl.bank;

import java.util.ArrayList;
import java.util.List;

import org.OrionCombat;
import org.worker.OCWorker;

public class OC_DepositItems extends OCWorker
{
	
	public OC_DepositItems(OrionCombat mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}

	@Override
	public void work()
	{
		if(bank.isOpen())
		{
			int[] dontDeposit = getDontDeposit();
			script.log(this, false, "Bank is open");
			bank.depositAllExcept(dontDeposit);
		}
		else
		{
			script.log(this, false, "Opening bank");
			bankUtils.open();
		}
	}
	
	public int[] getDontDeposit()
	{
		List<Integer> dontDeposit = getDontDepositList();
		
		int[] dontDepositArr = new int[dontDeposit.size()];
		for(int i = 0; i < dontDeposit.size(); i++)
			dontDepositArr[i] = dontDeposit.get(i).intValue();
				
		return dontDepositArr;
	}
	
	public List<Integer> getDontDepositList()
	{
		List<Integer> dontDeposit = new ArrayList<>();
		
		if(mission.getMonster().NEEDS_FOOD)
			dontDeposit.add(mission.food.ID);
		
		if(mission.getMonster().REQUIRED_ITEMS != null)
		{
			for(int i : mission.getMonster().REQUIRED_ITEMS)
				dontDeposit.add(i);
		}
		
		if(mission.getLocation().REQUIRED_ITEMS != null)
		{
			for(int i : mission.getLocation().REQUIRED_ITEMS)
				dontDeposit.add(i);
		}
		
		return dontDeposit;
	}

}
