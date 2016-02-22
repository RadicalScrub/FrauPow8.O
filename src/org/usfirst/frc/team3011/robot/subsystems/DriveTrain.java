package org.usfirst.frc.team3011.robot.subsystems;

import org.usfirst.frc.team3011.robot.Robot;
import org.usfirst.frc.team3011.robot.RobotMap;
import org.usfirst.frc.team3011.robot.commands.TankDriveTrain;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Not so sure about RobotDrive. Only worked with two motors instead of four. Test this out.
 * Also not sure about disable() method for SpeedControllers. Test this out too.
 */
public class DriveTrain extends Subsystem {
	
	private CANTalon leftMotor1;
	private CANTalon leftMotor2;
	private CANTalon rightMotor1;
	private CANTalon rightMotor2;
	
	private RobotDrive driver;
	
	public DriveTrain() {
		super();
		
		leftMotor1 = new CANTalon(RobotMap.leftDriveOne);
		leftMotor2 = new CANTalon(RobotMap.leftDriveTwo);
		
		rightMotor1 = new CANTalon(RobotMap.rightDriveThree);
		rightMotor2 = new CANTalon(RobotMap.rightDriveFour);
		
		leftMotor1.setSafetyEnabled(true);
		leftMotor2.setSafetyEnabled(true);
		rightMotor1.setSafetyEnabled(true);
		rightMotor2.setSafetyEnabled(true);
		
		driver = new RobotDrive(leftMotor1, leftMotor2, rightMotor1, rightMotor2);
		
		LiveWindow.addActuator("Drive Train", "Left Motor1", leftMotor1);
		LiveWindow.addActuator("Drive Train", "Left Motor2", leftMotor2);
		LiveWindow.addActuator("Drive Train", "Right Motor1", rightMotor1);
		LiveWindow.addActuator("Drive Train", "Right Motor2", rightMotor2);
	}
	
