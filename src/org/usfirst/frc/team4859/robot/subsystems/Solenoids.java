package org.usfirst.frc.team4859.robot.subsystems;

import org.usfirst.frc.team4859.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Solenoids extends Subsystem {
    
	static Solenoid Solenoid1A = new Solenoid(RobotMap.solenoidDevIDSolenoid1A);
	static Solenoid Solenoid2B = new Solenoid(RobotMap.solenoidDevIDSolenoid2B);
	static Solenoid Solenoid3X = new Solenoid(RobotMap.solenoidDevIDSolenoid3X);
	static Solenoid Solenoid4Y = new Solenoid(RobotMap.solenoidDevIDSolenoid4Y);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Solenoids()
	{
		super();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Solenoid1AOn()
    {
    	Solenoid1A.set(true);
    }
    
    public void Solenoid1AOff()
    {
    	Solenoid1A.set(false);
    }
    
    
    
    public void Solenoid2BOn()
    {
    	Solenoid2B.set(true);
    }
    
    public void Solenoid2BOff()
    {
    	Solenoid2B.set(false);
    }
    
    
    
    public void Solenoid3XOn()
    {
    	Solenoid3X.set(true);
    }
    
    public void Solenoid3XOff()
    {
    	Solenoid3X.set(false);
    }
    
    
    
    public void Solenoid4YOn()
    {
    	Solenoid4Y.set(true);
    }
    
    public void Solenoid4YOff()
    {
    	Solenoid4Y.set(false);
    } 
}

