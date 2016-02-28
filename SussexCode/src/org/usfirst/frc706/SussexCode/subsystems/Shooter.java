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
    private final double P = Constants.Shooter.P_SHOOTER;
    private final double I = Constants.Shooter.I_SHOOTER;
    private final double D = Constants.Shooter.D_SHOOTER;

    public Shooter(){
    	System.out.println("Init PID");
    	shooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    	shooterAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	shooterAngleDrive.reverseOutput(true);
    	shooterAngleDrive.setPID(0.1, 0.00002, .3);
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterStick());
   }

   
}

