package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NewAutonomous extends CommandGroup {
	
	
	private int toPortcullis = Constants.Autonomous.TO_PORTCULLIS;
	private int liftPortcullis = Constants.Autonomous.LIFT_PORTCULLIS;
	private int overPortcullis = Constants.Autonomous.OVER_PORTCULLIS;
	private double defaultSpeed = Constants.Autonomous.DEFAULT_SPEED;
	private int toCheval = Constants.Autonomous.TO_CHEVAL;
	private int onCheval = Constants.Autonomous.ON_CHEVAL;
	private int overCheval = Constants.Autonomous.OVER_CHEVAL;
	private double chevalSpeed = Constants.Autonomous.CHEVAL_SPEED;
	private int overMoat = Constants.Autonomous.MOAT_DISTANCE;
	private double moatSpeed = Constants.Autonomous.MOAT_SPEED;
	private int overRamparts = Constants.Autonomous.RAMPART_DISTANCE;
	private double rampartSpeed = Constants.Autonomous.RAMPART_SPEED;
	private int overRockwall = Constants.Autonomous.ROCKWALL_DISTANCE;
	private double rockwallSpeed = Constants.Autonomous.ROCKWALL_SPEED;
	private int overTerrain = Constants.Autonomous.TERRAIN_DISTANCE;
	private int underBar = Constants.Autonomous.LOWBAR_DISTANCE;
	private int newDefense = 1;

    public NewAutonomous() {
    	
    	//addSequential(new AutonStartup());
    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	System.out.println("New Defense:" + newDefense);
    	switch(newDefense){
		case 0: //Crosses portcullis
			System.out.println("portcullis");
			addSequential(new AutonIntakeDrive(-1));
			addSequential(new AutonomousSetpoints("horizontal","down"));
			addSequential(new Delay(0.5));
			addSequential(new IntakeStop());
			addSequential(new AutonomousDrive(toPortcullis,defaultSpeed));
			addSequential(new AutonomousSetpoints("lower","down"));
    		addSequential(new AutonomousDrive(liftPortcullis, defaultSpeed));
    		addSequential(new AutonomousSetpoints("horizontal","down"));
			addSequential(new AutonomousDrive(overPortcullis, defaultSpeed));
			break;
		case 1: //Crosses the french fries
			System.out.println("fries");
			addSequential(new AutonomousSetpoints("vertical","hold"));
    		addSequential(new AutonomousDrive(toCheval, defaultSpeed));
			addSequential(new AutonomousSetpoints("lower","hold"));
			addSequential(new AutonomousDrive(onCheval,chevalSpeed));
			addSequential(new AutonomousSetpoints("vertical","hold"));
			addSequential(new AutonomousDrive(overCheval,defaultSpeed));
			break;
		case 2: //Crosses the moat
			System.out.println("moat");
			addSequential(new AutonomousSetpoints("vertical","hold"));
    		addSequential(new AutonomousDrive(overMoat,moatSpeed));
    		break;
		case 3: //Crosses the ramparts
			System.out.println("ramparts");
			addSequential(new AutonomousSetpoints("vertical","hold"));
    		addSequential(new AutonomousDrive(overRamparts,rampartSpeed));
    		break;
		case 4: //Crosses sally port
			System.out.println("not doing anything");
			Robot.chassis.move(0, 0);
			break;
		case 5: //Crosses draw bridge
			System.out.println("not doing anything");
			Robot.chassis.move(0, 0);
			break;
		case 6: //Crosses the rock wall
			System.out.println("rockwall");
			addSequential(new AutonomousSetpoints("vertical","hold"));
    		addSequential(new AutonomousDrive(overRockwall,rockwallSpeed));
    		break;
		case 7: //Crosses the rough terrain
			System.out.println("rough terrain");
			addSequential(new AutonomousSetpoints("vertical","hold"));
    		addSequential(new AutonomousDrive(overTerrain,defaultSpeed));
    		break;
		case 8: //Goes under the low bar
			System.out.println("lowbar");
			addSequential(new AutonIntakeDrive(-1));
			addSequential(new AutonomousSetpoints("horizontal","down"));
			addSequential(new Delay(0.5));
			addSequential(new IntakeStop());
    		addSequential(new AutonomousDrive(underBar,defaultSpeed));
    		break;
    	default:
    		break;
    	}
    	addSequential(new GearHigh());
    }
}
