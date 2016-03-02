package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class SetIntakePos extends Command {
	
    public SetIntakePos() {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.intakeintakeAngleDrive.enable();
    	System.out.println("CONTROL ENABLED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.intake.simPos >= 500) {
    		RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    		RobotMap.intakeintakeAngleDrive.set(-975);
    	}
    	else {
    		RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    		RobotMap.intakeintakeAngleDrive.set(-2515);
    	}
    	
    	System.out.println(RobotMap.intakeintakeAngleDrive.getEncPosition());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}