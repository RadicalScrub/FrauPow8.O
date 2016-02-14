package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Arm extends Subsystem {
	
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	//CHANGE to Victor if there isn't 5 Talon's on Electronic Board (testBoard)
	private Victor armMotor;
	
	private Encoder enc;
	
	private int encCount;
	
	public Arm() {
		super();
		
		//CHANGE to pArmMotorZero if there isn't 5 Talon's on Electronic Board (testBoard)
		armMotor = new Victor(RobotMap.pArmMotorZero);
		enc = new Encoder(0,1,false,Encoder.EncodingType.k4X);
		encCount = enc.get();
		
		LiveWindow.addActuator("Arm", "Motor", armMotor);
	}
	
    public void initDefaultCommand() {
    	
    }
    
    
    /**
     * Rotates arm forward by Speed 1
     */
    public void forward() {
    	armMotor.set(1);
    	
    }
    
    /**
     * Rotate arm backward by Speed -1
     */
    public void backward() {
    	armMotor.set(-1);
    }
    
    /**
     * Rotate arm a full rotation by Speed 1
     */
   public void kickOneRotate(){
	   //IMPLEMENT WHEN ENCODERS ARE CODED.
	   armMotor.set(1);
   }
    
    /**
     * Stop motor. 
     */
    public void stop() {
    	armMotor.disable();
    }
    
    /**
     * Returns the ArmEncoder's count.
     * @return
     */
    public int getEncCount() {
    	return encCount;
    }
    
    /**
     * Restarts the ArmEncoder's count.
     */
    public void restartEnc() {
    	enc.reset();
    	encCount = enc.get();
    }
    
    public void autoSwagDINO(Encoder enc) {
    	
    	do {
    		armMotor.set(.5);
    	}while(enc.getRaw() < 2);
    	
    }
}

