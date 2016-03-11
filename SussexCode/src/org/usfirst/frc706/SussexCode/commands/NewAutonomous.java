package org.usfirst.frc706.SussexCode.commands;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NewAutonomous extends CommandGroup {
	
	private int defense;
	private int robotPosition;
	private int defensePosition;
	private int toPortcullis = Constants.Autonomous.TO_PORTCULLIS;
	private int liftPortcullis = Constants.Autonomous.OVER_PORTCULLIS;
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

    public NewAutonomous() {
    	defense = (int) Robot.def.getSelected();
    	defensePosition = (int) Robot.dpos.getSelected();
    	robotPosition = (int) Robot.rpos.getSelected();
    	
    	addSequential(new Zero());
    	addSequential(new GearLow());
    	
    	RobotMap.intakeintakeAngleDrive.changeControlMode(TalonControlMode.Position);
    	switch(defense){
		case 0: //Crosses portcullis
			addSequential(new AutonomousSetpoints("horizontal","down"));
			addSequential(new AutonomousDrive(toPortcullis,defaultSpeed));
			Timer.delay(2);
			addSequential(new AutonomousSetpoints("lower","down"));
			Timer.delay(2);
    		addSequential(new AutonomousDrive(liftPortcullis, defaultSpeed));
    		Timer.delay(5);
    		addSequential(new AutonomousSetpoints("horizontal","down"));
			Timer.delay(0.25);
			addSequential(new AutonomousDrive(overPortcullis, defaultSpeed));
			break;
		case 1: //Crosses the french fries
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
			addSequential(new AutonomousSetpoints("horizontal","down"));
    		addSequential(new AutonomousDrive(underBar,defaultSpeed));
    		break;
    	default:
    		break;
    	}
    	addSequential(new GearHigh());
    }
}
