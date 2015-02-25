package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

//The lift down command.

public class LiftDownBeast extends Command
{
	public LiftDownBeast(){
		requires(Robot.lifter);
	}
	
	
	protected void initialize(){	
		Robot.lifter.liftDownBeast();
	}

	
	protected void execute(){
		Robot.lifter.liftDownBeast();
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
