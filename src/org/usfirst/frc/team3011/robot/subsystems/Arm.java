package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Arm extends Subsystem {
	
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//CHANGE to Victor if there isn't 5 Talon's on Electronic Board (testBoard)
	private CANTalon armMotor;
	
	public Arm() {
		super();
		
		//CHANGE to pArmMotorZero if there isn't 5 Talon's on Electronic Board (testBoard)
		armMotor = new CANTalon(RobotMap.cArmFive);
		armMotor.setSafetyEnabled(true);
		
		LiveWindow.addActuator("Arm", "Motor", armMotor);
	}
	
    public void initDefaultCommand() {
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    /**
     * Set speed for Arm.
     * @param speed - Between -1 & 1.
     */
    public void setSpeed(double speed) {
    	armMotor.set(speed);
    }
    
    /**
     * Stop motor. 
     */
    public void stop() {
    	armMotor.disable();
    }
}

