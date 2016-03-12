package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRockWall extends CommandGroup {
	private int overRockwall = Constants.Autonomous.ROCKWALL_DISTANCE;
	private double rockwallSpeed = Constants.Autonomous.ROCKWALL_SPEED;
	
    public AutonomousRockWall() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(overRockwall,rockwallSpeed));
    	
    	addSequential(new GearHigh());
    }
}
