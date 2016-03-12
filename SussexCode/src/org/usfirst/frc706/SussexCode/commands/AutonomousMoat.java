package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMoat extends CommandGroup {
	private int overMoat = Constants.Autonomous.MOAT_DISTANCE;
	private double moatSpeed = Constants.Autonomous.MOAT_SPEED;
	
    public AutonomousMoat() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(overMoat,moatSpeed));
    	
    	addSequential(new GearHigh());
    }
}
