package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class Control extends Command {
	
    public Control() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.enable();
    	RobotMap.shootershooterAngleDrive.enableBrakeMode(true);
    	Robot.shooter.stopPositionSet = false;
    	RobotMap.winchPTO.set(DoubleSolenoid.Value.kForward);
    	Robot.chassis.climb = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
