package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {

	public DriveWithJoystick() // Takes control of the Chassis subsystem so no other command runs on it
	{
		requires(Robot.chassis);
	}
	
	protected void initialize() // Any code that is run at the beginning of the command should be placed here
	{
	}
	
	protected void execute() // Runs the drive method in Chassis with the joystick values every 20ms/50 times per second
	{
		Robot.chassis.driveWithJoystick(Robot.oi.getJoystick());
	}
	
	protected boolean isFinished() // Checks if the command has finished running
	{
		return false;
	}
	
	protected void end() // If isFinished returns true, run this method, which should stop what the command was doing
	{
	}
	
	protected void interrupted() // Runs if a command takes control of the subsystem this command was using
	{
		end();
	}	
}