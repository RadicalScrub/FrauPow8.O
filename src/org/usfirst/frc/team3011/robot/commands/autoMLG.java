package org.usfirst.frc.team3011.robot.commands;

import org.usfirst.frc.team3011.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class autoMLG extends CommandGroup {
    
    public  autoMLG() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
    	
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.

    	requires(Robot.driveTrain);
    	requires(Robot.arm);
    	requires(Robot.shoot);
    	
    	double firstDistance = 4308;	//Use Encoder
    	double intialSpeed = .95;
    	double turnAngle = 40;
    	double secondDistance = 750;	//Use Encoder
    	
    	do {
    		Robot.driveTrain.setSpeed(intialSpeed, intialSpeed);
    	}while(Robot.driveEncoder.get() <= firstDistance);
    	
    	do {
    		
    		Robot.driveTrain.setSpeed(.75, -.75);
    	}while(Robot.navX.getAngle() <= turnAngle);
    	
    	do {
    		Robot.driveTrain.setSpeed(intialSpeed, intialSpeed);
    	}while(Robot.driveEncoder.get() <= secondDistance);
    	
    	//I got lazy.
    	addSequential(new ShooterShoot());
    	
    	
    }
}
