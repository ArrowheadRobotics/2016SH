// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

/**
 *
 */
public class AutonomousSetpoints extends Command {
	
	String intakePos;
	String shooterPos;
	boolean done = false;
	
    public AutonomousSetpoints(String intake, String shooter) {
    	intakePos = intake;
    	shooterPos = shooter;
    }

    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    }

    protected void execute() {
    	switch(shooterPos){
    	case "top":
    		RobotMap.shootershooterAngleDrive.set(Constants.Setpoints.SHOOTER_TOP);
    		RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity());
    		break;
    	case "hold":
    		RobotMap.shootershooterAngleDrive.set(Constants.Setpoints.SHOOTER_HOLD);
    		RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity());
    		break;
    	case "down":
    		RobotMap.shootershooterAngleDrive.set(Constants.Setpoints.SHOOTER_DOWN);
    		RobotMap.intakeintakeDrive.set(RobotMap.shootershooterAngleDrive.getEncVelocity());
    		break;
    	}
    	
    	switch(intakePos){
    	case "vertical":
    		Timer.delay(2);
    		RobotMap.intakeintakeAngleDrive.set(Constants.Setpoints.INTAKE_VERTICAL);
    		break;
    	case "horizontal":
    		RobotMap.intakeintakeAngleDrive.set(Constants.Setpoints.INTAKE_HORIZONTAL);
    		break;
    	case "lower":
    		RobotMap.intakeintakeAngleDrive.set(Constants.Setpoints.INTAKE_LOWER);
    		break;
    	}
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

