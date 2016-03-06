package org.usfirst.frc706.SussexCode;

import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	//emergency check for extend hook before winch engage
	public boolean wasExtended = false;
	
	//Joysticks
	public Joystick leftJoy;
	public Joystick rightJoy;
	public Joystick xbox;
	
	//Xbox Buttons
	public JoystickButton a;
	public JoystickButton b;
	public JoystickButton x;
	public JoystickButton y;
	public JoystickButton rb;
	public JoystickButton lb;
	public JoystickButton start;
	
	//Joystick Buttons
	public JoystickButton rightTrigger;
	public JoystickButton leftTrigger;
	public JoystickButton hookButton1;
	public JoystickButton hookButton2;
	public JoystickButton winchButton1;
	public JoystickButton winchButton2;
	public JoystickButton enableControl;
	
    public OI() {

    	leftJoy = new Joystick(Constants.Controls.LEFT_JOY_PORT);
    	rightJoy = new Joystick(Constants.Controls.RIGHT_JOY_PORT);
    	xbox = new Joystick(Constants.Controls.XBOX_PORT);
    	
    	a = new JoystickButton(xbox, Constants.Controls.A_BUTT);
    	b = new JoystickButton(xbox, Constants.Controls.B_BUTT);
    	x = new JoystickButton(xbox, Constants.Controls.X_BUTT);
    	y = new JoystickButton(xbox, Constants.Controls.Y_BUTT);
    	lb = new JoystickButton(xbox, Constants.Controls.LB);
    	rb = new JoystickButton(xbox, Constants.Controls.RB);
    	rightTrigger = new JoystickButton(rightJoy, Constants.Controls.RIGHT_JOY_TRIGGER);
    	leftTrigger = new JoystickButton(leftJoy, Constants.Controls.LEFT_JOY_TRIGGER);
    	start = new JoystickButton(xbox, Constants.Controls.START);

    	
    	start.whenPressed(new ZeroIntake());
    	start.whenPressed(new ZeroShooter());
    	a.whenPressed(new Setpoints("intake"));
    	b.whenPressed(new Setpoints("hold"));
    	y.whenPressed(new Setpoints("shoot"));
    	
    	hookButton1 = new JoystickButton(leftJoy, 2);
    	hookButton2 = new JoystickButton(rightJoy, 2);
    	winchButton1 = new JoystickButton(leftJoy, 4);
    	winchButton2 = new JoystickButton(rightJoy, 5);
    	
    	enableControl = new JoystickButton(leftJoy, 8);
    	
    	
    	rb.whileHeld(new IntakeDrive(1));
    	lb.whileHeld(new IntakeDrive(-1));
    	rb.whenReleased(new IntakeStop());
    	lb.whenReleased(new IntakeStop());
    	
    	leftTrigger.whenPressed(new GearLow());
    	leftTrigger.whenReleased(new GearHigh());
    	rightTrigger.whenPressed(new Shoot());
    	
    	hookButton1.whenPressed(new ExtendHook());
    	
    	enableControl.whenPressed(new Control());
    	
    	winchButton1.whenPressed(new EngageWinch());
    	
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive", new Drive());
        SmartDashboard.putData("BLANK", new BLANK());
        SmartDashboard.putData("Shoot", new Shoot());

    }

    //Returns Speed of Left Joystick
    public double getLeftSpeed() {
    	return 1*Robot.oi.leftJoy.getY();
    }
    //Returns Speed of Right Joystick
    public double getRightSpeed() {
    	return 1*Robot.oi.rightJoy.getY();
    }
    
}

