package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
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
	private DigitalInput trigger;
	
	public Arm() {
		super();
		
		//CHANGE to pArmMotorZero if there isn't 5 Talon's on Electronic Board (testBoard)
		armMotor = new CANTalon(RobotMap.CANArmMotor);
		armMotor.setSafetyEnabled(true);
		 trigger = new DigitalInput(RobotMap.microSwitch);
		
		LiveWindow.addActuator("Arm", "Motor", armMotor);
		LiveWindow.addSensor("Arm", "Microswitch" , trigger);
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
     * Sets the Arm into the Home position. Keeps the ball in the shooter's feed.
     */
    public void goHome() {
    	armMotor.set(-1);
    	while (!trigger.get()) {
    	}
    	armMotor.set(0);
    }
    
    /**
     * Stop motor. 
     */
    public void stop() {
    	armMotor.disable();
    }
}

