package org.usfirst.frc.team4859.robot;

import org.usfirst.frc.team4859.robot.autonomous.AutoStartLeftCan;
import org.usfirst.frc.team4859.robot.autonomous.AutoStartLeftTote;
import org.usfirst.frc.team4859.robot.autonomous.AutoStartMidCan;
import org.usfirst.frc.team4859.robot.autonomous.AutoStartMidTote;
import org.usfirst.frc.team4859.robot.autonomous.AutoStartRightCan;
import org.usfirst.frc.team4859.robot.autonomous.AutoStartRightTote;
import org.usfirst.frc.team4859.robot.autonomous.Autonomous;
import org.usfirst.frc.team4859.robot.subsystems.Chassis;
import org.usfirst.frc.team4859.robot.subsystems.Intake;
import org.usfirst.frc.team4859.robot.subsystems.Lifter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot
{
	//Create subsystems
	public static Chassis chassis;
	public static Intake intake;
	public static Lifter lifter;
	public static OI oi;
	
    Command autonomousCommand;
    SendableChooser autonomousChooser;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	chassis = new Chassis();
    	intake = new Intake();
    	lifter = new Lifter();
		oi = new OI();
		
		autonomousChooser = new SendableChooser();
		autonomousChooser.addDefault("Start Left Get Tote", new AutoStartLeftTote());
		autonomousChooser.addDefault("Start Mid Get Tote", new AutoStartMidTote());
		autonomousChooser.addDefault("Start Right Get Tote", new AutoStartRightTote());
		autonomousChooser.addDefault("Start Left Get Can", new AutoStartLeftCan());
		autonomousChooser.addDefault("Start Mid Get Can", new AutoStartMidCan());
		autonomousChooser.addDefault("Start Right Get Can", new AutoStartRightCan());
		autonomousChooser.addDefault("Start Auto", new Autonomous());
		SmartDashboard.putData("Autonomous Mode Chooser", autonomousChooser);
		
        // instantiate the command used for the autonomous period
        autonomousCommand = new Autonomous();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command) autonomousChooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
