package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalSource;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;

// The lifing mecanism contorll 
public class Lifter extends Subsystem
{	
	CANTalon motorLifterLeft = new CANTalon(13);
	CANTalon motorLifterRight = new CANTalon(16);
	static DigitalSource limitSwitch = new DigitalInput(16);

		
		public Lifter(){
			super();
		}

		public static boolean isSwitchSet() {
			return false;
	        
	    }
		protected void initDefaultCommand() {
		}
		
		public void liftUp(){ // brings lift up du
			//set motor speeds for when you call LiftUp
			motorLifterLeft.set(0.25);
			motorLifterRight.set(0.25);
			SmartDashboard.putNumber("LiftMotor Left", motorLifterLeft.getEncVelocity());
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", false);
			SmartDashboard.putBoolean("LiftUp", true);

		}
		
		
		public void liftDown() //brings lift down du.
		{
			//set motor speeds for when you call LiftDown
			motorLifterLeft.set(-0.25);
			motorLifterRight.set(-0.25);
			SmartDashboard.putNumber("LiftMotor Left", motorLifterLeft.getEncVelocity());
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", true);
			SmartDashboard.putBoolean("LiftUp", false);
		}
		
		
		public void liftStop() //stops lift motors du
		{
			//set motor speeds for when you call LiftStop
			motorLifterLeft.set(0);
			motorLifterRight.set(0);
			SmartDashboard.putNumber("LiftMotor Left", motorLifterLeft.getEncVelocity());
			SmartDashboard.putNumber("LiftMotor Right", motorLifterRight.getEncVelocity());
			SmartDashboard.putBoolean("LiftDown", false);
			SmartDashboard.putBoolean("LiftUp", false);
		}
}
