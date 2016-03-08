package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class ExtendHook extends Command {
	boolean open = false;
	boolean both = false;

    public ExtendHook() {
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Timer.delay(0.1);
    	if(Robot.oi.hookButton1.get() && Robot.oi.hookButton2.get()) {
    		both = true;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(both) {
    		System.out.println("extending hook");
    		
    		//locks intake to PID-controlled Vertical
    		Robot.intake.position = Constants.Setpoints.INTAKE_VERTICAL;
    	
    		//Put shooter arm in above hanging bar
    		RobotMap.shootershooterAngleDrive.set(-1300);
    		Timer.delay(1);
    	
    		//extend hook
    		RobotMap.hookSol.set(DoubleSolenoid.Value.kForward);
    		Timer.delay(1);
    	
    		//lower arm slightly onto hanging bar
    		RobotMap.shootershooterAngleDrive.set(-2100);
    		Timer.delay(.5);
    		
    		//retract hook
    		RobotMap.hookSol.set(DoubleSolenoid.Value.kReverse);
    		Timer.delay(.25);
    		
    		RobotMap.shootershooterAngleDrive.set(-1300);
    		Robot.shooter.stopPositionSet = true;
    		//System.out.println("CONTRL MODE : " + RobotMap.shootershooterAngleDrive.getControlMode());
    		
    		Robot.oi.wasExtended = true;
        	System.out.println("wasExtended: " + Robot.oi.wasExtended);
        	both = false;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !both;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
