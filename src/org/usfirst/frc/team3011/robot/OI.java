package org.usfirst.frc.team3011.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import org.usfirst.frc.team3011.robot.commands.ArmRotateForward;
import org.usfirst.frc.team3011.robot.commands.Driving;
import org.usfirst.frc.team3011.robot.commands.ExampleCommand;
import org.usfirst.frc.team3011.robot.subsystems.DriveTrain;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static Joystick controller = new Joystick(0);
	
	private Button buttonGreenA = new JoystickButton(controller, 1);
	private Button buttonRedB = new JoystickButton(controller, 2);
	private Button buttonBlueX = new JoystickButton(controller, 3);
	private Button buttonYellowY = new JoystickButton(controller, 4);
	private Button buttonTopLeft = new JoystickButton(controller, 5);
	private Button buttonTopRight = new JoystickButton(controller, 6);
	private Button buttonMiddleBack = new JoystickButton(controller, 7);
	private Button buttonMiddleStart = new JoystickButton(controller, 8);
	private Button buttonMiddleLogi = new JoystickButton(controller, 9);
	private Button buttonLeftThumb = new JoystickButton(controller, 10);
	private Button buttonRightThumb = new JoystickButton(controller, 11);
	
	public OI() {
		buttonGreenA.whileActive(new Driving());
		//buttonRedB.whileActive(new ArmRotateForward());
	}
	
	public static Joystick getController() {
		return controller;
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

