package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.teams4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem
{
	//Setting chassis motors to CANTalon IDs
	static CANTalon motorChassisLeft = new CANTalon(RobotMap.talonDevIDChassisLeft);
	static CANTalon motorChassisRight = new CANTalon(RobotMap.talonDevIDChassisRight);
	
	//front is top of "U" back is bottom of "U"
	// Creates robot drive configuration with a left and right motor
	static RobotDrive chassisDrive = new RobotDrive(motorChassisLeft, motorChassisRight);
	
	public Chassis()
	{
		super();
		motorChassisRight.changeControlMode(ControlMode.PercentVbus);
		motorChassisLeft.changeControlMode(ControlMode.PercentVbus);
		
		//Set a timeout for the motors (1 second)
		chassisDrive.setSafetyEnabled(true);
		chassisDrive.setExpiration(1);
	}
	public void initDefaultCommand ()
	{
		setDefaultCommand(new DriveWithJoystick());
	}
	public void driveWithJoystick(Joystick joystickP0)
	{
		// Get simple values from joystick
		double twist = joystickP0.getTwist();
		double y = joystickP0.getY();
		
		twist = -twist/1.25;
		
		if (RobotMap.pMode == true) {
			y = ThrottleLookup.calcJoystickCorrection(1, y);
		}else { 
			y = ThrottleLookup.calcJoystickCorrection(2, y);
		}	
		
		if(RobotMap.pMode == true)
		{
			chassisDrive.arcadeDrive(y/2, twist/1.5);
			SmartDashboard.putString("ROBOT MODE", "Slow");	}
		else
		{
			chassisDrive.arcadeDrive(y, twist);
			SmartDashboard.putString("ROBOT MODE", "Normal");
		}
		
		SmartDashboard.putNumber("JoystickY", y);
		SmartDashboard.putNumber("JoystickTwist", twist);
		SmartDashboard.putBoolean("Precision Mode", RobotMap.pMode);
}
	public void DriveStraight(){		
		motorChassisRight.changeControlMode(ControlMode.Speed);
		motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(.25,0);
	}
	public void DriveStop(){
		chassisDrive.arcadeDrive(0,0);
	}
	public void DriveLeft180(){
		motorChassisRight.changeControlMode(ControlMode.Speed);
		motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(0,.50);
	}
	public void DriveRight180(){
		motorChassisRight.changeControlMode(ControlMode.Speed);
		motorChassisLeft.changeControlMode(ControlMode.Speed);
		chassisDrive.arcadeDrive(0,-.50);
	}
}