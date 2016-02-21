package org.usfirst.frc.team3011.robot.subsystems;


import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *	Theoritical Class. May use in final build.
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Relay liftMotor;
	
	public Lift() {
		super();
		
		liftMotor = new Relay(RobotMap.liftMotorTwo);
		liftMotor.setSafetyEnabled(true);
		LiveWindow.addActuator("Lift", "Motor", liftMotor);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setState(Value relayValue) {
    	liftMotor.set(relayValue);
    }
    
    public void stop() {
    	liftMotor.stopMotor();
    }
    
}

