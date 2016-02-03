package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainRight extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 
	Talon rightMotor = new Talon(RobotMap.rightTalonThree);
	Victor rightVMotor = new Victor(RobotMap.rightVictorTwo);
			
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void forward() {
    	
    	rightMotor.set(.5);
    	    	
    	rightVMotor.set(.5);
    }
    
    public void backward() {
    	rightMotor.set(-.5);
    	
    	rightVMotor.set(-.5);
    }
    
    public void stop() {
    
    	rightMotor.stopMotor();
    	
    
    	rightVMotor.stopMotor();
    }
    
    public void setSpeed(double speed) {
        	rightMotor.set(speed);
    }
    
    
    
    public double getRightSpeed() {
    	return rightMotor.getSpeed();
    }
}

