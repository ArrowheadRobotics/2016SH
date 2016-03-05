package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.*;
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
    public boolean hasZeroed;

    public Shooter(){
    	System.out.println("Init Shooter PID");
    	shooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	shooterAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	shooterAngleDrive.reverseOutput(true);
    	shooterAngleDrive.setPID(P, I, D, 0, 0, 12, 0);
    	/*while(shooterAngleDrive.getCloseLoopRampRate()!=1)
    	{
    		shooterAngleDrive.setCloseLoopRampRate(1);
    		System.out.println("attempting to set ramp rate");
    	}*/
    	
    	position = Constants.Setpoints.SHOOTER_TOP;
    	hasZeroed = false;
    }
    
    public void changePos(int target) {
    	position = target;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	//setDefaultCommand(new ShooterStick());
    	
    	setDefaultCommand(new ShooterPos());
    	
   }

   
}

