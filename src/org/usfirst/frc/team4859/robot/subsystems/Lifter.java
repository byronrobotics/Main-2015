package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// The lifting mechanism  control
public class Lifter extends Subsystem
{	
	
	static CANTalon motorLifterRight = new CANTalon(RobotMap.talonDevIDLifterRight); //main
	static CANTalon motorLifterLeft = new CANTalon(RobotMap.talonDevIDLifterLeft); //follower
	static AnalogInput photoSwitch = new AnalogInput(0);
	static RobotDrive lifterDrive = new RobotDrive(motorLifterLeft, motorLifterRight);	
		public Lifter(){
			super();
			
			motorLifterRight.changeControlMode(ControlMode.Speed); //change right motor control mode to speed instead of throttle
			motorLifterLeft.changeControlMode(ControlMode.Follower); //change left motor control mode to follower mode
			motorLifterLeft.set(RobotMap.talonDevIDLifterRight); //tell the left motor to follow the right motor
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
			motorLifterRight.ClearIaccum();
			//set motor speeds for when you call LiftStop
			motorLifterRight.set(0);
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

		// Utility function to adjust joystick coordinates
		/*private double joystickAdjust(double value, double deadzone)
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
		
		
		//Made this to adjust the speed up and down from dashboard the values and to see the values
		//Also made the Lift Up & Down by VIA the Second Joystick joystickP1 or in Port 1
		public void JoystickLifter(Joystick joystickP1) {
			double y = joystickAdjust(joystickP1.getY()*1000, 0.015);
			double twist = 0;
			//LIFT UP
			//set motor speeds for when you call LiftUp
			lifterDrive.arcadeDrive(y, twist);
			//Puting the lift Encoder Velocity to dashboard
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			//Stating the Position of the Lift STRING
			if(motorLifterRight.isFwdLimitSwitchClosed()){
				SmartDashboard.putString("Lift", "UP");	
			} else if(motorLifterRight.isRevLimitSwitchClosed()){
				SmartDashboard.putString("Lift", "DOWN");
			} else {
				SmartDashboard.putString("Lift", "STOP");
			}
		}*/
}