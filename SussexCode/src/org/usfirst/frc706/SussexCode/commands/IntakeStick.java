package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class IntakeStick extends Command {

	
    public IntakeStick() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.intake.startTimer();
    }

    protected void execute() {
    	if(Robot.oi.xbox.getRawAxis(1) > 0.1 || Robot.oi.xbox.getRawAxis(1) < -0.1){
    		Robot.intake.intakeAngleDrive.set((Robot.oi.xbox.getRawAxis(1))*0.6);
    	}
    	else {
    		RobotMap.intakeintakeAngleDrive.set(0);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
