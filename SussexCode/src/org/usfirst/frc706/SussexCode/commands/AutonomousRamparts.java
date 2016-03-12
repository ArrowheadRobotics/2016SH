package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRamparts extends CommandGroup {
	private int overRamparts = Constants.Autonomous.RAMPART_DISTANCE;
	private double rampartSpeed = Constants.Autonomous.RAMPART_SPEED;
	
    public AutonomousRamparts() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(overRamparts, rampartSpeed));
    	
    	addSequential(new GearHigh());
    }
}
