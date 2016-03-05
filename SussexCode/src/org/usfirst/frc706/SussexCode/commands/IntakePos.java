package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class IntakePos extends Command {
	
    public IntakePos() {
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.intakeintakeAngleDrive.enable();
    	System.out.println("CONTROL ENABLED");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.intake.hasZeroed) {
    		RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    		RobotMap.intakeintakeAngleDrive.set(Robot.intake.position);
    	}
    	//System.out.println("Intake Pos: " + RobotMap.intakeintakeAngleDrive.getEncPosition());
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
