package org.usfirst.frc.team4859.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	
	Joystick joystickP0 = new Joystick(0);
	//created intake in button on joystickP0 on button 1
	Button intakeIn = new JoystickButton(joystickP0,1);
	//created intakeOut button on joystickP0 on button 2
	Button intakeOut = new JoystickButton(joystickP0,2);
	//// CREATING THINGS
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
	public OI()
	{	
	//bind buttons to commands here	MAYBE
	}
	
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

