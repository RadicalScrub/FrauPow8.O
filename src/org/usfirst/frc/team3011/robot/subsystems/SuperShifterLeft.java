package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SuperShifterLeft extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

		Talon cim1 = new Talon(RobotMap.leftTalonSix);
		Talon cim2 = new Talon(RobotMap.rightTalonSeven);

        public void initDefaultCommand() {
            // Set the default command for a subsystem here.
            //setDefaultCommand(new MySpecialCommand());
        }
        
        public void forward(){
        	cim1.set(.5);
        	cim2.set(.5);
        }
        
        public void backward() {
        	cim1.set(-.5);
        	cim2.set(-.5);
        }
        
        /**
         * Motor speed is set to 0.
         */
        public void stop() {
        	cim1.set(0);
        	cim2.set(0);
        }
    }


