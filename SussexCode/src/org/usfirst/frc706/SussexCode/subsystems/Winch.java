package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DoubleSolenoid PTO = RobotMap.winchPTO;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void engageWinch(){
    	Robot.winch.PTO.set(DoubleSolenoid.Value.kForward);
    }
}

