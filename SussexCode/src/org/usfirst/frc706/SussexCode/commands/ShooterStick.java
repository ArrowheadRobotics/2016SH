package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap; 

public class ShooterStick extends Command {

	public double pos;
	
    public ShooterStick() {
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.enableControl();
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	pos = RobotMap.shootershooterAngleDrive.getEncPosition();
    }

    protected void execute() {

    		if(Robot.oi.xbox.getRawAxis(5) > 0.1 || Robot.oi.xbox.getRawAxis(5) < -0.1){
    			//RobotMap.shootershooterAngleDrive.set(Robot.oi.xbox.getRawAxis(5));
    			RobotMap.shootershooterAngleDrive.set(pos);
    		}
    		if(Robot.oi.xbox.getRawAxis(5) < -0.1) {
    			pos++;
    		}
    		else if(Robot.oi.xbox.getRawAxis(5) > 0.1) {
    			pos--;
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
