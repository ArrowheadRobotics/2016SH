package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCheval extends CommandGroup {
	private int toCheval = Constants.Autonomous.TO_CHEVAL;
	private int onCheval = Constants.Autonomous.ON_CHEVAL;
	private int overCheval = Constants.Autonomous.OVER_CHEVAL;
	private double chevalSpeed = Constants.Autonomous.CHEVAL_SPEED;
	private double defaultSpeed = Constants.Autonomous.DEFAULT_SPEED;
	
    public AutonomousCheval() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(toCheval, defaultSpeed));
		addSequential(new AutonomousSetpoints("lower","hold"));
		addSequential(new AutonomousDrive(onCheval,chevalSpeed));
		addSequential(new AutonomousSetpoints("vertical","hold"));
		addSequential(new AutonomousDrive(overCheval,defaultSpeed));
    	
    	
    	addSequential(new GearHigh());
    }
}
