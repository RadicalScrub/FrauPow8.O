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
	
	//CAN Talon's
	public static final int
	leftDriveOne = 1,			//Left DriveTrain Motor 1			
	leftDriveTwo = 2,			//Left DriveTrain Motor 2
	rightDriveThree = 3,		//Right DriveTrain Motor 1
	rightDriveFour = 4,			//Right DriveTrain Motor 2
	CANArmMotor = 5; 			//Arm

	//PWM - Servos
	public static final int
	servo_LeftDrive = 3,
	servo_RightDrive = 4;

	//PWM - Victors
	public static final int
	shootLeftThree = 2,			
	winch = 1,
	shootRightFour = 0;

	//PWM - Relay/Lift
	public static final int
	liftMotor = 5;

	//PWM - Microswitch for Arm
	public static final int
	microSwitch = 9;

	//PWM - Encoder
	public static final int 
	encoderA1 = 0,
	encoderA2 = 1;
	
	//RoboRealm Target Location
	public static final int
	roboRealm_x = 204,
	roboRealm_y = 250;
	
}
