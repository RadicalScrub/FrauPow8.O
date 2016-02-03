package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BothDriveTrain extends Subsystem {
	
	Talon leftMotor = new Talon(RobotMap.leftTalonOne);
	Talon rightMotor = new Talon(RobotMap.rightTalonThree);
	
	RobotDrive driver = new RobotDrive(leftMotor, rightMotor);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void forward() {
    	leftMotor.set(.5);
    	
    	rightMotor.set(.5);
    	
    }
    
    public void backward() {
    	leftMotor.set(-.5);
    	
    	
    	rightMotor.set(-.5);
    	
    }
    
    public void stop() {
    	leftMotor.stopMotor();
    	
    	
    	rightMotor.stopMotor();
    	
    }
    
    public void driveJoy(Joystick joy) {
    	driver.arcadeDrive(joy);
    }
}

