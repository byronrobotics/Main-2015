package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team4859.robot.Conversions.Conversions;

public class Autonomous extends CommandGroup {
    
    public  Autonomous()
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	//Time Of auto is 15 Period DOO THE MATH
    	addParallel(new LiftUpTime(0));
    	addSequential(new DriveRight180(Conversions.distance2time(1)));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveLeft180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveLeft180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveRight180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new LiftDownTime(0));
    	addParallel(new LiftUpTime(0));
    	addSequential(new DriveRight180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveLeft180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveLeft180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveRight180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new LiftDownTime(0));
    	addParallel(new LiftUpTime(0));
    	addSequential(new DriveRight180(0));
    	addSequential(new DriveStraight(0));
    	addSequential(new DriveLeft180(0));
    	addSequential(new LiftDownTime(0));
    	addSequential(new DriveBackwards(0));
    	addSequential(new DriveStop());
    }
}
