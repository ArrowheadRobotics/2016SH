package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousDrawBridge extends CommandGroup {
    public AutonomousDrawBridge() {
    	
    	//addSequential(new AutonStartup());
    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(6000,-0.4));
    	
    	addSequential(new GearHigh());
    }
}
