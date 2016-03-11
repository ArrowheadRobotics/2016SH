package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.IntakeLiftDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    public final CANTalon shooterAngleDrive = RobotMap.shootershooterAngleDrive;
    public final DoubleSolenoid shooterTriggerSol = RobotMap.shooterTriggerSol;
    
    private final double P = Constants.PID.P_SHOOTER;
    private final double I = Constants.PID.I_SHOOTER;
    private final double D = Constants.PID.D_SHOOTER;
    
    public int position;
    public boolean stopPositionSet = false;
    public boolean hasZeroed;

    public Shooter(){
    	System.out.println("Init Shooter PID");
    	shooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	shooterAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	shooterAngleDrive.reverseOutput(true);
    	shooterAngleDrive.setP(P);
    	shooterAngleDrive.setI(I);
    	shooterAngleDrive.setD(D);

    	position = Constants.Setpoints.SHOOTER_TOP; //Sets the initial state of arm (post-zeroing)
    	hasZeroed = false; //Initially hasn't zeroed
    }
    
    public void initDefaultCommand() {    	
    	setDefaultCommand(new IntakeLiftDrive());
    }
    
    //Changes the target position of the shooter arm
    public void changePos(int target) {
    	position = target;
    	RobotMap.shootershooterAngleDrive.changeControlMode(TalonControlMode.Position);
		RobotMap.shootershooterAngleDrive.set(Robot.shooter.position);
		
		
    }
}

