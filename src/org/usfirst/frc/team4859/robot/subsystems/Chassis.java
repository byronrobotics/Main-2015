package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem
{

	static CANTalon motorLeft = new CANTalon(13);
	static CANTalon motorRight = new CANTalon(14);
	
	//front is top of "U" back is bottom of "U"
	static RobotDrive drive = new RobotDrive(motorLeft, motorRight);
	
	Joystick joystickP0 = new Joystick(0);

	public Chassis()
	{
		super();
		drive.setSafetyEnabled(true);
		drive.setExpiration(1);
	}
	
	
	public void initDefaultCommand ()
	{
		setDefaultCommand(new DriveWithJoystick());
		
		SmartDashboard.putNumber("Deadzone", .01);
		
		//the Intial value of the encoders we put to the dashboard
		SmartDashboard.putNumber("Velocity", motorLeft.getEncVelocity());
		SmartDashboard.putNumber("Velocity1", motorRight.getEncVelocity());
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
		double dz = SmartDashboard.getNumber("Deadzone");
		SmartDashboard.putNumber("Deadzone_Manual", dz);
		final double deadzone =dz;
		
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
		
		
		
		//m012 is CANTalon 12 encoder 
		//we create a double m012 so we can get "Velocity" that value is then what we change in Dashboard to set the motor
		//The put number EditV12 is our value to make sure on our dashboard that our new number is being read correctly
		//Finally the V012 is our final read on what our Encoder is reading out
		double m012 = SmartDashboard.getDouble("Velocity");
		SmartDashboard.putNumber("EditV12", m012);
		SmartDashboard.putNumber("V012", motorLeft.getEncVelocity());

		//m014 is CANTalon 14 encoder 
		//we create a double m014 so we can get "Velocity1" that value is then what we change in Dashboard to set the motor
		//The put number EditV14 is our value to make sure on our dashboard that our new number is being read correctly
		//Finally the V014 is our final read on what our Encoder is reading out
		double m014 = SmartDashboard.getDouble("Velocity1");
		SmartDashboard.putNumber("EditV14", m014);
		SmartDashboard.putNumber("V014", motorRight.getEncVelocity());
		
		//here we are stating that we have to use button 3 in order to use encoders to set the speed of the wheels
		//BE CAREFUL USING BUTTON 3!!
		//it swaps between our joystick drive and our encoder drive
		if(joystickP0.getRawButton(3)){
			motorLeft.set(m012);
			motorRight.set(m014);
		} else {
			drive.arcadeDrive(twist, y);
		}
	}
	
}
