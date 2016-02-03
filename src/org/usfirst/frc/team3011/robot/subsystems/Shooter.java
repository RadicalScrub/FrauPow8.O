package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor shooterMotorLeft = new Victor(RobotMap.leftVictorFive);
	Victor shooterMotorRight = new Victor(RobotMap.rightVictorFour);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(){
    	shooterMotorLeft.set(.1);
    	shooterMotorRight.set(-.1);
    	
    	
    }
    
    public void inverseSpin() {
    	shooterMotorLeft.set(-.1);
    	shooterMotorRight.set(.1);
    }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	shooterMotorLeft.set(0);
    	shooterMotorRight.set(0);
    }
}

