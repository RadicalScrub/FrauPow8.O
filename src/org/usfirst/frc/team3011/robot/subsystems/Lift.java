package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor liftMotor = new Victor(RobotMap.rightVictorTwo);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void forward(){
    	liftMotor.set(.8);
    }
    
    public void backward() {
    	liftMotor.set(-.8);
    }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	liftMotor.set(0);
    }
}

