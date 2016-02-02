package org.usfirst.frc.team3011.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3011.robot.commands.ArmRotateBack;
import org.usfirst.frc.team3011.robot.commands.ArmRotateForward;
import org.usfirst.frc.team3011.robot.commands.DrivingLeft;
//import org.usfirst.frc.team3011.robot.commands.ArmRotateForward;
import org.usfirst.frc.team3011.robot.commands.DrivingRight;
import org.usfirst.frc.team3011.robot.commands.ExampleCommand;
import org.usfirst.frc.team3011.robot.subsystems.Arm;
import org.usfirst.frc.team3011.robot.subsystems.DriveTrainRight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static Joystick controllerDrive = new Joystick(0);
	
	private Button buttonGreenA = new JoystickButton(controllerDrive, 1);
	private Button buttonRedB = new JoystickButton(controllerDrive, 2);
	private Button buttonBlueX = new JoystickButton(controllerDrive, 3);
	private Button buttonYellowY = new JoystickButton(controllerDrive, 4);
	private Button buttonTopLeft = new JoystickButton(controllerDrive, 5);
	private Button buttonTopRight = new JoystickButton(controllerDrive, 6);
	private Button buttonMiddleBack = new JoystickButton(controllerDrive, 7);
	private Button buttonMiddleStart = new JoystickButton(controllerDrive, 8);
	private Button buttonMiddleLogi = new JoystickButton(controllerDrive, 9);
	private Button buttonLeftThumb = new JoystickButton(controllerDrive, 10);
	private Button buttonRightThumb = new JoystickButton(controllerDrive, 11);

	//controllerDrive #2 the operator controllerDrive 
	
	private Joystick controllerOp = new Joystick(1);
	
	private Button buttonGreenA2 = new JoystickButton(controllerOp, 1);
	private Button buttonRedB2 = new JoystickButton(controllerOp, 2);
	private Button buttonBlueX2 =new JoystickButton(controllerOp, 3);
	private Button buttonYellowY2 = new JoystickButton(controllerOp, 4);
	private Button buttonRB2 = new JoystickButton(controllerOp, 5);
	private Button buttonLB2 = new JoystickButton(controllerOp, 6);
	private Button buttonRT2 = new JoystickButton(controllerOp, 7);
	private Button buttonLT2 = new JoystickButton(controllerOp, 8);
	
	
	public OI() {
		buttonGreenA.whileActive(new DrivingRight());
		buttonGreenA2.whileActive(new DrivingLeft());
		
		buttonLT2.whileActive(new ArmRotateBack());
		buttonRT2.whileActive(new ArmRotateForward());
	}
	
	public static Joystick getcontrollerDrive() {
		return controllerDrive;
	}
	
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

