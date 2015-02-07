package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftDown extends Command
{
	public LiftDown()
	{
		requires(Robot.lifter);
	}
	
	
	protected void initialize()
	{
		Robot.lifter.liftDown();
	}

	
	protected void execute()
	{
		 
	}

	
	protected boolean isFinished()
	{
		return Lifter.isSwitchSet();
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
