package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor leftMotorOne = new Victor(RobotMap.leftMotorOne);
	Victor leftMotorTwo = new Victor(RobotMap.leftMotorTwo);
	Victor rightMotorThree = new Victor(RobotMap.rightMotorOne);
	Victor rightMotorFour = new Victor(RobotMap.rightMotorTwo);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	leftMotorOne.set(0);
    	leftMotorTwo.set(0);
    	rightMotorThree.set(0);
    	rightMotorFour.set(0);
    	
    }
    
    public void forward() {
    	leftMotorOne.set(1);
    	leftMotorTwo.set(1);
    	rightMotorThree.set(1);
    	rightMotorFour.set(1);
    }
    
    public void backward() {
    	leftMotorOne.set(-1);
    	leftMotorTwo.set(-1);
    	rightMotorThree.set(-1);
    	rightMotorFour.set(-1);
    }
    
    public void stop() {
    	leftMotorOne.set(0);
    	leftMotorTwo.set(0);
    	rightMotorThree.set(0);
    	rightMotorFour.set(0);
    }
    
}

