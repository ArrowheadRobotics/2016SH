package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class EngageWinch extends Command {
	public boolean bothWinch = false;

    public EngageWinch() {
    }

    protected void initialize() {
    	Timer.delay(0.1);
    	if(Robot.oi.winchButton1.get() && Robot.oi.winchButton2.get()) {
    		bothWinch = true;
    	}
    	Robot.chassis.climb = true;
    	Robot.chassis.climbDrive = true;
    }

    protected void execute() {
    	if(bothWinch && Robot.oi.wasExtended){
    		System.out.println("engage winch");
    		
    		RobotMap.shootershooterAngleDrive.enableBrakeMode(false);
    		RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    		RobotMap.shootershooterAngleDrive.set(0);
    		
    		RobotMap.winchPTO.set(DoubleSolenoid.Value.kReverse);
    		Timer.delay(0.5);
    		Robot.chassis.move(-0.8, -0.8);
    		Timer.delay(2.5);
    		Robot.chassis.move(0, 0);
    		RobotMap.winchPTO.set(DoubleSolenoid.Value.kForward);
    		 
    		bothWinch = false;
    	}
    }

    protected boolean isFinished() {
        return !bothWinch;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
