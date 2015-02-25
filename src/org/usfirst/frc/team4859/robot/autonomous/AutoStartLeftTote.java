package org.usfirst.frc.team4859.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoStartLeftTote extends CommandGroup {
    
    public  AutoStartLeftTote()
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
    	System.out.println("AutoStartLeftTote");
    	addSequential(new DriveStraight(1.5));
    	addSequential(new LiftUpTime(0.6));
    	addSequential(new DriveBackwards(1.5));
    	addSequential(new DriveRight180(1));
    	addSequential(new DriveStraight(4));
    	addSequential(new DriveStop());

    }
}
