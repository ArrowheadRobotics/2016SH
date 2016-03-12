package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;

public class IntakeDrive extends Command {
	int dir;

    public IntakeDrive(int dir) {
    	this.dir = dir;
    }

    protected void initialize() {
    	Robot.intake.manualIntake = true;
    }

    protected void execute() {
    	Robot.intake.intakeDrive.set(dir * Constants.Speeds.INTAKE_DRIVE_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intake.intakeDrive.set(0);
    }

    protected void interrupted() {
    }
}
