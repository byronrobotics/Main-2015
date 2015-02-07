package org.usfirst.frc.team4859.robot.commands;

import org.usfirst.frc.team4859.robot.Robot;
import org.usfirst.frc.team4859.robot.subsystems.Lifter;
//the lift up commands
import edu.wpi.first.wpilibj.command.Command;

public class LiftUp extends Command
{
	public LiftUp(){
		requires(Robot.lifter);
	}
	
	
	protected void initialize(){
		Robot.lifter.liftUp();
	}

	
	protected void execute(){
		
	}

	
	protected boolean isFinished(){
		return Lifter.isSwitchSet();
	}

	
	protected void end(){
		Robot.lifter.liftStop();
	}

	
	protected void interrupted(){
		end();
	}	
}
