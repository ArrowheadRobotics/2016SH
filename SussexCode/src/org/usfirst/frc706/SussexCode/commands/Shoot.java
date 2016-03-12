package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class Shoot extends Command {
	
	public long startTime;
	public boolean triggerRelease = false;
	public boolean pistonRetract = false;
	public boolean triggerEngage = false;
	public boolean engagePistons = false;
	public boolean doneShooting = false;

    public Shoot() {
    	requires(Robot.shooter);
    }

	protected void initialize() {
		//Robot.chassis.shooting = true;
		startTime = System.currentTimeMillis(); 
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.shooterAngleDrive.getEncPosition() > -2000) {
    		/*Robot.shooter.shooterTriggerSol.set(Value.kReverse); //TRIGGER RELEASE
    		Timer.delay(.25);
    		RobotMap.shooterOneSol.set(Value.kReverse); //RETRACTION
    		RobotMap.shooterTwoSol.set(Value.kReverse);
    		Timer.delay(.5);
    		RobotMap.shooterTriggerSol.set(Value.kForward); //RE-ENGAGE TRIGGER
    		Timer.delay(.15);
    		RobotMap.shooterOneSol.set(Value.kForward); //RE-PRIME PISTONS
    		RobotMap.shooterTwoSol.set(Value.kForward);*/
    		if(!triggerRelease) {
    			Robot.shooter.shooterTriggerSol.set(Value.kReverse);
    			triggerRelease = true;
    		}
    		if(System.currentTimeMillis() + 250 > startTime && !pistonRetract) {
    			RobotMap.shooterOneSol.set(Value.kReverse); 
        		RobotMap.shooterTwoSol.set(Value.kReverse);
    			pistonRetract = true;
    		}
    		if(System.currentTimeMillis() + 750 > startTime && !triggerEngage) {
    			RobotMap.shooterTriggerSol.set(Value.kForward); 
    			triggerEngage = true;
    		}
    		if(System.currentTimeMillis() + 900 > startTime && !engagePistons) {
    			RobotMap.shooterOneSol.set(Value.kForward);
    			RobotMap.shooterTwoSol.set(Value.kForward);
    			engagePistons = true;
    			doneShooting = true;
    		}
    		
    		
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return doneShooting;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.chassis.shooting = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
