package org.usfirst.frc.team4859.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	
	double[][] joystickCorrectionTable = new double[2][4];
	
	
	
	// Define a joystick on port 0
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
		joystickP0 = new Joystick(0);
	//bind buttons to commands here	MAYBE
		initJoystickTable();
	}
	
	
	private void initJoystickTable() {
		// TODO Auto-generated method stub
		joystickCorrectionTable[0][0]= .01;
		joystickCorrectionTable[1][0]= .30;
		joystickCorrectionTable[2][0]= .50;
		joystickCorrectionTable[3][0]= .80;
		
		joystickCorrectionTable[0][1]= .00;
		joystickCorrectionTable[1][1]= .30;
		joystickCorrectionTable[2][1]= .50;
		joystickCorrectionTable[3][1]= .80;
	}


	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

