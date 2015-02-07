package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.IntakeIn;
import org.usfirst.frc.team4859.robot.commands.IntakeOut;
import org.usfirst.frc.team4859.robot.commands.LiftDown;
import org.usfirst.frc.team4859.robot.commands.LiftUp;
import org.usfirst.frc.team4859.robot.commands.PrecisionMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	
	double[][] joystickCorrectionTable = new double[2][4];
	
	//Button 10 Taken in Chassis for Encoders
	
	// Define a joystick on port 0
	Joystick joystickP0 = new Joystick(0);
	
	Button precisionMode = new JoystickButton(joystickP0, 8);

	// Create precision mode button on for button 8
	public static boolean pMode = false;
	
	// Create intake in button on joystickP0 for button 1
	Button intakeIn = new JoystickButton(joystickP0,1);
	
	// Create intakeOut button on joystickP0 for button 2
	Button intakeOut = new JoystickButton(joystickP0,2);
	
	// Create liftDown button on joystickP0 for button 3
	Button liftDown = new JoystickButton(joystickP0, 3);
	
	// Create liftUp button on joystickP0 for button 4
	Button liftUp = new JoystickButton(joystickP0, 4);
	
	public OI()
	{
		precisionMode.toggleWhenPressed(new PrecisionMode());
		intakeIn.whenPressed(new IntakeIn());
		intakeOut.whenPressed(new IntakeOut());
		liftDown.whenPressed(new LiftDown());
		liftUp.whenPressed(new LiftUp());
		
		
	}
	
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

