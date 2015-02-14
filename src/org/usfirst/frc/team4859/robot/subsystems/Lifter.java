package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

// The lifting mechanism  control
public class Lifter extends Subsystem
{	
	static CANTalon motorLifter = new CANTalon(RobotMap.talonDevIDLifter);
	static DigitalSource limitSwitch = new DigitalInput(16);
	static DigitalInput photoSwitch = new DigitalInput(1);
		
		public Lifter(){
			super();
		}
		
		
		protected void initDefaultCommand() {}
		
		
		public void liftUp(){ // brings lift up du
			//set motor speeds for when you call LiftUp
			motorLifter.set(-1.0);
			SmartDashboard.putNumber("LiftMotor Right", motorLifter.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", false);
			SmartDashboard.putBoolean("LiftUp", true);
		}
		
		
		public void liftDown() //brings lift down du.
		{
			//set motor speeds for when you call LiftDown
				motorLifter.set(0.5);
				SmartDashboard.putNumber("LiftMotor Right", motorLifter.getEncVelocity());
				SmartDashboard.putBoolean("LiftDown", true);
				SmartDashboard.putBoolean("LiftUp", false);	
		}
		
		
		public void liftStop() //stops lift motors du
		{
			//set motor speeds for when you call LiftStop
			motorLifter.set(0);			
			SmartDashboard.putNumber("LiftMotor", motorLifter.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", false);
			SmartDashboard.putBoolean("LiftUp", false);
		}
		public void liftauto()
		{
			//set motor speeds for when you call LiftUp
			if(photoSwitch.get() ==true){	
					motorLifter.set(-1.0);
					SmartDashboard.putNumber("LiftMotor Right", motorLifter.getEncVelocity());
					SmartDashboard.putBoolean("LiftDown", false);
					SmartDashboard.putBoolean("LiftUp", true);
				} else if(photoSwitch.get() ==false){
					motorLifter.set(0.0);
					SmartDashboard.putString("LiftDown", "error-not-in");
					SmartDashboard.putString("LiftUp", "error-not-in");
				} 
		}
}
