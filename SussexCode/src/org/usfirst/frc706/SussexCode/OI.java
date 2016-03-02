package org.usfirst.frc706.SussexCode;

import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
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
	public JoystickButton hookButton;
	
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

    	
    	//a.whenPressed(new ZeroShooter());
    	//b.whenPressed(new SetShooterPos());
    	x.whenPressed(new ZeroIntake());
    	//y.whenPressed(new SetIntakePos());
    	a.whenPressed(new setSim(600));
    	b.whenPressed(new setSim(50));
    	
    	hookButton = new JoystickButton(leftJoy, 2);
    	
    	rb.whileHeld(new IntakeDrive(1));
    	lb.whileHeld(new IntakeDrive(-1));
    	rb.whenReleased(new IntakeStop());
    	lb.whenReleased(new IntakeStop());
    	
    	leftTrigger.whenPressed(new GearLow());
    	leftTrigger.whenReleased(new GearHigh());
    	rightTrigger.whenPressed(new Shoot());
    	
    	hookButton.whenPressed(new ExtendHook());
    	
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive", new Drive());
        SmartDashboard.putData("BLANK", new BLANK());
        SmartDashboard.putData("Shoot", new Shoot());

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

