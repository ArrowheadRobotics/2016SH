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
    	initShooterPID();
    }
    
    public void initShooterPID() {
    	shooterAngleDrive.changeControlMode(TalonControlMode.Position);
    	shooterAngleDrive.reverseSensor(false);
    	shooterAngleDrive.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	shooterAngleDrive.setPID(P, I, D);
    }
    
    public void shooterEnable() {
    	shooterAngleDrive.enable();
    }
    
    public void shooterDisable() {
    	shooterAngleDrive.disable();
    }
    
    public void setShooterPos(double pos){
    	shooterAngleDrive.set(pos);
    }
    
    public void zeroEnc() {
    	shooterAngleDrive.setPosition(0);
    }
    
    public boolean topLimit() {
    	return shooterAngleDrive.isRevLimitSwitchClosed();
    }
    
    public void posMode() {
    	shooterAngleDrive.changeControlMode(TalonControlMode.Position);
    }
    
    public void vBusMode() {
    	shooterAngleDrive.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ShooterStick());
   }

   
}

