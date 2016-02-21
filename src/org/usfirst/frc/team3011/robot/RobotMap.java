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
	
	/* PWM Channels
	 * Assume all motors are Victors. 
	 * Divided PWM channels by subsystems.
	 */
	
	public static int winchMotorOne = 1;  //winchMotor
	
	public static int liftMotorTwo = 2;	//liftMotor?
	
	public static int shootLeftThree = 3; //Victor shootRight
	public static int shootRightFour = 4; //Victor shootLeft
	
	public static int leftServoEight = 8; //SuperShift leftServo
	public static int rightServoNine = 9; //SuperShift rightServo
	
	/* CAN Talons
	 * Switched to CAN system instead of PWM in 2016. We Daisy Chain now boyz!
	 * Divided CAN iD's by subsystems.
	 */
	
	public static int leftDriveOne = 1;	//Left DriveTrain Motor 1
	public static int leftDriveTwo = 2;	//Left DriveTrain Motor 2
	public static int rightDriveThree = 3;	//Right DriveTrain Motor 1
	public static int rightDriveFour = 4;	//Right DriveTrain Motor 2
	
	public static int cArmFive = 5;
	
}
