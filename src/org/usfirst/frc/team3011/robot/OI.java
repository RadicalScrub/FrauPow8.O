package org.usfirst.frc.team3011.robot;

import org.usfirst.frc.team3011.robot.commands.ArmRotateBack;
import org.usfirst.frc.team3011.robot.commands.ArmRotateForward;
import org.usfirst.frc.team3011.robot.commands.ExtendLift;

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
	private Button buttonTopLeft;
	private Button buttonTopRight;
	private Button buttonMiddleBack;
	private Button buttonMiddleStart;
	private Button buttonMiddleLogi;
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
		
		controllerDrive = new Joystick(0);

		buttonGreenA = new JoystickButton(controllerDrive, 1);
		buttonRedB = new JoystickButton(controllerDrive, 2);
		buttonBlueX = new JoystickButton(controllerDrive, 3);
		buttonYellowY = new JoystickButton(controllerDrive, 4);
		buttonTopLeft = new JoystickButton(controllerDrive, 5);
		buttonTopRight = new JoystickButton(controllerDrive, 6);
		buttonMiddleBack = new JoystickButton(controllerDrive, 7);
		buttonMiddleStart = new JoystickButton(controllerDrive, 8);
		buttonMiddleLogi = new JoystickButton(controllerDrive, 9);
		buttonLeftThumb = new JoystickButton(controllerDrive, 10);
		buttonRightThumb = new JoystickButton(controllerDrive, 11);

		
		//A retract lift
		//B winch
		buttonYellowY.whileHeld(new ExtendLift()); //Y extend lift
		//LT Lock forward/directon
		//RT whileheld boost
		
		//Dpad
		//left 90 degrees left spin
		//right 90 degrees right spin
		//down 108 degree spin
		
		//Joystick drive
		
		
		//controllerDrive #2 the operator controllerDrive 

		controllerOp = new Joystick(1);

		buttonGreenA2 = new JoystickButton(controllerOp, 1);
		buttonRedB2 = new JoystickButton(controllerOp, 2);
		buttonBlueX2 =new JoystickButton(controllerOp, 3);
		buttonYellowY2 = new JoystickButton(controllerOp, 4);
		buttonRB2 = new JoystickButton(controllerOp, 5);
		buttonLB2 = new JoystickButton(controllerOp, 6);
		buttonRT2 = new JoystickButton(controllerOp, 7);
		buttonLT2 = new JoystickButton(controllerOp, 8);
		

		//buttonLT2.whileActive(new ArmRotateBack());   change from trigger to button? figure out trigger?
		//buttonRT2.whileHeld(new ArmRotateForward());  change from trigger to button? figure out trigger?
		//buttonGreenA2.whenReleased(new shoot) includes speeding up shooter and one full arm rotation
		//buttonRedB2.whileActive(new invertShooter) spin shooter inward 
		//buttonBlueX2.whenReleased(new arm full forward)
		//buttonYellowY2.whenReleased(new arm full backwards)
		//Y Arm Full backwards rotation
		//LT Arm up
		//RT Arm down
		//Dpad up raise shooter 
		//dpad down lower shooter
		
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

