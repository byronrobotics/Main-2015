package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// The lifting mechanism  control
public class Lifter extends Subsystem {	
	// Forward limit switch is on the bottom
	// Reverse limit switch is the top
	static CANTalon motorLifterRight = new CANTalon(RobotMap.talonDevIDLifterRight); //main
	static CANTalon motorLifterLeft = new CANTalon(RobotMap.talonDevIDLifterLeft); //follower
	
	static Talon motorLifterSR = new Talon(RobotMap.talonDevIDLifterSR);
	// Creating the photo sensor
	static AnalogInput photoSwitch = new AnalogInput(0);
	
		public Lifter()
		{
			super();
			motorLifterLeft.changeControlMode(ControlMode.Follower); //change left motor control mode to follower mode
			motorLifterLeft.set(RobotMap.talonDevIDLifterRight); //tell the left motor to follow the right motor
		}
		
		protected void initDefaultCommand()
		{
		}
		
		public void liftUp()
		{
			motorLifterSR.set(0.6);
			// Set motor speeds for when you call LiftUp
			motorLifterRight.set(0.6);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Up");
		}
		
		public void liftUpFast()
		{
			motorLifterSR.set(1.0);
			// Set motor speeds for when you call LiftUp
			motorLifterRight.set(1.0);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Up Fast");
		}
		
		public void liftDown()
		{
			motorLifterSR.set(-0.4);
			// Set motor speeds for when you call LiftDown
			motorLifterRight.set(-0.4);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Down");
		}
		
		public void liftDownFast()
		{
			motorLifterSR.set(-1.0);
			// Set motor speeds for when you call LiftDown
			motorLifterRight.set(-1.0);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Down Fast");
		}
		
		public void liftStop()
		{
			motorLifterSR.set(0.0);
			// Set motor speeds for when you call LiftStop
			motorLifterRight.set(0.0);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putString("Lift", "Stopped");
		}
		
		public void liftAutoUp()
		{
			// Set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >1 && photoSwitch.getVoltage()<0){	
					motorLifterRight.set(-0.7);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putString("Lift", "UP");
				} else if((motorLifterRight.isRevLimitSwitchClosed())){
					motorLifterRight.set(0.0);
					SmartDashboard.putString("Lift", "Error-Up");
				} 
		}
		
		public void liftAutoDown()
		{
			// Set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >10 && photoSwitch.getVoltage()<4){	
					motorLifterRight.set(.40);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putString("Lift", "DOWN");
			}else if(motorLifterRight.isFwdLimitSwitchClosed()){
					motorLifterRight.set(0.0);
					SmartDashboard.putString("Lift", "Error-Down");
			} 
		}
}