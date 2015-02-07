package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.OI;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem
{
	//Setting chassis motors to CANTalon IDs
	static CANTalon motorChassisLeft = new CANTalon(13);
	static CANTalon motorChassisRight = new CANTalon(14);
	
	//front is top of "U" back is bottom of "U"
	// Creates robot drive configuration with a left and right motor
	static RobotDrive chassisDrive = new RobotDrive(motorChassisLeft, motorChassisRight);

	
	public Chassis()
	{
		super();
		
		//Set a timeout for the motors (1 second)
		chassisDrive.setSafetyEnabled(true);
		chassisDrive.setExpiration(1);
	}
	
	
	public void initDefaultCommand ()
	{
		setDefaultCommand(new DriveWithJoystick());
		
		//Initial value
		//Made to change our deadzone values in dashboard
		SmartDashboard.putNumber("Deadzone", .01);
		
		//the initial value of the encoders we put to the dashboard
		SmartDashboard.putNumber("VelocityLeft", motorChassisLeft.getEncVelocity());
		SmartDashboard.putNumber("VelocityRight", motorChassisRight.getEncVelocity());
	}
	
	
	// Utility function to adjust joystick coordinates
	private double joystickAdjust(double value, double deadzone)
	{
		double temp;
		// Value is the value from the joystick, deadzone is self-explanatory
		// Squaring and deadzones for cartesian (X, Y, and Twist(Z) value
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
		//Putting Deadzone values to dashboard from equation
		SmartDashboard.putNumber("DeadzoneAdjust", deadzone);
		SmartDashboard.putNumber("JoystickAdjust", value);
		return temp;
	}
	
	
	public void driveWithJoystick(Joystick joystickP0)
	{
		//calling the deadzone a double, done to change value in dashboard
		double deadzone = SmartDashboard.getNumber("DeadzoneManualChange");
		SmartDashboard.putNumber("DeadzoneCheck", deadzone);
		
		// Get simple values from joystick
		double twist = joystickP0.getTwist(); //z-axis check joysticks
		
		// Get values from joystick, square, and apply deadzone
		double y = joystickAdjust(joystickP0.getY(), deadzone);

		// Adjusting for variables
		twist = twist/1.25;
		y = -y;
		
		
		//m012 is CANTalon 12 encoder 
		//we create a double m012 so we can get "Velocity" that value is then what we change in Dashboard to set the motor
		//The put number EditV12 is our value to make sure on our dashboard that our new number is being read correctly
		//Finally the V012 is our final read on what our Encoder is reading out
		double m012 = SmartDashboard.getDouble("VelocityLeft");
		SmartDashboard.putNumber("EditV12", m012);
		SmartDashboard.putNumber("V012", motorChassisLeft.getEncVelocity());

		//m014 is CANTalon 14 encoder 
		//we create a double m014 so we can get "Velocity1" that value is then what we change in Dashboard to set the motor
		//The put number EditV14 is our value to make sure on our dashboard that our new number is being read correctly
		//Finally the V014 is our final read on what our Encoder is reading out
		double m014 = SmartDashboard.getDouble("VelocityRight");
		SmartDashboard.putNumber("EditV14", m014);
		SmartDashboard.putNumber("V014", motorChassisRight.getEncVelocity());
		
		
		//here we are stating that we have to use button 3 in order to use encoders to set the speed of the wheels
		//BE CAREFUL USING BUTTON 10!!
		//it swaps between our joystick drive and our encoder drive
		if(joystickP0.getRawButton(10))
		{
			motorChassisLeft.set(m012);
			motorChassisRight.set(m014);
		}
		else if(OI.pMode == true)
		{
			chassisDrive.arcadeDrive(twist/1.5, y/1.5);
		}
		else
		{
			chassisDrive.arcadeDrive(twist, y);
		}
		
		SmartDashboard.putNumber("JoystickY", y);
		SmartDashboard.putNumber("JoystickTwist", twist);
		SmartDashboard.putBoolean("Precision Mode", OI.pMode);
	}
	public void DriveStraight(){
		chassisDrive.arcadeDrive(.25,0);
	}
	public void DriveStop(){
		chassisDrive.arcadeDrive(0,0);
	}
	
	
}
