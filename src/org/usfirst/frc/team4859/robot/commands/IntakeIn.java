package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command takes in the tote to the robot
 */
public class IntakeIn extends Command
{
	public IntakeIn()
	{
		//says that this command needs the robot subsystem called intake in order to run
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
		//tells the command to stop
		Robot.intake.intakeStop();
	}

	
	protected void interrupted()
	{
		end();
	}
}
