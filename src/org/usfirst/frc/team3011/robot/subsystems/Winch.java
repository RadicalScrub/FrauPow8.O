package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Winch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private Victor winchMotor;
	
	public Winch() {
		super();
		
		winchMotor = new Victor(RobotMap.winchMotorOne);
		
		winchMotor.setSafetyEnabled(true);
		
		LiveWindow.addActuator("Winch", "Motor", winchMotor);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Sets speed for Winch.
     * @param speed - Between -71 and 1.
     */
    public void setSpeed(double speed) {
    	winchMotor.set(speed);
    }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	winchMotor.disable();
    }
    
    
}