	/**
	 * If no commands made (usually none), then default Command is TankDriveTrain.
	 */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new TankDriveTrain());
    }
    
    /**
     * Sets speed for DriveTrain.
     * @param speed - Between -1 & 1.
     */
    public void setSpeed(double leftSpeed, double rightSpeed) {
    	leftMotor1.set(leftSpeed);
    	leftMotor2.set(leftSpeed);
    	rightMotor1.set(rightSpeed);
    	rightMotor2.set(rightSpeed);
    }
    
    public void stop() {
    	leftMotor1.disable();
    	leftMotor2.disable();
    	rightMotor1.disable();
    	rightMotor2.disable();
    }
    
    /**
     * Very sketchy code. Play around with JoyThreshold and Gyro_Kp.
     * @param joy - Operator Controller in OI.
     */
    public void betterDrive(Joystick joy) {
    	double leftYAxis = -(joy.getRawAxis(0));	//Left Y-Axis (Flipped double since it sends a negative value when you go up on the joystick)
    	double rightXAxis = joy.getRawAxis(4);	//Right X-Axis
    	
    	double leftSpeed = 0;
    	double rightSpeed = 0;
    	
    	double currentAngle = Robot.navX.getAngle();
    	double straight = 0;
    	double back = 180;
    	
    	if(Math.abs(leftYAxis) < Robot.joyMinThres)
    		leftYAxis = 0;
    	if(Math.abs(rightXAxis) < Robot.joyMinThres)
			rightXAxis = 0;
    	
    	//If rightThumb X-Axis isn't touched. Will go in a straight line forward or back.
    	if(Robot.orientation == 0) {
    		
    		//Rotating Robot
    		if(leftYAxis == 0 && rightXAxis != 0) {
    			
    			//Linear Jump - Small input = Larger input. Also it'll jump to 100% when it hits a certain value. Example: 10% = 24.2%
    			
    			//Rotate Right
    			if(rightXAxis > 0) {
    				
    				if(rightXAxis <= .95) 
    					rightXAxis = (0.421053 * rightXAxis) + .2;
    				else
    					rightXAxis = 1;
    				
    			}
    			//Rotate Left
    			else {
    				
    				if(rightXAxis >= -.95) 
    					rightXAxis = (0.421053 * rightXAxis) - .2;
    				else
    					rightXAxis = -1;
    			}
    			
    			leftSpeed = rightXAxis;
    			rightSpeed = -rightXAxis;
    		}
    		
    		//Going straight backward or forward
    		else if(leftYAxis != 0 && rightXAxis == 0) {
    			
    			//Is going Right
    			if(currentAngle > back) {
    				
    				double speed = leftYAxis;
    				//Pull to Left
    				speed = 1-(((back-currentAngle)/back) * Robot.gyro_Kp);
    				
    				rightSpeed = speed;
    			}
    			
    			//Is going Left
    			else if(currentAngle < back) {
    				double speed = leftYAxis;
    				//Pull to Right
    				speed = 1+(((currentAngle - back)/back)* Robot.gyro_Kp);
    				
    				leftSpeed = speed;
    			}
    			
    		}
    		
    		//Strafing/Turning while moving.
    		else if(leftYAxis != 0 && rightXAxis != 0) {
    				double speed;
		        	//Turning is reduced in high speed. 
		        	speed = rightXAxis*0.80;
		        	
		        	//Turn right
		        	if (speed > 0) {
		        		//Double check this. Might cause serious jam!
		        		speed = leftYAxis*(1-speed);
		        		rightSpeed = speed;
		        		
		        	//Turn left
		        	} else if (speed < 0) {
		        		speed = leftYAxis*(1+speed);
		        		leftSpeed = speed;
		        	} 
	        	}
    		}
    		
    	//Flipped orientation of robot.
    	else if(Robot.orientation == 1) {
    		
    		//Rotating Robot
    		if(leftYAxis == 0 && rightXAxis != 0) {
    			
    			//Linear Jump - Small input = Larger input. Also it'll jump to 100% when it hits a certain value. Example: 10% = 24.2%
    			
    			//Rotate Right
    			if(rightXAxis > 0) {
    				
    				if(rightXAxis <= .95) 
    					rightXAxis = (0.421053 * rightXAxis) + .2;
    				else
    					rightXAxis = 1;
    				
    			}
    			//Rotate Left
    			else {
    				
    				if(rightXAxis >= -.95) 
    					rightXAxis = (0.421053 * rightXAxis) - .2;
    				else
    					rightXAxis = -1;
    			}
    			
    			leftSpeed = -rightXAxis;
    			rightSpeed = rightXAxis;
    		}
    		
    		//Going straight backward or forward
    		else if(leftYAxis != 0 && rightXAxis == 0) {
    			
    			//Is going Right
    			if(currentAngle > straight) {
    				
    				double speed = leftYAxis;
    				//Pull to Left
    				
    				speed = 1+((currentAngle/360) * Robot.gyro_Kp);
    				rightSpeed = speed;
    			}
    			
    			//Is going Left
    			else if(currentAngle < straight) {
    				double speed = leftYAxis;
    				//Pull to Right
    				
    				speed = 1-((currentAngle/360) * Robot.gyro_Kp);
    				leftSpeed = speed;
    			}
    			
    		}
    		
    		//Strafing/Turning while moving.
    		else if(leftYAxis != 0 && rightXAxis != 0) {
    				double speed;
		        	//Turning is reduced in high speed. 
		        	speed = rightXAxis*0.80;
		        	
		        	//Turn right
		        	if (speed > 0) {
		        		//Double check this. Might cause serious jam!
		        		speed = leftYAxis*(1+speed);
		        		rightSpeed = speed;
		        		
		        	//Turn left
		        	} else if (speed < 0) {
		        		
		        		speed = leftYAxis*(1-speed);
		        		leftSpeed = speed;
		        	} 
	        	}
    	}
    	else 
    		SmartDashboard.putNumber("Robot Orientation Error! ", Robot.orientation);
    	
    	
    	Robot.driveTrain.setSpeed(leftSpeed, rightSpeed);
    }
    
    /**
     * Drive the DriveTrain using ArcadeStyle joysticks.
     * @param joy Driver's gamepad
     */
    public void driveArcadeJoy(Joystick joy) {
    	driver.arcadeDrive(joy);
    }
    
    /**
     * Drive the DriveTrain using TankStyle joystick.
     * @param joy Driver's gamepad
     */
    public void driveTankJoy(Joystick joy) {
    	driver.tankDrive(-(joy.getRawAxis(1)), -(joy.getRawAxis(5)));
    }
    
}

