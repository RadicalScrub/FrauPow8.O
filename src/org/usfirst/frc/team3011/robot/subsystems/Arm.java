package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor armMotor = new Victor(RobotMap.leftTalonOne);
	
    public void initDefaultCommand() {
    	
    }
    
    /**
     * Motor speed is set to .5
     */
    public void forward() {
    	armMotor.set(.5);
    }
    
    /**
     * Motor speed is set to -.5
     */
    public void backward() {
    	armMotor.set(-.5);
    }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	armMotor.set(0);
    }
}

