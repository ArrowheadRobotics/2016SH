package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.*;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
    public final CANTalon intakeDrive = RobotMap.intakeintakeDrive;
    public final CANTalon intakeAngleDrive = RobotMap.intakeintakeAngleDrive;

    Timer time = new Timer();
    
	double leftPos = 0;
	double leftStep=0;
	double stoppedLeft = 0;
	
	double sensitivity = 15;

    
    public Intake(){
    	//intakeAngleDrive.changeControlMode(TalonControlMode.Position);
    	//intakeAngleDrive.reverseSensor(false);
    	//intakeAngleDrive.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
    	//intakeAngleDrive.setPID(Constants.Intake.P_INTAKE, Constants.Intake.I_INTAKE, Constants.Intake.D_INTAKE);
    }
    
    public void startTimer() {
    	time.start();
    	time.reset();
    }
    
    public void move(double speed) {
    	leftStep = leftPos;
		
		//Calculates speeds using weighted previous position
		leftPos = (speed + (sensitivity * leftStep))/(sensitivity + 1);
		
		//Calculates new step for next cycle (Left Motor)
		leftStep = leftPos; 
		if(Math.abs((speed)-leftPos)<.5 && (time.get() - stoppedLeft) > .25)  {
			leftStep = speed; 
			stoppedLeft = time.get(); 
		}
		
		RobotMap.intakeintakeAngleDrive.set(leftPos);
    }
    
    public void intakeEnable() {
    	intakeAngleDrive.enable();
    }
    
    public void intakeDisable() {
    	intakeAngleDrive.disable();
    }
    
    public void setIntakePos(double pos){
    	intakeAngleDrive.set(pos);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new IntakeStick());
    }
}

