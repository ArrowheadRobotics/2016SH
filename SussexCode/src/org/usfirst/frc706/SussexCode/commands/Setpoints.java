package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;

public class Setpoints extends Command {
	
	public int mode;
	public int current;
	
    public Setpoints(int point) {
    	requires(Robot.shooter);
    	mode = point;
    	current = point;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("MODE: " + mode);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//MODE 1 = SHOOT SETPOINT
    	if(mode == 1) {
    		Robot.shooter.changePos(Constants.Setpoints.SHOOTER_TOP);
    		Robot.intake.changePos(Constants.Setpoints.INTAKE_LOWER);
    	}
    	//MODE 2 = HOLD SETPOINT
    	
    	else if(mode == 2) {
    		if(current == 3) {
    			Robot.shooterWait = true;
    			Robot.shooter.changePos(Constants.Setpoints.SHOOTER_HOLD);
    			Robot.intake.changePos(Constants.Setpoints.INTAKE_VERTICAL);
    			
    		}
    		else {
    			Robot.shooter.changePos(Constants.Setpoints.SHOOTER_HOLD);
    			Robot.intake.changePos(Constants.Setpoints.INTAKE_VERTICAL);
    		}
    	}
    	//MODE 3 = INTAKE SETPOINT
    	else if(mode == 3) {
    		if(current == 2) {
    			Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
     			Robot.shooter.changePos(Constants.Setpoints.SHOOTER_DOWN);
    		}
    		else {
    			Robot.intakeWait = true;
    			Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    			Robot.shooter.changePos(Constants.Setpoints.SHOOTER_DOWN);
    		}
    		
    	}
    	current = mode;
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
