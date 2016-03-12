package org.usfirst.frc706.SussexCode.subsystems;

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
	
    public int defense;
	public int robotPosition;
	public int defensePosition;
	public boolean tele = false;
    public boolean climb = false;
    public boolean climbDrive = false;
    public boolean shooting = false;
    
    public Chassis() {
    	RobotMap.chassisGearSol.set(Value.kForward); //Initialize into high gear
    	climb = false;
    	climbDrive = false; 
    }

    public void initDefaultCommand() {
    	setDefaultCommand(new Drive());
    }
    
    //Sets motor speeds
    public void move(double leftSpeed, double rightSpeed) {
   		leftDriveOne.set(leftSpeed);
   		leftDriveTwo.set(leftSpeed);
   		rightDriveOne.set(rightSpeed);
    	rightDriveTwo.set(rightSpeed);
    }
    
    public void move(double speed) {
   		leftDriveOne.set(speed);
    	leftDriveTwo.set(speed);
    	rightDriveOne.set(speed);
    	rightDriveTwo.set(speed);
    }
    
}

