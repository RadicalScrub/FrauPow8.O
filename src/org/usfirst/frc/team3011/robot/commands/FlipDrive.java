package org.usfirst.frc.team3011.robot.commands;

import org.usfirst.frc.team3011.robot.Robot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FlipDrive extends Command {

    public FlipDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	requires(Robot.arm);
    }

 // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.orientation == 0) {
    		Robot.orientation = 1;
    		SmartDashboard.putNumber("direction: ", Robot.orientation);
    		Robot.arm.setSpeed(-1);
        	Timer.delay(.25);
        	Robot.arm.setSpeed(0);
    	} else {
    		Robot.orientation = 0;
    		SmartDashboard.putNumber("direction: ", Robot.orientation);
    		Robot.arm.setSpeed(-1);
        	Timer.delay(.75);
        	Robot.arm.setSpeed(0);
    	}
    	
    	isFinished();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
