package org.usfirst.frc706.SussexCode;

import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	public Joystick leftJoy;
	public Joystick rightJoy;
	public Joystick xbox;
	
	public JoystickButton a;
	public JoystickButton b;
	public JoystickButton x;
	public JoystickButton y;
	public JoystickButton rb;
	public JoystickButton lb;
	public JoystickButton rightTrigger;
	public JoystickButton leftTrigger;

	public JoystickButton R1;
	public JoystickButton R2;
	public JoystickButton R3;
	
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
    	
    	R1 = new JoystickButton(rightJoy, 4);
    	R2 = new JoystickButton(rightJoy, 3);
    	R3 = new JoystickButton(rightJoy, 5);
    	
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
    	
    	//R1.whileHeld(new Setpoints(1));
    	//R2.whileHeld(new Setpoints(2));
    	//R3.whileHeld(new Setpoints(3));
    	
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Drive", new Drive());
        SmartDashboard.putData("BLANK", new BLANK());
        SmartDashboard.putData("Shoot", new Shoot());

    }

    public double getLeftSpeed() {
    	return Robot.oi.leftJoy.getY();
    }
    
    public double getRightSpeed() {
    	return Robot.oi.rightJoy.getY();
    }
    
}

