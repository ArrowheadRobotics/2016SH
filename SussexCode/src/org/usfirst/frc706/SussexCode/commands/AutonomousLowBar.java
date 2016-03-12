package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLowBar extends CommandGroup {
	private int underBar = Constants.Autonomous.LOWBAR_DISTANCE;
	private double defaultSpeed = Constants.Autonomous.DEFAULT_SPEED;
	
    public AutonomousLowBar() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonIntakeDrive(-1));
		addSequential(new AutonomousSetpoints("horizontal","down"));
		addSequential(new Delay(0.5));
		addSequential(new IntakeStop());
		addSequential(new AutonomousDrive(underBar,defaultSpeed));
    	
    	addSequential(new GearHigh());
    }
}
