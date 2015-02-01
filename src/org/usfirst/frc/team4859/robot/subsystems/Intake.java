package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * This subsystem controlles the intake in, intake out, and intake release
 */

public class Intake extends Subsystem
{
	CANTalon intakeMotorLeft;
	CANTalon intakeMotorRight;
	//Declare motors here
	public Intake()
	{
		super();
		//# is writtn on the bottom of the CANTalons in black sharpie
		//calls new motor on the left of the robot
		intakeMotorLeft = new CANTalon(11/*NOT CORRECT NEED TO CHANGE*/);
		//calls new motor on the right of the robot
		intakeMotorRight = new CANTalon(13/*NOT CORRECT NEED TO CHANGE*/);
	}

	
	protected void initDefaultCommand() {}
	
	
	public void intakeIn()
	{
		//set motor speeds for when you call IntakeIn
		intakeMotorLeft.set(.25/*SPEED MAY HAVE TO BE CHANGED HIGHER OR LOWER OR TO A NEGATIVE*/);
		intakeMotorRight.set(.25/*SPEED MAY HAVE TO BE CHANGED TO A HIGHER, LOWER OR TO A NEGATIVE*/);
	}
	
	
	public void intakeOut()
	{
		//set motor speeds for when you call IntakeOut
		intakeMotorLeft.set(-.25/*SPEED MAY HAVE TO BE CHANGED TO A HIGHER,LOWER OR POSITIVE NUMBER*/);
		intakeMotorRight.set(-.25/*SPEED MAY HAVE TO BE CHANGED TO A HIGHER,LOWER OR POSITIVE NUMBER*/);
	}
	
	
	public void intakeStop()
	{
		//set motor speeds for when you call IntakeStop
		intakeMotorLeft.set(0.0/*SOMEONE MAY NEED TO CHANGE THIS*/);
		intakeMotorRight.set(0.0/*SOMEONE MAY NEED TO CHANGE THIS ALSO*/);
	}
}
