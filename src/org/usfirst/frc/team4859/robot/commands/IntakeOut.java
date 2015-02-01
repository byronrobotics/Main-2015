package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * This command takes the tote out from the outside of the robot
 */
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
		Robot.intake.intakeStop();
	}

	
	protected void interrupted()
	{
		end();
	}
}
