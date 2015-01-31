package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeIn extends Command
{
	public IntakeIn()
	{
		requires(Robot.intake);
	}
	
	
	protected void initialize()
	{
		Robot.intake.intakeIn();
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
