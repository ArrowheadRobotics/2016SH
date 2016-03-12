package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousPortcullis extends CommandGroup {
	private int toPortcullis = Constants.Autonomous.TO_PORTCULLIS;
	private int liftPortcullis = Constants.Autonomous.LIFT_PORTCULLIS;
	private int overPortcullis = Constants.Autonomous.OVER_PORTCULLIS;
	private double defaultSpeed = Constants.Autonomous.DEFAULT_SPEED;
	
    public AutonomousPortcullis() {    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	addSequential(new AutonIntakeDrive(-1));
		addSequential(new AutonomousSetpoints("horizontal","down"));
		addSequential(new Delay(0.5));
		addSequential(new IntakeStop());
		addSequential(new AutonomousDrive(toPortcullis,defaultSpeed));
		addSequential(new AutonomousSetpoints("lower","down"));
		addSequential(new AutonomousDrive(liftPortcullis, defaultSpeed));
		addSequential(new AutonomousSetpoints("horizontal","down"));
		addSequential(new AutonomousDrive(overPortcullis, defaultSpeed));
    	
    	addSequential(new GearHigh());
    }
}
