package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.commands.LiftDown;
import org.usfirst.frc.team4859.robot.commands.LiftDownFast;
import org.usfirst.frc.team4859.robot.commands.LiftStop;
import org.usfirst.frc.team4859.robot.commands.LiftUp;
import org.usfirst.frc.team4859.robot.commands.LiftUpFast;
import org.usfirst.frc.team4859.robot.commands.PrecisionMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {	
	// Create a joystick on port 0
	private final Joystick joystickP0 = new Joystick(0);

	// Create a joystick (xbox controller) on port 1
	private final Joystick xboxP1 = new Joystick(1);
	
	// Create button for precision mode for joystick button 12
	Button precisionMode = new JoystickButton(joystickP0, 12);
	
	// Create liftDown button on xboxP1 for button 6
	Button liftDown = new JoystickButton(xboxP1, 2);
	Button liftDownFast = new JoystickButton(xboxP1, 4);
	
	// Create liftUp button on xboxP1 for button 5
	Button liftUp = new JoystickButton(xboxP1, 1);
	Button liftUpFast = new JoystickButton(xboxP1, 3);
	
	public OI()
	{
		precisionMode.toggleWhenPressed(new PrecisionMode());
		
		liftUp.whileHeld(new LiftUp());
		liftUpFast.whileHeld(new LiftUpFast());
		
		liftDown.whileHeld(new LiftDown());
		liftDownFast.whileHeld(new LiftDownFast());	}
	
	public Joystick getJoystick()
	{
		return joystickP0;
	}
	
//	public Joystick getJoystickP1()
//	{
//		return joystickP1;
//	}
}

