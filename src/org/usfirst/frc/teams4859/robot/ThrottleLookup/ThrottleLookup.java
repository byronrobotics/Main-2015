package org.usfirst.frc.teams4859.robot.ThrottleLookup;

public class ThrottleLookup 
{
	


	public static double[][] correctionTable1 = {
		{.02, .30, .60, .90, 1.0},
		{.00, .20, .30, .90, 1.0}};

	public static double[][] correctionTable2 = {
		{.02, .30, .60, .90, 1.0},
		{.00, .20, .30, .90, 1.0}};

	public static double[][] correctionTable3 = {
		{.02, .30, .60, .90, 1.0},
		{.00, .20, .30, .90, 1.0}};

	
	public static double calcJoystickCorrection(int tableNumber, double x)
	{
		double[][] correctionTable;
		
		switch (tableNumber)
		{
			case 1: correctionTable = correctionTable1;
				break;
			case 2: correctionTable = correctionTable2;
				break;
			case 3: correctionTable = correctionTable3;
				break;
			default : correctionTable = correctionTable1;
		}
		boolean isNegative = x < 0;
		
		x = Math.abs(x);
		
		int pos = 0; 
		double returnValue;
		
		while ((pos < 5) && (x > correctionTable1[0][pos]))
		{
			pos++;
		}
		
		if (pos < 5)
		{
			if (pos != 0)
			{
				double y1 = correctionTable[1][pos];
				double y2 = correctionTable[1][pos-1];
				double x1 = correctionTable[0][pos];
				double x2 = correctionTable[0][pos-1];
				returnValue = y1 + ((y1-y2)/(x1-x2)) * (x-x1);
			}
			else
			{
				return 0;
			}
		}
		else
		{
			return 1.0;
		}
		
		if (isNegative)
			x = -x;
		
		return returnValue;
	}
}
