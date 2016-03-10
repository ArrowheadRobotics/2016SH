package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class AutoSetPos extends Command {
	int intakePosition;
	int shooterPosition;
	
    public AutoSetPos(int intakePos, int shooterPos) {
    	intakePosition = intakePos;
    	shooterPosition = shooterPos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	RobotMap.shootershooterAngleDrive.set(shooterPosition);
    	
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    	RobotMap.intakeintakeAngleDrive.set(intakePosition);
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
