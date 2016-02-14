package org.usfirst.frc.team3011.robot;


import org.usfirst.frc.team3011.robot.commands.ArmBack;
import org.usfirst.frc.team3011.robot.commands.ArmForward;
import org.usfirst.frc.team3011.robot.commands.LiftExtend;
import org.usfirst.frc.team3011.robot.commands.ShooterInverseSpin;
import org.usfirst.frc.team3011.robot.commands.LiftRetract;
import org.usfirst.frc.team3011.robot.commands.ShiftDown;
import org.usfirst.frc.team3011.robot.commands.ShiftUp;
import org.usfirst.frc.team3011.robot.commands.ShooterShoot;
import org.usfirst.frc.team3011.robot.commands.WinchDown;
import org.usfirst.frc.team3011.robot.commands.WinchUp;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick controllerDrive;
	
	private Button buttonGreenA;
	private Button buttonRedB;
	private Button buttonBlueX;
	private Button buttonYellowY;
	private Button buttonLB;
	private Button buttonRB;
	//private Button buttonMiddleBack;
	//private Button buttonMiddleStart;
	//private Button buttonMiddleLogi;
	private Button buttonLeftThumb;
	private Button buttonRightThumb;

	//controllerDrive #2 the operator controllerDrive 
	
	public static Joystick controllerOp;
	
	private Button buttonGreenA2;
	private Button buttonRedB2;
	private Button buttonBlueX2;
	private Button buttonYellowY2;
	private Button buttonRB2;
	private Button buttonLB2;
	private Button buttonRT2;
	private Button buttonLT2;
	
	
	public OI() {
		
		controllerDrive = new Joystick(0);							//Driver 1

		buttonGreenA = new JoystickButton(controllerDrive, 1);		//A
		buttonRedB = new JoystickButton(controllerDrive, 2);		//B
		buttonBlueX = new JoystickButton(controllerDrive, 3);		//X
		buttonYellowY = new JoystickButton(controllerDrive, 4);		//Y
		buttonLB = new JoystickButton(controllerDrive, 5);			//LB
		buttonRB = new JoystickButton(controllerDrive, 6);			//RB
		//buttonMiddleBack = new JoystickButton(controllerDrive, 7);
		//buttonMiddleStart = new JoystickButton(controllerDrive, 8);
		//buttonMiddleLogi = new JoystickButton(controllerDrive, 9);
		buttonLeftThumb = new JoystickButton(controllerDrive, 10);	//Left stick
		buttonRightThumb = new JoystickButton(controllerDrive, 11);	//Right stick

		
		buttonGreenA.whileHeld(new LiftRetract());     				//retracts the hook lift
		buttonBlueX.whileHeld(new LiftExtend());	   				//extends the hook lift
		buttonRedB.whileHeld(new WinchUp());		   				//pulls up the robot
		buttonYellowY.whileHeld(new WinchDown());	   				//lowers the robot
		buttonRB.whenPressed(new ShiftUp());						//triggers boost
		buttonRB.whenReleased(new ShiftDown());						//ends boost
		
		//Dpad
		//left 90 degrees left spin
		//right 90 degrees right spin
		//down 108 degree spin
		
		//controllerDrive #2 the operator controllerDrive 

		controllerOp = new Joystick(1);								//Driver 2

		buttonGreenA2 = new JoystickButton(controllerOp, 1);		//A
		buttonRedB2 = new JoystickButton(controllerOp, 2);			//B
		buttonBlueX2 =new JoystickButton(controllerOp, 3);			//X
		buttonYellowY2 = new JoystickButton(controllerOp, 4);		//Y
		buttonRB2 = new JoystickButton(controllerOp, 5);			//RB
		buttonLB2 = new JoystickButton(controllerOp, 6);			//LR
		buttonRT2 = new JoystickButton(controllerOp, 7);			//RT
		buttonLT2 = new JoystickButton(controllerOp, 8);			//LT
		
		buttonGreenA2.whenPressed(new ShooterShoot());				// includes speeding up shooter and one full arm rotation
		buttonRedB2.whileActive(new ShooterInverseSpin());			// spin shooter inward to free of jams
		//buttonBlueX2.whenReleased(new arm full forward)
		//buttonYellowY2.whenReleased(new arm full backwards)
		buttonLT2.whileHeld(new ArmForward());						//Manual arm control forward
		buttonRT2.whileHeld(new ArmBack());							//Manual Arm control back		
	}
	
	//talons on wheels and limit switches
	//	lifts and drive train
	//victors on everything else
		//shooter
	
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

