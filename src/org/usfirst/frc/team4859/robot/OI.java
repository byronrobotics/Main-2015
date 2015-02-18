package org.usfirst.frc.team4859.robot;


import org.usfirst.frc.team4859.robot.commands.DriveTest;
import org.usfirst.frc.team4859.robot.commands.LiftDown;
import org.usfirst.frc.team4859.robot.commands.LiftDownBeast;
import org.usfirst.frc.team4859.robot.commands.LiftStop;
import org.usfirst.frc.team4859.robot.commands.LiftUp;
import org.usfirst.frc.team4859.robot.commands.LiftUpDeath;
import org.usfirst.frc.team4859.robot.commands.PrecisionMode;
//import org.usfirst.frc.team4859.robot.commands.PrecisionOff;
//import org.usfirst.frc.team4859.robot.commands.PrecisionOn;





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
	private final Joystick joystickP0 = new Joystick(0);
	// Define a joystick(xbox controller) on port 1
	private final Joystick xboxP1 = new Joystick(1);
	
	Button precisionMode = new JoystickButton(joystickP0, 12);

	// Create intakeOut button on joystickP0 for button 2
	//Button precisionMode1 = new JoystickButton(joystickP0, 9);
	
	// Create liftDown button on xboxP1 for button 6
	Button liftDown = new JoystickButton(xboxP1, 2);
	// Create liftUp button on xboxP1 for button 5
	Button liftUp = new JoystickButton(xboxP1, 1);
	Button liftUpDeath = new JoystickButton(xboxP1, 3);
	Button liftDownBeast = new JoystickButton(xboxP1, 4);
	
	//Button test = new JoystickButton(joystickP0, 2);
	
	public OI()
	
	{
		precisionMode.toggleWhenPressed(new PrecisionMode());
		liftUp.whenPressed(new LiftUp());
		liftUp.whenReleased(new LiftStop());
		liftDown.whenPressed(new LiftDown());
		liftDown.whenReleased(new LiftStop());
		liftUpDeath.whenPressed(new LiftUpDeath());
		liftUpDeath.whenReleased(new LiftStop());
		liftDownBeast.whenPressed(new LiftDownBeast());
		liftDownBeast.whenReleased(new LiftStop());
		//test.whileHeld(new DriveTest());
	}
	
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
	
//	public Joystick getJoystickP1()
//	{
//		return joystickP1;
//	}
}

