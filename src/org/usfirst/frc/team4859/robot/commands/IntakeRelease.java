package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command makes the wheels spin freely and not have them in a fixed position
 */
public class IntakeRelease extends Command
{
	public IntakeRelease()
	{
		requires(Robot.intake);
	}
	
	
	protected void initialize()
	{
		Robot.intake.intakeRelease();
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
