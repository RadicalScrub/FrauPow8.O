package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;
import org.usfirst.frc.team3011.robot.commands.TankDriveTrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private Talon leftMotor;
	private Talon rightMotor;
	private RobotDrive driver;
	
	public DriveTrain() {
		super();
		
		leftMotor = new Talon(RobotMap.leftTalonOne);
		rightMotor = new Talon(RobotMap.rightTalonThree);
		
		driver = new RobotDrive(leftMotor, rightMotor);
		
		LiveWindow.addActuator("Left Wheels", "Left Motor", leftMotor);
		LiveWindow.addActuator("Right Wheels", "Right Motor", rightMotor);
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
     * Test code. Motors spin forward at max speed.
     */
    public void forward() {
    	leftMotor.set(1);
    	
    	rightMotor.set(1);
    }
    
    /**
     * Test code. Motors spin backward at max speed.
     */
    public void backward() {
    	leftMotor.set(-1);
    	
    	rightMotor.set(-1);
    }
    
    /**
     * Stop motors.
     */
    public void stop() {
    	leftMotor.disable();
    	rightMotor.disable();
    	
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

