package org.usfirst.frc.team4859.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static int talonDevIDChassisRight = 13;//14 real bot
	public static int talonDevIDChassisLeft = 15;//12 real bot
	
	public static int  talonDevIDLifterRight =  16; //Looking with input backwards and output forwards
	public static int  talonDevIDLifterLeft =  11;  //Looking with input backwards and output forwards
	
	// Create precision mode variable and set to false by default
	public static boolean pMode = false;
}
