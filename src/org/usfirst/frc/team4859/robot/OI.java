package org.usfirst.frc.team4859.robot;


import org.usfirst.frc.team4859.robot.commands.LiftDown;
import org.usfirst.frc.team4859.robot.commands.LiftUp;
import org.usfirst.frc.team4859.robot.commands.PrecisionMode;
import org.usfirst.frc.team4859.robot.commands.PrecisionOff;
import org.usfirst.frc.team4859.robot.commands.PrecisionOn;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	//Button 10 Taken in Chassis for Encoders
	
	// Define a joystick on port 0
	Joystick joystickP0 = new Joystick(0);
	
	Button precisionMode = new JoystickButton(joystickP0, 8);

	// Create intakeOut button on joystickP0 for button 2
	Button precisionMode1 = new JoystickButton(joystickP0, 2);
	
	// Create liftDown button on joystickP0 for button 3
	Button liftDown = new JoystickButton(joystickP0, 3);
	
	// Create liftUp button on joystickP0 for button 4
	Button liftUp = new JoystickButton(joystickP0, 4);
	
	public OI()
	
	{
		precisionMode.whenPressed(new PrecisionMode());
		//intakeIn.whenPressed(new IntakeIn());
		precisionMode1.whenPressed(new PrecisionOn());
		precisionMode1.whenReleased(new PrecisionOff());
		liftDown.whenPressed(new LiftDown());
		liftUp.whenPressed(new LiftUp());
	}
	
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

