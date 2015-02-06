package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.OI;

import edu.wpi.first.wpilibj.command.Command;

public class PrecisionMode extends Command
{
	protected void initialize()
	{
		OI.pMode = true;
	}
	
	protected void execute(){}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		OI.pMode = false;
	}
	
	protected void interrupted()
	{
		end();
	}
	
}
