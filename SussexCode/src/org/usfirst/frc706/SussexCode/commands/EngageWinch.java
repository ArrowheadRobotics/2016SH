package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class EngageWinch extends Command {

    public EngageWinch() {

    }

    protected void initialize() {
    	Robot.winch.engageWinch();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
