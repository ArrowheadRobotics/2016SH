package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ZeroShooter extends Command {

    public ZeroShooter() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shootershooterAngleDrive.enableControl();
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.shootershooterAngleDrive.set(.2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.shootershooterAngleDrive.set(.2);
    	System.out.println("Down");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.shootershooterAngleDrive.isFwdLimitSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end");
    	RobotMap.shootershooterAngleDrive.set(0);
    	System.out.println("set");
    	RobotMap.shootershooterAngleDrive.setEncPosition(0);
    	System.out.println("setEnc");
    	//RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	//RobotMap.shootershooterAngleDrive.set(0);
    	System.out.println("done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
