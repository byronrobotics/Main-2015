package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lifter extends Subsystem
{
	CANTalon motorLifterLeft = new CANTalon(0/*Put CANTalon ID here*/);
	CANTalon motorLifterRight = new CANTalon(0/*Put CANTalon ID here*/);
	
		public Lifter()
		{
			super();
		}

		
		protected void initDefaultCommand() {}
		
		
		public void liftUp()
		{
			//set motor speeds for when you call LiftUp
			motorLifterLeft.set(0.25);
			motorLifterRight.set(0.25);
		}
		
		
		public void liftDown()
		{
			//set motor speeds for when you call LiftDown
			motorLifterLeft.set(-0.25);
			motorLifterRight.set(-0.25);
		}
		
		
		public void liftStop()
		{
			//set motor speeds for when you call LiftStop
			motorLifterLeft.set(0);
			motorLifterRight.set(0);
		}
}
