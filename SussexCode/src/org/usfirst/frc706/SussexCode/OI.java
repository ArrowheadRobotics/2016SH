package org.usfirst.frc706.SussexCode;

import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public boolean wasExtended = false; //Emergency check for extend hook before winch engage
	
	/*
	 *	START DECLARATIONS
	 */
	//Joystick Declarations
	public Joystick leftJoy;
	public Joystick rightJoy;
	public Joystick xbox;
	
	//Xbox Button Declaration
	public JoystickButton a;
	public JoystickButton b;
	public JoystickButton x;
	public JoystickButton y;
	public JoystickButton rb;
	public JoystickButton lb;
	public JoystickButton start;
	
	//Joystick Button Declarations
	public JoystickButton rightTrigger;
	public JoystickButton leftTrigger;
	public JoystickButton hookButton1;
	public JoystickButton hookButton2;
	public JoystickButton winchButton1;
	public JoystickButton winchButton2;
	public JoystickButton enableControl;
	/*
	 *	END DECLARATIONS 
	 */
	
    public OI() {
    	/*
    	 *	START INITIALIZATIONS
    	 */
    	//Joystick Initializations 
    	leftJoy = new Joystick(Constants.Controls.LEFT_JOY_PORT);
    	rightJoy = new Joystick(Constants.Controls.RIGHT_JOY_PORT);
    	xbox = new Joystick(Constants.Controls.XBOX_PORT);
    	
    	//Xbox Button Initializations 
    	a = new JoystickButton(xbox, Constants.Controls.A_BUTT);
    	b = new JoystickButton(xbox, Constants.Controls.B_BUTT);
    	x = new JoystickButton(xbox, Constants.Controls.X_BUTT);
    	y = new JoystickButton(xbox, Constants.Controls.Y_BUTT);
    	lb = new JoystickButton(xbox, Constants.Controls.LB);
    	rb = new JoystickButton(xbox, Constants.Controls.RB);
    	start = new JoystickButton(xbox, Constants.Controls.START);
    	
    	//Joystick Button Initializations 
    	rightTrigger = new JoystickButton(rightJoy, Constants.Controls.RIGHT_JOY_TRIGGER);
    	leftTrigger = new JoystickButton(leftJoy, Constants.Controls.LEFT_JOY_TRIGGER);
    	hookButton1 = new JoystickButton(leftJoy, Constants.Controls.HOOK_BUTTON_ONE);
    	hookButton2 = new JoystickButton(rightJoy, Constants.Controls.HOOK_BUTTON_TWO);
    	winchButton1 = new JoystickButton(leftJoy, Constants.Controls.WINCH_BUTTON_ONE);
    	winchButton2 = new JoystickButton(rightJoy, Constants.Controls.WINCH_BUTTON_TWO);
    	enableControl = new JoystickButton(leftJoy, Constants.Controls.CONTROL_BUTTON);
    	/*
    	 *	END INITIALIZATIONS
    	 */
    	
    	/*
    	 *	START COMMAND CALLS
    	 */
    	start.whenPressed(new Zero()); //Zeroes encoders on shooter and intake arms
    	a.whenPressed(new Setpoints("intake")); //Intake Setpoint
    	b.whenPressed(new Setpoints("hold")); //Hold Setpoint
    	y.whenPressed(new Setpoints("shoot")); //Shoot Setpoint
    	
    	rb.whileHeld(new IntakeDrive(1)); //Driving Intake
    	lb.whileHeld(new IntakeDrive(-1)); //Purging Intake
    	rb.whenReleased(new IntakeStop()); //Stop Intake on release
    	lb.whenReleased(new IntakeStop()); //Stop Intake on release
    	
    	leftTrigger.whenPressed(new GearLow()); //Shift to low gear when held
    	leftTrigger.whenReleased(new GearHigh()); //Reverts to high gear on release
    	
    	rightTrigger.whenPressed(new Shoot()); //Shoots boulder
    	
    	hookButton1.whenPressed(new ExtendHook()); //Extends and retracts hook for climbing
    	winchButton1.whenPressed(new EngageWinch()); //Engages winch
    	
    	enableControl.whenPressed(new Control()); //Enables Control after Climbing
    	/*
    	 *	END COMMAND CALLS
    	 */
    	
    }

    //Returns Speed of Left Joystick
    public double getLeftSpeed() {
    	return Robot.oi.leftJoy.getY();
    }
    //Returns Speed of Right Joystick
    public double getRightSpeed() {
    	return Robot.oi.rightJoy.getY();
    }
    
}

