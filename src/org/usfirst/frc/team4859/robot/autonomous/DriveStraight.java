package org.usfirst.frc.team4859.robot.autonomous;

import org.usfirst.frc.team4859.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraight extends Command {

	private double Time;
	
    public DriveStraight(double inputTime)
    {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.chassis);
        Time = inputTime;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.chassis.DriveStraight(-.05);
    	setTimeout(Time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	Robot.chassis.DriveStraight();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	Robot.chassis.DriveStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
