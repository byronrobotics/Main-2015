package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.pneumatics.Outp1;
import org.usfirst.frc.team4859.robot.commands.IntakeIn;
import org.usfirst.frc.team4859.robot.commands.IntakeOut;

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
	
	Button precisionMode = new JoystickButton(joystickP0, 8);
	
	//created intake in button on joystickP0 on button 1
	Button intakeIn = new JoystickButton(joystickP0,1);
	
	//created intakeOut button on joystickP0 on button 2
	Button intakeOut = new JoystickButton(joystickP0,2);
	
	public OI()
	{
		precisionMode.toggelwhenPressed(new PrecisionMode());
		intakeIn.whenPressed(new IntakeIn());
		intakeOut.whenPressed(new IntakeOut());
		
	}
	
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
}

