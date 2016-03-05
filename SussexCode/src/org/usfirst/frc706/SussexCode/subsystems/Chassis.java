package org.usfirst.frc706.SussexCode.subsystems;

import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;
import org.usfirst.frc706.SussexCode.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Chassis extends Subsystem {

    private final CANTalon rightDriveOne = RobotMap.chassisrightDriveOne;
    private final CANTalon rightDriveTwo = RobotMap.chassisrightDriveTwo;
    private final CANTalon leftDriveOne = RobotMap.chassisleftDriveOne;
    private final CANTalon leftDriveTwo = RobotMap.chassisleftDriveTwo;
    
    public Chassis() {
    	RobotMap.chassisGearSol.set(Value.kForward);
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void move(double leftSpeed, double rightSpeed) {
    	leftDriveOne.set(-leftSpeed);
    	leftDriveTwo.set(-leftSpeed);
    	rightDriveOne.set(-rightSpeed);
    	rightDriveTwo.set(-rightSpeed);
    }
    
}

