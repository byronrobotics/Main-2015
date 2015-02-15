package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// The lifting mechanism  control
public class Lifter extends Subsystem
{	
	
	static CANTalon motorLifterRight = new CANTalon(RobotMap.talonDevIDLifterRight); //main
	static CANTalon motorLifterLeft = new CANTalon(RobotMap.talonDevIDLifterLeft); //follower
	static AnalogInput photoSwitch = new AnalogInput(0);
		
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
					SmartDashboard.putString("Lift", "UP");
				} else {
					motorLifterRight.set(0.0);
					SmartDashboard.putString("Lift", "Error-Up");
				} 
		}
		public void liftAutoDown()
		{
			//set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >10){	
					motorLifterRight.set(400);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putString("Lift", "DOWN");
			}else {
					motorLifterRight.set(0.0);
					SmartDashboard.putString("Lift", "Error-Down");
			} 
		}

		//Made this to adjust the speed up and down from dashboard the values and to see the values
		//Also made the Lift Up & Down by VIA the Second Joystick joystickP1 or in Port 1
		public void Joysticklifter(Joystick joystickP1) {
			double y = joystickP1.getY();
			
			//LIFT UP
			//Viewing the value of the lift Speed
			SmartDashboard.getNumber("LiftSpeed", motorLifterRight.getSpeed());
			//Creating a double to adjust it from the dashboard 
			double a = SmartDashboard.getDouble("LiftUpSpeed");
			//Reading to see if the value is coming back correctly from the dashboard 
			//for us to see
			SmartDashboard.putNumber("LiftUpSpeedCheck-UP", a);
			//making it so we can only go a speed of a that we set on the dashboard
			double b = y=/*PLEASE LOOK INTO TO SEE WHAT THIS DOES*/a; 
			
			//set motor speeds for when you call LiftUp
			motorLifterRight.set(b);
			//Puting the lift Encoder Velocity to dashboard
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			//Stating the Position of the Lift STRING
			SmartDashboard.putString("Lift", "Up");	
			
			//LIFT DOWN
			//Viewing the value of the lift Speed
			SmartDashboard.getNumber("LiftSpeed", motorLifterRight.getSpeed());
			//Creating a double to adjust it from the dashboard 
			double c = SmartDashboard.getDouble("LiftDownSpeed");
			//Reading to see if the value is coming back correctly from the dashboard 
			//for us to see
			SmartDashboard.putNumber("LiftUpSpeedCheck-DOWN", c);
			//making it so we can only go a speed of a that we set on the dashboard
			double d = y=/*PLEASE LOOK INTO TO SEE WHAT THIS DOES*/c;//LOOK INTO THIS 
			
			//set motor speeds for when you call LiftDown
			motorLifterRight.set(d);
			//Puting the lift Encoder Velocity to dashboard
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			//Stating the position of the Lift STRING
			SmartDashboard.putString("Lift", "Down");
		}
}
