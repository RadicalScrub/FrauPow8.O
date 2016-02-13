package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SuperShift extends Subsystem {
    
	private Servo leftServo;
	private Servo rightServo;
	
	public SuperShift() {
		super();
		
		leftServo = new Servo(RobotMap.leftServo);
		rightServo = new Servo(RobotMap.rightServo);

	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shiftUp() {
    	leftServo.set(1);
    	rightServo.set(1);
    }
    
    public void shiftDown() {
    	leftServo.set(0);
    	rightServo.set(0);
    }
}

