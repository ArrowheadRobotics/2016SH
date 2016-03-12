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
		System.out.println(startTime);
		triggerRelease = false;
		pistonRetract = false;
		triggerEngage = false;
		engagePistons = false;
		doneShooting = false;
		System.out.println("INIT SHOOT");
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.shooter.shooterAngleDrive.getEncPosition() > -2000) {
    		System.out.println("PROPER POS");
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
    			System.out.println("Release Trigger " + System.currentTimeMillis());
    		}
    		if((System.currentTimeMillis() > startTime + 250) && !pistonRetract) {
    			RobotMap.shooterOneSol.set(Value.kReverse); 
        		RobotMap.shooterTwoSol.set(Value.kReverse);
    			pistonRetract = true;
    			System.out.println("Retract Pistons " + System.currentTimeMillis());
    		}
    		if((System.currentTimeMillis() > startTime + 750 ) && !triggerEngage) {
    			RobotMap.shooterTriggerSol.set(Value.kForward); 
    			triggerEngage = true;
    			System.out.println("Engage Trigger " + System.currentTimeMillis());
    		}
    		if((System.currentTimeMillis() > startTime + 900 ) && !engagePistons) {
    			RobotMap.shooterOneSol.set(Value.kForward);
    			RobotMap.shooterTwoSol.set(Value.kForward);
    			engagePistons = true;
    			doneShooting = true;
    			System.out.println("Engage pistons " + System.currentTimeMillis());
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
    	System.out.println("Shoot completed");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
