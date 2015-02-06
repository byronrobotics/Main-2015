package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command makes the wheels spin freely and not have them in a fixed position
 */
public class IntakeStop extends Command
{
	public IntakeStop()
	{
		//says that this command need the robot subsystem called intake in order to run
		requires(Robot.intake);
	}
	
	
	protected void initialize()
	{
		Robot.intake.intakeStop();
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
