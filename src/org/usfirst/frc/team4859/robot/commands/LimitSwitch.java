package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LimitSwitch extends Command {
	
	public LimitSwitch() // Takes control of the Chassis subsystem so no other command runs on it
	{
		requires(Robot.lifter);
	}
	
	protected void initialize() // Any code that is run at the beginning of the command should be placed here
	{
		
	}
	
	protected void execute() // Runs every 20ms/50 times per second
	{	
		SmartDashboard.putBoolean("Limit Switch", Robot.lifter.limitSwitch.get());
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