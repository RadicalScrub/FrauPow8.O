package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
	
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Victor armMotor = new Victor(RobotMap.leftVictorZero);
	
	public Encoder enc = new Encoder(0,1,false,Encoder.EncodingType.k4X);
	
	int count = enc.get();
	
    public void initDefaultCommand() {
    	
    }
    
    /**
     * Motor speed is set to .5
     */
    public void forward() {
    	armMotor.set(1);
    	
    }
    
    /**
     * Motor speed is set to -.5
     */
    public void backward() {
    	armMotor.set(-.5);
    }
    
   public void kick(){
	   armMotor.set(.5);
	  
	   /**
	   try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
   }
    
    /**
     * Motor speed is set to 0.
     */
    public void stop() {
    	armMotor.set(0);
    }
    
    public void autoSwagDINO(Encoder enc) {
    	
    	do {
    		armMotor.set(.5);
    	}while(enc.getRaw() < 2);
    	
    }
}

