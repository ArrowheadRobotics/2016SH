package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;

public class Setpoints extends Command {

	private int setpoint;
	private double intakePos;
	private double shooterPos;
	
    public Setpoints(int point) {
    	requires(Robot.intake);
    	requires(Robot.shooter);
    	
    	this.setpoint = point;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.intakeEnable();
		Robot.shooter.shooterEnable();
    	if(setpoint == 1) {
    		intakePos = Constants.Setpoints.POINT_ONE_INTAKE;
    		shooterPos = Constants.Setpoints.POINT_ONE_SHOOTER;
    	}
    	else if(setpoint == 2) {
    		intakePos = Constants.Setpoints.POINT_TWO_INTAKE;
    		shooterPos = Constants.Setpoints.POINT_TWO_SHOOTER;
    	}
    	else {
    		intakePos = Constants.Setpoints.POINT_THREE_INTAKE;
    		shooterPos = Constants.Setpoints.POINT_THREE_SHOOTER;
    	}
    	Robot.intake.setIntakePos(intakePos);
    	Robot.shooter.setShooterPos(shooterPos);
    }

    protected boolean isFinished() {
    	if(Robot.intake.intakeAngleDrive.get() < intakePos + 10 && Robot.intake.intakeAngleDrive.get() > intakePos-10) {
    		if(Robot.shooter.shooterAngleDrive.get() < shooterPos + 10 && Robot.shooter.shooterAngleDrive.get() > shooterPos-10) {
        		return true;
        	}
    		else {
    			return false;
    		}
    	}
    	else {
    		return false;
    	}
    }

    protected void end() {
    	Robot.intake.intakeDisable();
		Robot.shooter.shooterDisable();
    }

    protected void interrupted() {
    	Robot.intake.intakeDisable();
		Robot.shooter.shooterDisable();
    }
}
