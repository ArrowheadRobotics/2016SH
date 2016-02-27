package org.usfirst.frc706.SussexCode.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class Shoot extends Command {
	public long startTime;
	public long currentTime;
	public int retractShooterDelay=500;
	public int extendTriggerDelay=500;
	public int extendShooterDelay=500;
	private boolean done=false;
	
    public Shoot() {
    	requires(Robot.shooter);
    }
  
    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime=System.currentTimeMillis();
    	new TriggerToggle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentTime = System.currentTimeMillis();
    	if(currentTime>retractShooterDelay&&currentTime<retractShooterDelay+extendTriggerDelay+extendShooterDelay) {
   			new TogglePiston();
   		}
   		if(currentTime>retractShooterDelay+extendTriggerDelay) {
   			new TriggerToggle();
   		}
   		if(currentTime>retractShooterDelay+extendTriggerDelay+extendShooterDelay) {
   			new TogglePiston();
   			done=true;    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	done=false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
