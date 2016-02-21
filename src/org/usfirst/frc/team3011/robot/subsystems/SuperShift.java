package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class SuperShift extends Subsystem {
    
	private Servo leftServo;
	private Servo rightServo;
	
	public SuperShift() {
		super();
		
		leftServo = new Servo(RobotMap.leftServoEight);
		rightServo = new Servo(RobotMap.rightServoNine);
		
		
		LiveWindow.addActuator("SuperShift", "Left Servo", leftServo);
		LiveWindow.addActuator("SuperShift", "Right Servo", rightServo);
	}
	
	//0 - Fast
	//1 - Normal
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	leftServo.setPosition(0);
    	rightServo.setPosition(1);
    }
    
    /**
     * Speeds up DriveTrain.
     */
    
    public void setPosition(double leftPos, double rightPos) {
    	leftServo.set(leftPos);
    	rightServo.set(rightPos);
    }
}

