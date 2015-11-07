package org.usfirst.frc.team4859.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Servos extends Subsystem {

	private Servo binServo = new Servo(9);

	public void initDefaultCommand() {
		// binServo.setBounds(1.9, 0, 0, 0, 1.5);
	}

	public void servo0() {
		binServo.setAngle(180.0);
	}

	public void servo90() {
		binServo.setAngle(270.0);
	}
}