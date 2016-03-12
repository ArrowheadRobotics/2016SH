package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;

public class AutonIntakeDrive extends Command {
	int dir;
	boolean end;

    public AutonIntakeDrive(int dir) {
    	this.dir = dir;
    }

    protected void initialize() {
    	Robot.intake.manualIntake = true;
    }

    protected void execute() {
    	Robot.intake.intakeDrive.set(dir * 0.6);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
