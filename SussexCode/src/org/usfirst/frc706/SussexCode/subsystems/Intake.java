package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
    public final CANTalon intakeDrive = RobotMap.intakeintakeDrive;
    public final CANTalon intakeAngleDrive = RobotMap.intakeintakeAngleDrive;
    
    public Intake(){
    	System.out.println("Init PID");
    	intakeAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	intakeAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	intakeAngleDrive.reverseOutput(true);
    	intakeAngleDrive.setPID(0.1, 0.00002, .3);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeStick());
    }
}

