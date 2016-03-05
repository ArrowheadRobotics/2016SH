package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ZeroIntake extends Command {

    public ZeroIntake() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.intake.hasZeroed = false;
    	RobotMap.intakeintakeAngleDrive.enableControl();
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.intakeintakeAngleDrive.set(.4);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.intakeintakeAngleDrive.set(.4);
    	System.out.println("Down");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return RobotMap.intakeintakeAngleDrive.isFwdLimitSwitchClosed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("end");
    	RobotMap.intakeintakeAngleDrive.set(0);
    	System.out.println("set");
    	RobotMap.intakeintakeAngleDrive.setPosition(0);
    	System.out.println("setEnc" + RobotMap.intakeintakeAngleDrive.getEncPosition());
    	
    	System.out.println("done");
    	new Setpoints(1);
    	Robot.intake.hasZeroed = true;
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
