package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ShooterStick extends Command {

	
    public ShooterStick() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.oi.xbox.getRawAxis(5) > 0.1 || Robot.oi.xbox.getRawAxis(5) < -0.1){
    		Robot.shooter.shooterAngleDrive.set((Robot.oi.xbox.getRawAxis(5))*0.6);
    	}
    	else {
    		RobotMap.shootershooterAngleDrive.set(0);
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
