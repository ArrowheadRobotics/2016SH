package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;

public class Drive extends Command {

    public Drive() {
    	requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.move(Robot.oi.getLeftSpeed(), Robot.oi.getRightSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
