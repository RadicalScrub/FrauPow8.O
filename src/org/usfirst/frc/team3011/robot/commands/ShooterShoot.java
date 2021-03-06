package org.usfirst.frc.team3011.robot.commands;

import org.usfirst.frc.team3011.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShooterShoot extends CommandGroup {
    
    public  ShooterShoot() {
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
    	
    	requires(Robot.shoot);
    	requires(Robot.arm);
    	
    	addSequential(new ArmKickInside());
    	addParallel(new ShooterSpinDown(), .5);
    	
    	addSequential(new StopShoot());
    	addParallel(new StopArm(), .5);
    	
    	addSequential(new ShooterSpinUp(), 1.5);
    	
    	addSequential(new ArmHome(), 1);
    	
    	addSequential(new StopShoot());
    	
    }
}
