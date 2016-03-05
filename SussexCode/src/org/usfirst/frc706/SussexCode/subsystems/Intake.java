package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	public int position;
	public boolean hasZeroed;
    public final CANTalon intakeDrive = RobotMap.intakeintakeDrive;
    public final CANTalon intakeAngleDrive = RobotMap.intakeintakeAngleDrive;
    public final double P = Constants.PID.P_INTAKE;
    public final double I = Constants.PID.I_INTAKE;
    public final double D = Constants.PID.D_INTAKE;
    
    public Intake(){
    	//DO NOT REVERSE OUTPUT
    	System.out.println("Init PID");
    	intakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	intakeAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	intakeAngleDrive.setPID(P, I, D);
    	position = Constants.Setpoints.INTAKE_LOWER;
    	hasZeroed = false;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new IntakeStick());
    	setDefaultCommand(new IntakePos());
    }

	public void changePos(int pos) {
		position = pos;
	}
}

