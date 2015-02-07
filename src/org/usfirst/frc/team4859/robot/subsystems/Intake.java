package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
/*
 * This subsystem controlles the intake in, intake out, and intake release
 */
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem
{
	//
	static CANTalon intakeMotorLeft = new CANTalon(RobotMap.talonDevIDIntakeLeft);
	static CANTalon intakeMotorRight= new CANTalon(RobotMap.talonDevIDIntakeRight);;
	//Declare motors here
	public Intake()
	{
		super();
		
	}

	
	protected void initDefaultCommand() {
		
	}
	
	
	public void intakeIn()
	{
		//set motor speeds for when you call IntakeIn
		intakeMotorLeft.set(.25/*SPEED MAY HAVE TO BE CHANGED HIGHER OR LOWER OR TO A NEGATIVE*/);
		intakeMotorRight.set(.25/*SPEED MAY HAVE TO BE CHANGED TO A HIGHER, LOWER OR TO A NEGATIVE*/);
		SmartDashboard.putNumber("IntakeMotor Left", intakeMotorLeft.getEncVelocity());
		SmartDashboard.putNumber("IntakeMotor Right", intakeMotorRight.getEncVelocity());
		SmartDashboard.putBoolean("intakeOut", false);
		SmartDashboard.putBoolean("intakeIn", true);

	}
	
	
	public void intakeOut()
	{
		//set motor speeds for when you call IntakeOut
		intakeMotorLeft.set(-.25/*SPEED MAY HAVE TO BE CHANGED TO A HIGHER,LOWER OR POSITIVE NUMBER*/);
		intakeMotorRight.set(-.25/*SPEED MAY HAVE TO BE CHANGED TO A HIGHER,LOWER OR POSITIVE NUMBER*/);
		SmartDashboard.putNumber("IntakeMotor Left", intakeMotorLeft.getEncVelocity());
		SmartDashboard.putNumber("IntakeMotor Right", intakeMotorRight.getEncVelocity());
		SmartDashboard.putBoolean("intakeOut", true);
		SmartDashboard.putBoolean("intakeIn", false);
	}
	
	
	public void intakeStop()
	{
		//set motor speeds for when you call IntakeStop
		intakeMotorLeft.set(0.0/*SOMEONE MAY NEED TO CHANGE THIS*/);
		intakeMotorRight.set(0.0/*SOMEONE MAY NEED TO CHANGE THIS ALSO*/);
		SmartDashboard.putNumber("IntakeMotor Left", intakeMotorLeft.getEncVelocity());
		SmartDashboard.putNumber("IntakeMotor Right", intakeMotorRight.getEncVelocity());
		SmartDashboard.putBoolean("intakeOut", false);
		SmartDashboard.putBoolean("intakeIn", false);
	}
}
