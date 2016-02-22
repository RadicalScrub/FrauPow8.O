package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Victor shootLeft;
	private Victor shootRight;
	

	public Shooter() {
		super();
		
		shootLeft = new Victor(RobotMap.shootLeftThree);
		shootRight = new Victor(RobotMap.shootRightFour);
		
		//Negative speed value makes the leftShoot go up. Thus, I have inverted the motor so it is consistent with the right motor.
		shootLeft.setInverted(true);
		
		shootLeft.setSafetyEnabled(true);
		shootRight.setSafetyEnabled(true);
		
		LiveWindow.addActuator("Left Shooter", "Motor", shootLeft);
		LiveWindow.addActuator("Right Shooter", "Motor", shootRight);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	shootLeft.set(0);
    	shootRight.set(0);
    }
    
    public void setShoot(double speed) {
    	shootLeft.set(speed);
    	shootRight.set(speed);
    }
    
    /**
     * Disable motors.
     */
    public void stop() {
    	shootLeft.disable();
    	shootRight.disable();
    }
	

}

