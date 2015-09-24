package org.usfirst.frc.team4859.robot;


import org.usfirst.frc.team4859.robot.commands.Solenoid1A;
import org.usfirst.frc.team4859.robot.commands.Solenoid2B;
import org.usfirst.frc.team4859.robot.commands.Solenoid3X;
import org.usfirst.frc.team4859.robot.commands.Solenoid4Y;
import org.usfirst.frc.team4859.robot.commands.SolenoidStop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private final Joystick xboxP1 = new Joystick(0);
	
		// Create Solenoid1A button on xboxP1 for button 1 (A)
		Button solenoid1A = new JoystickButton(xboxP1, 3);

		// Create Solenoid2B button on xboxP1 for button 2 (B)
		Button solenoid2B = new JoystickButton(xboxP1, 2);
		
		// Create Soldenoid3X button on xboxP1 for button 3 (X)
		Button solenoid3X = new JoystickButton(xboxP1, 5);

		// Create Solenoid4Y button on xboxP1 for button 4 (Y)
		Button solenoid4Y = new JoystickButton(xboxP1, 6);
		
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
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
			solenoid1A.whenPressed(new Solenoid1A());
			solenoid1A.whenReleased(new SolenoidStop());
			solenoid2B.whenPressed(new Solenoid2B());
			solenoid2B.whenReleased(new SolenoidStop());
			solenoid3X.whenPressed(new Solenoid3X());
			solenoid3X.whenReleased(new SolenoidStop());
			solenoid4Y.whenPressed(new Solenoid4Y());
			solenoid4Y.whenReleased(new SolenoidStop());
		}
}

