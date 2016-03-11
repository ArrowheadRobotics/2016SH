package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.IntakePos;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
    public final CANTalon intakeDrive = RobotMap.intakeintakeDrive;
    public final CANTalon intakeAngleDrive = RobotMap.intakeintakeAngleDrive;
    
    public final double P = Constants.PID.P_INTAKE;
    public final double I = Constants.PID.I_INTAKE;
    public final double D = Constants.PID.D_INTAKE;
    
	public int position;
	public boolean hasZeroed;
	public boolean stopPositionSet = false;
	public String shooterArmFromLocation = "";


    public Intake(){
    	//DO NOT REVERSE OUTPUT
    	System.out.println("Init Intake PID");
    	intakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	intakeAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	intakeAngleDrive.setPID(P, I, D);
    	
    	position = Constants.Setpoints.INTAKE_LOWER; //Sets the initial state of the intake (post-zeroing)
    	hasZeroed = false; //Initially hasn't zeroed
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakePos());
    }

    //Changes the target position of the arm
	public void changePos(int pos) {
		position = pos;
		intakeAngleDrive.changeControlMode(TalonControlMode.Position);
		intakeAngleDrive.set(Robot.intake.position);
	}
}

