package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

//The lift down command.

public class LiftDown extends Command
{
	public LiftDown(){
		requires(Robot.lifter);
	}
	
	
	protected void initialize(){	
		Robot.lifter.liftDown();
	}

	
	protected void execute(){
		 
	}

	
	protected boolean isFinished(){
		return false;
	}

	
	protected void end()
	{
	
	}

	
	protected void interrupted()
	{
		
	}
}
