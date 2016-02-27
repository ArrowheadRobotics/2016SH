package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap; 

public class ShooterStick extends Command {

    public ShooterStick() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    }

    protected void execute() {
    	//if(RobotMap.shooterOneSol.get() == Value.kReverse) {
    		if(Robot.oi.xbox.getRawAxis(5) > 0.1 || Robot.oi.xbox.getRawAxis(5) < -0.1){
    			RobotMap.shootershooterAngleDrive.set(Robot.oi.xbox.getRawAxis(5));
    		}
    		else {
    			RobotMap.shootershooterAngleDrive.set(0);
    		}
    		if(Robot.oi.xbox.getRawAxis(5) < -0.1) {
    			RobotMap.intakeintakeDrive.set(1);
    		}
    		else if(Robot.oi.xbox.getRawAxis(5) > 0.1) {
    			RobotMap.intakeintakeDrive.set(-1);
    		}
    		else {
    			RobotMap.intakeintakeDrive.set(0);
    		}
    	//}
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
