package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ZeroShooter extends Command {

    public ZeroShooter() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.enableControl();
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.shootershooterAngleDrive.set(.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.shootershooterAngleDrive.set(.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.shootershooterAngleDrive.isRevLimitSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.shootershooterAngleDrive.setPosition(0);
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	RobotMap.shootershooterAngleDrive.set(0);
    	//RobotMap.shootershooterAngleDrive.disableControl();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
