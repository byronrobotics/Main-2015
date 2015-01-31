package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem
{

	SpeedController motorLeft, motorRight;
	RobotDrive drive;
	
	public Chassis()
	{
		super();
		drive = new RobotDrive(motorLeft, motorRight);
		drive.setSafetyEnabled(false);
	}
	
	
	public void initDefaultCommand ()
	{
		setDefaultCommand(new DriveWithJoystick());
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
		
		return temp;
	}
	
	public void driveWithJoystick(Joystick joystickP0)
	{
		
		final double deadzone = .01; // amount of deadspace around center
		double x;
		double y;
		double twist;
		
		/** Get simple values from joystick **/
		//x = joystickP0.getX();
		//y = joystickP0.getY();
		twist = joystickP0.getTwist();
		
		/** Get values from joystick, square, and apply deadzone **/
		x = joystickAdjust(joystickP0.getX(), deadzone);
		y = joystickAdjust(joystickP0.getY(), deadzone);
		//twist = joystickAdjust(joystickP0.getTwist(), deadzone);
	
		twist = twist/1.75;
		y = -y/1.25;
		
		drive.arcadeDrive(twist, y);
	}
	
}
