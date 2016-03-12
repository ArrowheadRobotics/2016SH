package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
    	
    }

    protected void execute() {

    	if(bothWinch && Robot.oi.wasExtended){
        	Robot.chassis.climb = true;
        	Robot.chassis.climbDrive = true;
    		System.out.println("engage winch");
    		
    		RobotMap.shootershooterAngleDrive.enableBrakeMode(false);
    		RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    		RobotMap.shootershooterAngleDrive.set(0);
    		RobotMap.chassisGearSol.set(Value.kReverse);
    		RobotMap.winchPTO.set(DoubleSolenoid.Value.kReverse);
    	
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
