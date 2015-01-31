package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command
{
	public IntakeOut()
	{
		requires(Robot.intake);
	}
	
	
	protected void initialize()
	{
		Robot.intake.intakeOut();
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
		Robot.intake.intakeRelease();
	}

	
	protected void interrupted()
	{
		end();
	}
}
