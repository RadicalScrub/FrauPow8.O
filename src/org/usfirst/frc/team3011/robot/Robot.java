
package org.usfirst.frc.team3011.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3011.robot.commands.autoMLG;
import org.usfirst.frc.team3011.robot.subsystems.Arm;
import org.usfirst.frc.team3011.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3011.robot.subsystems.Lift;
import org.usfirst.frc.team3011.robot.subsystems.Shooter;
import org.usfirst.frc.team3011.robot.subsystems.SuperShift;
import org.usfirst.frc.team3011.robot.subsystems.Winch;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static OI oi;
	public static Arm arm; 
	public static DriveTrain driveTrain;
	public static Lift lift;
    public static Shooter shoot;
	public static Winch winch;
	public static SuperShift shifter;
	
	/**
	 * This is the gyro's proportional constant or loop gain, decreasing this number 
    will cause the robot to correct more quickly. The problem comes in when the number 
    is to low, the robot will oscillate. 0 to 1 are the possible values for this.
	 */
	public static double gyro_Kp;
	public static AHRS navX;
	
	public static Encoder driveEncoder;
	
	//this is the minimum threshold for the joysticks
    public static double joyMinThres;
    
    public static int orientation;
    
    Command autonomousMLG;
    SendableChooser chooser;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        chooser = new SendableChooser();
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        
        arm = new Arm();
        lift = new Lift();
        shoot = new Shooter();
        winch = new Winch();
        driveTrain = new DriveTrain();
        shifter = new SuperShift();
        
        navX = new AHRS(SPI.Port.kMXP);
        navX.reset();
        
        //Play with this value. 
        gyro_Kp = 1;
        
        driveEncoder = new Encoder(RobotMap.encoderA1,RobotMap.encoderA2);
        Robot.driveEncoder.reset();
        
        joyMinThres = 0.1;
        
        orientation = 0;
        
        SmartDashboard.putData(arm);
        SmartDashboard.putData(lift);
        SmartDashboard.putData(shoot);
        SmartDashboard.putData(winch);
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(shifter);
        
        CameraServer server = CameraServer.getInstance();
        server.setQuality(25);
        server.startAutomaticCapture("cam0");
        
        autonomousMLG = new autoMLG();
        
        oi = new OI();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        //autonomousCommand = (Command) chooser.getSelected();
        //autonomousCommand = (ShooterSpin) chooser.getSelected();
    	
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        
        if (autonomousMLG != null) autonomousMLG.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousMLG != null) autonomousMLG.cancel();
        
        Robot.driveEncoder.reset();
        SmartDashboard.putNumber("encoder: ", Robot.driveEncoder.get());
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
