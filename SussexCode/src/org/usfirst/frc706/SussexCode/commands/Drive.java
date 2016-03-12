package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;

public class Drive extends Command {
	double leftSpeed = 0;
	double rightSpeed = 0;
	double speed = 0;
	double deadZone = Constants.Deadzones.DRIVE_DEADZONE;
	
    public Drive() {
    	requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.chassis.tele) {
    	if(Robot.chassis.climbDrive) {
    		if(Robot.oi.getLeftSpeed() > deadZone || Robot.oi.getLeftSpeed() < -1 * deadZone) {
    			if(Robot.oi.getRightSpeed() > deadZone || Robot.oi.getRightSpeed() < -1 * deadZone) {
    				if((Robot.oi.getLeftSpeed() + Robot.oi.getRightSpeed())/2 < 0) {
    					speed = (Robot.oi.getLeftSpeed() + Robot.oi.getRightSpeed())/2;
    				}
    			}
    		}
    		else {
    			speed = 0;
    		}
    		Robot.chassis.move(speed);
    	}
    	else {
    		if(!Robot.chassis.shooting) {
    			if(!Robot.chassis.climb) {
    				if(Robot.oi.getLeftSpeed() > deadZone || Robot.oi.getLeftSpeed() < -1 * deadZone) {
    					leftSpeed = Robot.oi.getLeftSpeed();
    				} else {
    					leftSpeed = 0;
    				}
    				if(Robot.oi.getRightSpeed() > deadZone || Robot.oi.getRightSpeed() < -1 * deadZone) {
    					rightSpeed = Robot.oi.getRightSpeed();
    				} else {
    					rightSpeed = 0;
    				}
    			Robot.chassis.move(Robot.oi.getLeftSpeed(), Robot.oi.getRightSpeed());
    			}
    		}
    		else {
    			Robot.chassis.move(0, 0);
    		}
    	}
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
