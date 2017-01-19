package org.worker.impl.fight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.OrionCombat;
import org.osbot.rs07.api.ui.RS2Widget;
import org.osbot.rs07.api.ui.Skill;
import org.worker.OCWorker;

import viking.api.Timing;
import viking.framework.goal.Goal;
import viking.framework.goal.impl.SkillGoal;

public class SwitchCombatStyle extends OCWorker
{
	private static final int ATT_INDEX= 0, STR_INDEX = 1, DEF_INDEX = 3, SETTING_INDEX = 43;
	private static final String[] ATT_STYLES = {"Punch", "Stab", "Chop", "Bash", "Pound"};
	private static final String[] STR_STYLES = {"Kick", "Slash", "Lunge", "Pummel", "Spike"};
	private static final String[] DEF_STYLES = {"Block", "Longrange"};
	
	private Queue<SkillGoal> goals = new LinkedList<>();
	private Skill current;
	
	public SwitchCombatStyle(OrionCombat mission)
	{
		super(mission);
		goals = generateGoals();
		current = goals.peek().getSkill();
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}

	@Override
	public void work()
	{
		script.log(this, false, "Switch combat style");
		if(bank.isOpen())
			bank.close();
		else
		{
			current = goals.peek().getSkill();
			String[] names = current == Skill.ATTACK ? ATT_STYLES : current == Skill.STRENGTH ? STR_STYLES : DEF_STYLES;
			RS2Widget w = widgets.getWidgetContainingText(names);
			if(w != null && w.interact())
				Timing.waitCondition(() -> getCurrentIndex() == getIndex(current), 3500);
		}
	}
	
	public boolean needsSwitch()
	{
		if(goals.peek().hasReached())
		{
			Goal g = goals.poll();
			script.log(this, false, g.getCompletionMessage());
		}
		
		return current != goals.peek().getSkill()
					|| getCurrentIndex() != getIndex(goals.peek().getSkill());
	}
	
	private Queue<SkillGoal> generateGoals()
	{
		Queue<SkillGoal> list = new LinkedList<>();
		int att = 1, str = 1, def = 1;
		while(att < 99 && str < 99 && def < 99)
		{
			att += random(1, 6);
			str += random(1, 6);
			def += random(1, 6);
			
			List<SkillGoal> shuffled = new ArrayList<>();
			shuffled.add(new SkillGoal(skills, Skill.ATTACK, att));
			shuffled.add(new SkillGoal(skills, Skill.STRENGTH, str));
			shuffled.add(new SkillGoal(skills, Skill.DEFENCE, def));
			Collections.shuffle(shuffled);
			list.addAll(shuffled);
		}
		
		script.log(this, false, "Generated " + list.size() + " combat style goals...");
		return list;
	}
	
	private int getCurrentIndex()
	{
		return configs.get(SETTING_INDEX);
	}
	
	private int getIndex(Skill s)
	{
		if(s == Skill.ATTACK)
			return ATT_INDEX;
		else if(s == Skill.STRENGTH)
			return STR_INDEX;
		
		return DEF_INDEX;
	}
}
