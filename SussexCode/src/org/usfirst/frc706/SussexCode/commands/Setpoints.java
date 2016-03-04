package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;

public class Setpoints extends Command {
	
	public int mode;
	
    public Setpoints(int point) {
    	requires(Robot.shooter);
    	mode = point;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//MODE 1 = SHOOT SETPOINT
    	if(mode == 1) {
    		Robot.shooter.changePos(Constants.Setpoints.SHOOTER_TOP);
    		Timer.delay(0.5);	
    	}
    	//MODE 2 = HOLD SETPOINT
    	else if(mode == 2) {
    		Robot.shooter.changePos(Constants.Setpoints.SHOOTER_HOLD);
    		Timer.delay(0.5);
    	}
    	else if(mode == 3) {
    		Robot.shooter.changePos(Constants.Setpoints.SHOOTER_DOWN);
    		Timer.delay(0.5);
    	}
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
