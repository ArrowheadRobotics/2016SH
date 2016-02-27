package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;

public class Drive extends Command {
	double leftSpeed=0;
	double rightSpeed=0;
	double deadZone = .02;
	
    public Drive() {
    	requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.oi.getLeftSpeed()>deadZone||Robot.oi.getLeftSpeed()<-1*deadZone) {
    		leftSpeed=Robot.oi.getLeftSpeed();
    	} else {
    		leftSpeed=0;
    	}
    	if(Robot.oi.getRightSpeed()>deadZone||Robot.oi.getRightSpeed()<-1*deadZone) {
    		rightSpeed=Robot.oi.getRightSpeed();
    	} else {
    		rightSpeed=0;
    	}
    	Robot.chassis.move(Robot.oi.getLeftSpeed(), Robot.oi.getRightSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
