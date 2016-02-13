package org.usfirst.frc.team3011.robot;

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
	
	//DO NOT REUSE PORTS. DON'T WASTE 78,162,863,798,123 HOURS DEBUGGING. IF YOU DO, UR DUMB.
	
	public static int leftVictorZero = 0; //Arm
	public static int leftTalonOne = 1; //drive
	
	public static int rightVictorTwo = 2;  //winchMotor
	public static int rightTalonThree = 3; // drive
	
	public static int rightVictorFour = 4; //Lift & shootRight
	public static int leftVictorFive = 5; //shootLeft
	
	//public static int rightShift = 6; //right wheel boost
	
	public static int leftServo = 8; //leftServo
	public static int rightServo = 9; //rightServo
	
	

	
}
