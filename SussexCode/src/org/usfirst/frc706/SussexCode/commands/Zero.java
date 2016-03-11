package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class Zero extends Command {

	public static boolean doneZeroing = false;
	private double zeroSpeed = Constants.Speeds.ZERO_SPEED;
	private long startTime;
	
    public Zero() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.hasZeroed = false;
    	RobotMap.intakeintakeAngleDrive.enableControl();
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.intakeintakeAngleDrive.set(zeroSpeed);
    	
    	Robot.shooter.hasZeroed = false;
    	RobotMap.shootershooterAngleDrive.enableControl();
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.shootershooterAngleDrive.set(-1 * zeroSpeed);
    	
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.intakeintakeAngleDrive.set(zeroSpeed);
    	RobotMap.shootershooterAngleDrive.set(-1 * zeroSpeed);
    	
    	if(RobotMap.intakeintakeAngleDrive.isFwdLimitSwitchClosed() && RobotMap.shootershooterAngleDrive.isRevLimitSwitchClosed()) {
    		doneZeroing = true;
    	}
    	if(System.currentTimeMillis() > startTime + 2500) {
    		doneZeroing = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneZeroing;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.intakeintakeAngleDrive.set(0);
    	RobotMap.intakeintakeAngleDrive.setPosition(0);
    	System.out.println("set Intake Enc" + RobotMap.intakeintakeAngleDrive.getEncPosition());
    	
    	RobotMap.shootershooterAngleDrive.set(0);
    	RobotMap.shootershooterAngleDrive.setPosition(0);
    	System.out.println("set Shooter Enc" + RobotMap.shootershooterAngleDrive.getEncPosition()); 
    	
    	Robot.shooter.hasZeroed = true;
    	Robot.intake.hasZeroed = true;
    	
    	doneZeroing = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
