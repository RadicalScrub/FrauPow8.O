package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor shooterMotorLeft = new Victor(RobotMap.leftVictorFive);
	Victor shooterMotorRight = new Victor(RobotMap.rightVictorFour);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shoot(){
    	shooterMotorLeft.set(.9);
    	shooterMotorRight.set(-.9);
    	/**
    	try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	
    }
    
    public void inverseSpin() {
    	shooterMotorLeft.set(-.5);
    	shooterMotorRight.set(.5);
    }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	shooterMotorLeft.set(0);
    	shooterMotorRight.set(0);
    }
    
    //static DigitalInput limitSwitch = newDigitalInput(1);
	//public static Boolean get(){
	//	return limitSwitch.get();
	

}

