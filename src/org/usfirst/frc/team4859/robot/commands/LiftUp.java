package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command
{
	public LiftUp()
	{
		requires(Robot.lifter);
	}
	
	
	protected void initialize()
	{
		Robot.lifter.liftUp();
	}

	
	protected void execute()
	{
		
	}

	
	protected boolean isFinished()
	{
		return false;
	}

	
	protected void end()
	{
		Robot.lifter.liftStop();
	}

	
	protected void interrupted()
	{
		end();
	}
}