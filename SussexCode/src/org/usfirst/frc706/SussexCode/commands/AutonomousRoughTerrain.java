package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRoughTerrain extends CommandGroup {
	private int overTerrain = Constants.Autonomous.TERRAIN_DISTANCE;
	private double defaultSpeed = Constants.Autonomous.DEFAULT_SPEED;
	
    public AutonomousRoughTerrain() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(overTerrain,defaultSpeed));
    	
    	addSequential(new GearHigh());
    }
}
