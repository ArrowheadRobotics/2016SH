package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ShooterPos extends Command {
	
    public ShooterPos() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.enable();
    	System.out.println("CONTROL ENABLED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.shooter.stopPositionSet)
    	{
    		if(Robot.shooter.hasZeroed) {
    			RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    			RobotMap.shootershooterAngleDrive.set(Robot.shooter.position);
    			RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity() * 0.001);
    		}
    	}
    	//System.out.println("Shooter Pos: " + RobotMap.shootershooterAngleDrive.getEncPosition());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
