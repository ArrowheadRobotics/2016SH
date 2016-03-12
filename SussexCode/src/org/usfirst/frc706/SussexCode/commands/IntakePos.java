package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
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
    	if(Robot.intake.tele) {
    	if(Robot.oi.xbox.getRawAxis(5) > 0.1 || Robot.oi.xbox.getRawAxis(5) < -0.1)
    	{
    		Robot.intake.stopPositionSet = true;
    	}
    	
    	if(Robot.intake.stopPositionSet )
    	{
    		if(Robot.oi.xbox.getRawAxis(5) > 0.1 || Robot.oi.xbox.getRawAxis(5) < -0.1)
    		{
    			System.out.println("fromLocation " + Robot.intake.shooterArmFromLocation);
    			if(Robot.intake.shooterArmFromLocation.equals("intake") && RobotMap.intakeintakeAngleDrive.getEncPosition() > Constants.Setpoints.INTAKE_HORIZONTAL)
    			{
    				RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    				RobotMap.intakeintakeAngleDrive.set(Robot.oi.xbox.getRawAxis(5) * 0.6);
    			}
    			else if((Robot.intake.shooterArmFromLocation.equals("hold") || Robot.intake.shooterArmFromLocation.equals("shoot")) && RobotMap.intakeintakeAngleDrive.getEncPosition() > Constants.Setpoints.INTAKE_VERTICAL)
    			{
    				RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    				RobotMap.intakeintakeAngleDrive.set(Robot.oi.xbox.getRawAxis(5) * 0.6);
    			}
    			else if(Robot.oi.xbox.getRawAxis(5)>0)
    			{
    				System.out.println("go down");
    				RobotMap.intakeintakeAngleDrive.set(Robot.oi.xbox.getRawAxis(5) * 0.6);
    			}
    			else
    			{
    				RobotMap.intakeintakeAngleDrive.set(0);
    			}
    		}
    		else
    		{
    			RobotMap.intakeintakeAngleDrive.set(0);
    		}
    	}
    	
    	if(!Robot.intake.stopPositionSet)
    	{
    		if(Robot.intake.hasZeroed) {
    			RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    			RobotMap.intakeintakeAngleDrive.set(Robot.intake.position);
    		}
    	}
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
