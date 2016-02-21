package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;
import org.usfirst.frc.team3011.robot.commands.TankDriveTrain;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Not so sure about RobotDrive. Only worked with two motors instead of four. Test this out.
 * Also not sure about disable() method for SpeedControllers. Test this out too.
 */
public class DriveTrain extends Subsystem {
	
	private CANTalon leftMotor1;
	private CANTalon leftMotor2;
	private CANTalon rightMotor1;
	private CANTalon rightMotor2;
	
	private RobotDrive driver;
	
	public DriveTrain() {
		super();
		
		leftMotor1 = new CANTalon(RobotMap.leftDriveOne);
		leftMotor2 = new CANTalon(RobotMap.leftDriveTwo);
		
		rightMotor1 = new CANTalon(RobotMap.rightDriveThree);
		rightMotor2 = new CANTalon(RobotMap.rightDriveFour);
		
		leftMotor1.setSafetyEnabled(true);
		leftMotor2.setSafetyEnabled(true);
		rightMotor1.setSafetyEnabled(true);
		rightMotor2.setSafetyEnabled(true);
		
		driver = new RobotDrive(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
		
		LiveWindow.addActuator("Drive Train", "Left Motor1", leftMotor1);
		LiveWindow.addActuator("Drive Train", "Left Motor2", leftMotor2);
		LiveWindow.addActuator("Drive Train", "Right Motor1", rightMotor1);
		LiveWindow.addActuator("Drive Train", "Right Motor2", rightMotor2);
	}
	
	/**
	 * If no commands made (usually none), then default Command is TankDriveTrain.
	 */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new TankDriveTrain());
    }
    
    /**
     * Sets speed for DriveTrain.
     * @param speed - Between -1 & 1.
     */
    public void setSpeed(double speed) {
    	leftMotor1.set(speed);
    	leftMotor2.set(speed);
    	rightMotor1.set(speed);
    	rightMotor2.set(speed);
    }
    
    public void stop() {
    	leftMotor1.disable();
    	leftMotor2.disable();
    	rightMotor1.disable();
    	rightMotor2.disable();
    }
    
    public void betterDrive(Joystick joy) {
    	double leftAxis = -(joy.getRawAxis(0));	//Left Y-Axis
    	double rightAxis = joy.getRawAxis(4);	//Right X-Axis
    	
    	if(rightAxis == 0) {
    		leftMotor1.set(leftAxis);
    		leftMotor2.set(leftAxis);
    		rightMotor1.set(leftAxis);
    		rightMotor2.set(leftAxis);
    	}
    	
    }
    
    /**
     * Drive the DriveTrain using ArcadeStyle joysticks.
     * @param joy Driver's gamepad
     */
    public void driveArcadeJoy(Joystick joy) {
    	driver.arcadeDrive(joy);
    }
    
    /**
     * Drive the DriveTrain using TankStyle joystick.
     * @param joy Driver's gamepad
     */
    public void driveTankJoy(Joystick joy) {
    	driver.tankDrive(-(joy.getRawAxis(1)), -(joy.getRawAxis(5)));
    }
    
}

