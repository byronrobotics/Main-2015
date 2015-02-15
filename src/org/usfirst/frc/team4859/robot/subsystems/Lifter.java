package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

// The lifting mechanism  control
public class Lifter extends Subsystem
{	
	
	static CANTalon motorLifterRight = new CANTalon(RobotMap.talonDevIDLifterRight); //main
	static CANTalon motorLifterLeft = new CANTalon(RobotMap.talonDevIDLifterLeft); //follower
	static DigitalSource limitSwitch = new DigitalInput(1);
	static AnalogInput photoSwitch = new AnalogInput(0);
	Joystick joystickP1 = new Joystick(1);
	double y = joystickP1.getY();
		
		public Lifter(){
			super();
			
			motorLifterRight.changeControlMode(ControlMode.Speed); //change right motor control mode to speed instead of throttle
			motorLifterLeft.changeControlMode(ControlMode.Follower); //change left motor control mode to follower mode
			motorLifterLeft.set(RobotMap.talonDevIDLifterRight); //tell the left motor to follow the right motor
			motorLifterLeft.enableLimitSwitch(true, true);
			SmartDashboard.putNumber("LiftUpSpeed", motorLifterRight.getSpeed());
		}
		
		
		protected void initDefaultCommand() {
		}
		
		
		public void liftUp(){ // brings lift up du
			//set motor speeds for when you call LiftUp
			motorLifterRight.set(100);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Up");
		}
		
		
		public void liftDown() //brings lift down du.
		{
			//set motor speeds for when you call LiftDown
				motorLifterRight.set(-50);
				SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
				SmartDashboard.putString("Lift", "Down");
		}
		
		
		public void liftStop() //stops lift motors du
		{
			//set motor speeds for when you call LiftStop
			motorLifterRight.set(0);
			motorLifterRight.ClearIaccum();
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Stopped");
		}
		public void liftAutoUp()
		{
			//set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >10){	
					motorLifterRight.set(-700);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putBoolean("LiftDown", false);
					SmartDashboard.putBoolean("LiftUp", true);
				} else {
					motorLifterRight.set(0.0);
					SmartDashboard.putString("LiftDown", "error-not-in");
					SmartDashboard.putString("LiftUp", "error-not-in");
				} 
		}
		public void liftAutoDown()
		{
			//set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >10){	
					motorLifterRight.set(400);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putBoolean("LiftDown", true);
					SmartDashboard.putBoolean("LiftUp", false);
			}else {
					motorLifterRight.set(0.0);
					SmartDashboard.putString("LiftDown", "error-not-in");
					SmartDashboard.putString("LiftUp", "error-not-in");
			} 
		}


		public void Joysticklifter(Joystick joystickP1) {
			
			SmartDashboard.getNumber("LiftUpSpeed", motorLifterRight.getSpeed());
			double a = SmartDashboard.getDouble("LiftUpSpeed");
			SmartDashboard.putNumber("LiftUpSpeedCheck", a);
			double b = y=a; 
			//set motor speeds for when you call LiftUp
			motorLifterRight.set(b);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Up");	
			
			SmartDashboard.getNumber("LiftUpSpeed", motorLifterRight.getSpeed());
			double c = SmartDashboard.getDouble("LiftUpSpeed");
			SmartDashboard.putNumber("LiftUpSpeedCheck", c);
			double d = y=c; 
			//set motor speeds for when you call LiftDown
			motorLifterRight.set(d);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Down");
		}
}
