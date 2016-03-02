package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class SetShooterPos extends Command {
	
    public SetShooterPos() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.enable();
    	System.out.println("CONTROL ENABLED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.intake.simPos >= 500) {
    		RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    		//RobotMap.shootershooterAngleDrive.set(-975);
    	}
    	else {
    		RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    		//RobotMap.shootershooterAngleDrive.set(-2515);
    	}
    	
    	System.out.println(RobotMap.shootershooterAngleDrive.getEncPosition());
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