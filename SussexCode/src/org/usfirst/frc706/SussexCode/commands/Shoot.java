package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class Shoot extends Command {

    public Shoot() {
    	requires(Robot.shooter);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.shooterTriggerSol.set(Value.kForward);
    	Timer.delay(0.5);
    	RobotMap.shooterOneSol.set(Value.kReverse);
    	RobotMap.shooterTwoSol.set(Value.kReverse);
    	Timer.delay(0.5);
    	RobotMap.shooterTriggerSol.set(Value.kReverse);
    	Timer.delay(0.25);
    	RobotMap.shooterOneSol.set(Value.kForward);
    	RobotMap.shooterTwoSol.set(Value.kForward);
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
