package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem
{

	static CANTalon motorLeft = new CANTalon(12);
	static CANTalon motorRight = new CANTalon(14);
	
	//front is top of "U" back is bottom of "U"
	static RobotDrive drive = new RobotDrive(motorLeft, motorRight);
	
	public Chassis()
	{
		super();
		drive.setSafetyEnabled(true);
		drive.setExpiration(1);
	}
	
	
	public void initDefaultCommand ()
	{
		setDefaultCommand(new DriveWithJoystick());
		SmartDashboard.putNumber("Deadzone", .015);
		SmartDashboard.putNumber("Velocity", motorLeft.getEncVelocity());
		SmartDashboard.putNumber("Velocity", motorRight.getEncVelocity());
	}
	
	
	// Utility function to adjust joystick coordinates
	private double joystickAdjust(double value, double deadzone)
	{
		double temp;
		
		// Squaring and deadzones for cartesian (X, Y, and Twist(Z)) value
				if(value > deadzone)
				{
					temp = value*value;
				}
				else if(value < -deadzone)
				{
					temp = -value*value;
				}
				else
				{
					temp = 0;
				}
		SmartDashboard.putNumber("Deadzone_Auto", deadzone);
		SmartDashboard.putNumber("Value_Auto", value);
		return temp;
	}
	
	public void driveWithJoystick(Joystick joystickP0)
	{
		final double deadzone = SmartDashboard.getNumber("Deadzone_Manual");
		SmartDashboard.putNumber("Deadzone_Manual_Read", deadzone);
		//final double deadzone = .015; // amount of deadspace around center
		//double x;
		double y;
		double twist;
		
		/** Get simple values from joystick **/
		//x = joystickP0.getX();
		//y = joystickP0.getY();
		twist = joystickP0.getTwist(); //z-axis check joysticks
		
		/** Get values from joystick, square, and apply deadzone **/
		//x = joystickAdjust(joystickP0.getX(), deadzone);
		y = joystickAdjust(joystickP0.getY(), deadzone);
		//twist = joystickAdjust(joystickP0.getTwist(), deadzone);
	
		twist = twist/1.75;
		y = -y/1.25;
		
		drive.arcadeDrive(twist, y);
		
		double m012 = SmartDashboard.getDouble("Velocity");
		SmartDashboard.putNumber("V12", m012);
		motorLeft.set(m012);
		SmartDashboard.putNumber("V012", motorLeft.getEncVelocity());
		
		double m014 = SmartDashboard.getDouble("Velocity");
		SmartDashboard.putNumber("V14", m014);
		motorLeft.set(m014);
		SmartDashboard.putNumber("V014", motorRight.getEncVelocity());
	}
	
}
