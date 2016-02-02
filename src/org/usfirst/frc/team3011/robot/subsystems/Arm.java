package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Victor testMotor = new Victor(RobotMap.armMotor);
	
    public void initDefaultCommand() {
    	
    }
    
    public void forward() {
    	testMotor.set(1);
    }
    
    public void backward() {
    	testMotor.set(-1);
    }
    
    public void stop() {
    	testMotor.set(0);
    }
}

