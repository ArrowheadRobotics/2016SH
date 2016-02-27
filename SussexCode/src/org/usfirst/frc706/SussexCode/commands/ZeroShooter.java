package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ZeroShooter extends Command {

    public ZeroShooter() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.vBusMode();
    	RobotMap.shootershooterAngleDrive.set(.8);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.shootershooterAngleDrive.set(.8);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.shooter.topLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.zeroEnc();
    	Robot.shooter.posMode();
    	RobotMap.shootershooterAngleDrive.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
