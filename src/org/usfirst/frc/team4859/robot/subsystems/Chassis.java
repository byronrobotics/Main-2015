package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import org.usfirst.frc.teams4859.robot.ThrottleLookup.ThrottleLookup;
import org.usfirst.frc.team4859.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
	//thiss were stuff goes down
public class Chassis extends Subsystem
{
	
	//Setting chassis motors to CANTalon IDs
	static CANTalon motorChassisLeft = new CANTalon(RobotMap.talonDevIDChassisLeft);
	static CANTalon motorChassisRight = new CANTalon(RobotMap.talonDevIDChassisRight);
	
	//front is top of "U" back is bottom of "U"
	// Creates robot drive configuration with a left and right motor
	static RobotDrive chassisDrive = new RobotDrive(motorChassisLeft, motorChassisRight);
	
	
//	//100 to 360 cycles per revolution (CPR)
//	//400 to 1440 pulses per revolution (PPR)
//	static Encoder encChassisLeft = new Encoder(16,16, false, Encoder.EncodingType.k4X);
//	static Encoder encChassisRight = new Encoder(16,16, false, Encoder.EncodingType.k4X);
	
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
		
		// Initial value
		//Made to change our deadzone values in dashboard
		SmartDashboard.putNumber("Deadzone", .01);
		
		//the initial value of the encoders we put to the dashboard
		SmartDashboard.putNumber("VelocityLeft", motorChassisLeft.getEncVelocity());
		SmartDashboard.putNumber("VelocityRight", motorChassisRight.getEncVelocity());
		motorChassisLeft.setPosition(0);
		motorChassisLeft.getEncPosition();
	}
	
	
	public void driveWithJoystick(Joystick joystickP0)
	{
		// Get simple values from joystick
		double twist = joystickP0.getTwist(); //z-axis check joysticks
		
		// Get values from joystick, square, and apply deadzone
		double y = joystickP0.getY();
		if (RobotMap.pMode)
			y = ThrottleLookup.calcJoystickCorrection(1, y);
		else
			y = ThrottleLookup.calcJoystickCorrection(2, y);

		// Adjusting for variables
		twist = -twist/1.25;
		
		SmartDashboard.putBoolean("Precise", RobotMap.pMode);
		//m012 is CANTalon 12 encoder 
		//we create a double m012 so we can get "Velocity" that value is then what we change in Dashboard to set the motor
		//The put number EditV12 is our value to make sure on our dashboard that our new number is being read correctly
		//Finally the V012 is our final read on what our Encoder is reading out
		double VelocityLeft = SmartDashboard.getDouble("VelocityLeft");
		SmartDashboard.putNumber("VelocityLeftManualChange ", VelocityLeft);
		SmartDashboard.putNumber("VelocityLeft", motorChassisLeft.getEncVelocity());
		
		//m014 is CANTalon 14 encoder 
		//we create a double m014 so we can get "Velocity1" that value is then what we change in Dashboard to set the motor
		//The put number EditV14 is our value to make sure on our dashboard that our new number is being read correctly
		//Finally the V014 is our final read on what our Encoder is reading out
		double VelocityRight = SmartDashboard.getDouble("VelocityRight");
		SmartDashboard.putNumber("VelocityRightManualChange", VelocityRight);
		SmartDashboard.putNumber("VelocityRight", motorChassisRight.getEncVelocity());
		
		
		//here we are stating that we have to use button 3 in order to use encoders to set the speed of the wheels
		//BE CAREFUL USING BUTTON 10!!
		//it swaps between our joystick drive and our encoder drive


		if(RobotMap.pMode == true)
		{
			chassisDrive.arcadeDrive(y/1.5, twist/1.25);
			SmartDashboard.putString("ROBOT MODE", "Slow");	}
		else
		{
			chassisDrive.arcadeDrive(y, twist);
			SmartDashboard.putString("ROBOT MODE", "Normal");
		}
		
		SmartDashboard.putNumber("JoystickY", y);
		SmartDashboard.putNumber("JoystickTwist", twist);

		SmartDashboard.putBoolean("Precision Mode", RobotMap.pMode);

		//100 to 360 cycles per revolution (CPR)
		//400 to 1440 pulses per revolution (PPR)
//		motorChassisLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//		motorChassisRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//		
//		SmartDashboard.putNumber("encChassisLeftPosition", motorChassisLeft.getEncPosition()*.0001*2.54);
//		SmartDashboard.putNumber("encChassisLeftspeed", motorChassisLeft.getSpeed()*.001);	
	}
	public void DriveStraight(){
		
		chassisDrive.arcadeDrive(.25,0);
	}
	public void DriveStop(){
		chassisDrive.arcadeDrive(0,0);
		
	}
	public void DriveLeft180(){
		chassisDrive.arcadeDrive(0,.50);
	}
	
	public static void Encoder(){
		double encLeftPosition = motorChassisLeft.getEncPosition()*.0001*2.54;
		double encRightPosition = motorChassisRight.getEncPosition()*.0001*2.54;
		
		double encLeftSpeed = motorChassisLeft.getSpeed()*.001;
		double encRightSpeed = motorChassisRight.getSpeed()*.001;
		
		SmartDashboard.putNumber("encChassisLeftPosition", encLeftPosition);
		SmartDashboard.putNumber("encChassisRightPosition", encRightPosition);
		
		SmartDashboard.putNumber("encChassisLeftSpeed", encLeftSpeed);
		SmartDashboard.putNumber("encChassisRightSpeed", encRightSpeed);
		
	}
//	public void Encoder(){
//		//100 to 360 cycles per revolution (CPR)
//		//400 to 1440 pulses per revolution (PPR)
//		motorChassisLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//		motorChassisRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
//		
//		SmartDashboard.putNumber("encChassisLeftPosition", motorChassisLeft.getEncPosition());
//		SmartDashboard.putNumber("encChassisLeftspeed", motorChassisLeft.getSpeed());
//		
//	
//	}
	
	
}
