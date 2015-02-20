package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
//the lift up commands
import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command {
	public LiftUp() // Takes control of the Lifter subsystem so no other command runs on it
	{
		requires(Robot.lifter);
	}
	
	protected void initialize() // Any code that is run at the beginning of the command should be placed here
	{
		Robot.lifter.liftUp();
	}
	
	protected void execute() // Runs the LiftUp method in the Lifter subsystem every 20ms/50 times per second
	{
		Robot.lifter.liftUp();	
	}
	
	protected boolean isFinished() // Checks if the command has finished running
	{
		return false;
	}

	protected void end() // If isFinished returns true, run this method, which should stop what the command was doing
	{
		Robot.lifter.liftStop();
	}
	
	protected void interrupted() // Runs if a command takes control of the subsystem this command was using
	{
		end();
	}	
}
