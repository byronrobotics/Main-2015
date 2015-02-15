package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

// The lifting mechanism  control
public class Lifter extends Subsystem
{	
	static CANTalon motorLifterRight = new CANTalon(RobotMap.talonDevIDLifterRight); //main
	static CANTalon motorLifterLeft = new CANTalon(RobotMap.talonDevIDLifterLeft); //follower
	static DigitalSource limitSwitch = new DigitalInput(16);
	static AnalogInput photoSwitch = new AnalogInput(0);
		
		public Lifter(){
			super();
			motorLifterLeft.changeControlMode(ControlMode.Follower);
			motorLifterLeft.set(16);
		}
		
		
		protected void initDefaultCommand() {
		}
		
		
		public void liftUp(){ // brings lift up du
			//set motor speeds for when you call LiftUp
			motorLifterRight.set(-1.0);
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", false);
			SmartDashboard.putBoolean("LiftUp", true);
		}
		
		
		public void liftDown() //brings lift down du.
		{
			//set motor speeds for when you call LiftDown
				motorLifterRight.set(0.5);
				SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
				SmartDashboard.putBoolean("LiftDown", true);
				SmartDashboard.putBoolean("LiftUp", false);	
		}
		
		
		public void liftStop() //stops lift motors du
		{
			//set motor speeds for when you call LiftStop
			motorLifterRight.set(0);			
			SmartDashboard.putNumber("LiftMotor", motorLifterRight.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", false);
			SmartDashboard.putBoolean("LiftUp", false);
		}
		public void liftAutoUp()
		{
			//set motor speeds for when you call LiftUp
			if(photoSwitch.getVoltage() >10){	
					motorLifterRight.set(-1.0);
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
					motorLifterRight.set(0.5);
					SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
					SmartDashboard.putBoolean("LiftDown", true);
					SmartDashboard.putBoolean("LiftUp", false);
			}else {
					motorLifterRight.set(0.0);
					SmartDashboard.putString("LiftDown", "error-not-in");
					SmartDashboard.putString("LiftUp", "error-not-in");
			} 
		}
}
