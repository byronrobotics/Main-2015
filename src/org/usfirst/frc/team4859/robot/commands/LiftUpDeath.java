package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
//the lift up commands
import edu.wpi.first.wpilibj.command.Command;

public class LiftUpDeath extends Command
{
	public LiftUpDeath()
	{
		requires(Robot.lifter);
	}
	
	
	protected void initialize() {
		Robot.lifter.liftUpDeath();
	}

	
	protected void execute() {
		Robot.lifter.liftUpDeath();
		
	}

	
	protected boolean isFinished() {
		return false;
	}

	
	protected void end() {
	}

	
	protected void interrupted() {
		
	}	
}
