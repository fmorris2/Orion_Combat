package org;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.data.enums.CombatType;
import org.osbot.rs07.script.ScriptManifest;

import viking.framework.goal.impl.InfiniteGoal;
import viking.framework.mission.Mission;
import viking.framework.paint.VikingPaint;
import viking.framework.script.VikingScript;

@ScriptManifest(author = "The Viking", name = "Orion Combat Script", info = "WE ROLLIN'", version = 0, logo = "")
public class Orion_Combat_Script extends VikingScript
{

	@Override
	public Queue<Mission> generateMissions()
	{
		return new LinkedList<>(Arrays.asList(new OrionCombat(this, CombatType.MELEE, null, true, new InfiniteGoal())));
	}

	@Override
	public VikingPaint<?> getVikingPaint()
	{
		return null;
	}

	@Override
	public boolean isDevBuild()
	{
		return false;
	}

}
