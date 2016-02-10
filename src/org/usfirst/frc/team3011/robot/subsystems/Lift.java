package org.usfirst.frc.team3011.robot.subsystems;


import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *	Theoritical Class. May use in final build.
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor liftMotor;
	
	public Lift() {
		super();
		
		liftMotor = new Victor(RobotMap.rightVictorFour);
		
		LiveWindow.addActuator("Lift", "Motor", liftMotor);
	}

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

