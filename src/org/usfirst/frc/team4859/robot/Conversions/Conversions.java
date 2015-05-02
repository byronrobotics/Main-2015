package org.usfirst.frc.team4859.robot.Conversions;

public class Conversions {
	
	public static double dist2timeconst = .2;
	public static double distance2time(double distance)
	{
		return distance *dist2timeconst;
	}
}


