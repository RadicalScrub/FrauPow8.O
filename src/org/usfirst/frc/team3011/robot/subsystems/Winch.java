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
		
		winchMotor = new Victor(RobotMap.rightVictorTwo);
		
		LiveWindow.addActuator("Winch", "Motor", winchMotor);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Winch pulls up Lift by Speed 1
     */
    public void up(){
    	winchMotor.set(1);
    }
    
    /**
     * Winch pulls down Lift backward by Speed -1
     */
    public void down() {
    	winchMotor.set(-1);
    }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	winchMotor.disable();
    }
    
    
}

