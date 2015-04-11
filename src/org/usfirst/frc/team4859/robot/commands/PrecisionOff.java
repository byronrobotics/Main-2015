package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class PrecisionOff extends Command {

    public PrecisionOff()
    {
    }

    protected void initialize() // Called just before this command runs the first time
    {
    	System.out.println("Precision Off");
    	RobotMap.pMode = false;
    }

    protected void execute() // Called repeatedly when this command is scheduled to run
    {
    }

    protected boolean isFinished() // Make this return true when this command no longer needs to run execute()
    {
        return true;
    }

    protected void end() // Called once after isFinished returns true
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    	end();
    }
}