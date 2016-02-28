package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ZeroIntake extends Command {

    public ZeroIntake() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.intakeintakeAngleDrive.enableControl();
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.intakeintakeAngleDrive.set(.4);
    	System.out.println(RobotMap.intakeintakeAngleDrive.getEncPosition());
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
    	RobotMap.intakeintakeAngleDrive.setEncPosition(0);
    	System.out.println("setEnc");
    	//RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    	//RobotMap.intakeintakeAngleDrive.set(0);
    	System.out.println("done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
