package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.PWM.PeriodMultiplier;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Servos extends Subsystem {
    
	private Servo binServo = new Servo(9);
	
	
	
    public void initDefaultCommand()
    {
    	binServo.setPeriodMultiplier(PeriodMultiplier.k4X);
    }

	public void servo0()
	{
		binServo.set(0.0);	
	}

	public void servo90()
	{
		binServo.set(1.0);
	}
}