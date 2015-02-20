package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class PrecisionMode extends Command {
	protected void initialize() // Any code that is run at the beginning of the command should be placed here
	{
		RobotMap.pMode = true;
	}
	
	protected void execute() // Runs every 20ms/50 times per second
	{	
	}
	
	protected boolean isFinished() // Checks if the command has finished running
	{
		return false;
	}
	
	protected void end() // If isFinished returns true, run this method, which should stop what the command was doing
	{
		RobotMap.pMode = false;
	}
	
	protected void interrupted() // Runs if a command takes control of the subsystem this command was using
	{
		end();
	}	
}
