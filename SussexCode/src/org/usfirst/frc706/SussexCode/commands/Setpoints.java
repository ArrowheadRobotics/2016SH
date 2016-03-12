package org.usfirst.frc706.SussexCode.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc706.SussexCode.Constants;
import org.usfirst.frc706.SussexCode.Robot;
import org.usfirst.frc706.SussexCode.RobotMap;

public class Setpoints extends Command {
	
	public String goToLocation = "";
	public static String fromLocation = "";
	public String delayWhat = "";
	
    public Setpoints(String setPoint) {
    	goToLocation = setPoint;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	System.out.println("--------init--------");
    	/*System.out.println("goToLocation: " + goToLocation);
    	System.out.println("fromLocation: " + fromLocation);
    	System.out.println("--------------------");*/
    	Robot.intake.stopPositionSet = false;
    	if(fromLocation.equals(""))
    	{
    		fromLocation = "shoot";
    		System.out.println("fromLoc was null, setting to" + fromLocation);
    	}
    	
    	switch(goToLocation)
    	{
    	case "intake":
    		switch(fromLocation)
    		{
    			case "intake":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_DOWN);
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    				break;
    			case "hold":
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    				delayWhat = "shooter";
    				System.out.println("settting delay what to shooter");
    				break;
    			case "shoot":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_DOWN);
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    				break;
    		}
    		break;
    		
    	case "hold":
    		switch(fromLocation)
    		{
    			case "intake":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_HOLD);
    				System.out.println("activating shooter arm");
    				delayWhat = "intake";
    				RobotMap.intakeintakeDrive.set(0.5);
    				break;
    			case "hold":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_HOLD);
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_VERTICAL);
    				break;
    			case "shoot":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_HOLD);
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_VERTICAL);
    				break;
    		}
    		break;
    		
    	case "shoot":
    		switch(fromLocation)
    		{
    			case "intake":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_TOP);
    				Robot.shooter.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    				RobotMap.intakeintakeDrive.set(0.5);
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_TOP);
    				break;
    			case "hold":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_TOP);
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    				break;
    			case "shoot":
    				Robot.shooter.changePos(Constants.Setpoints.SHOOTER_TOP);
    				Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    				break;
    		}
    		break;
    	}
    	System.out.println("delayWhat: " + delayWhat);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	//System.out.println("--------execute--------");
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//System.out.println("--------isfinished--------");
        if(delayWhat.equals("intake"))
        {
        	//System.out.println(RobotMap.shootershooterAngleDrive.getEncPosition());
        	if(RobotMap.shootershooterAngleDrive.getEncPosition() < -4450)
        		return false;
        }
        else if(delayWhat.equals("shooter"))
        {
        	//System.out.println(RobotMap.intakeintakeAngleDrive.getEncPosition());
        	if(RobotMap.intakeintakeAngleDrive.getEncPosition() < -1600)
        		return false;
        }
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(delayWhat.equals("shooter"))
    	{
    		Robot.shooter.changePos(Constants.Setpoints.SHOOTER_DOWN);
    	}
    	else if(delayWhat.equals("intake"))
    	{
    		if(goToLocation.equals("shoot"))
    			Robot.intake.changePos(Constants.Setpoints.INTAKE_HORIZONTAL);
    		else
    			Robot.intake.changePos(Constants.Setpoints.INTAKE_VERTICAL);
    	}
    	fromLocation = goToLocation;
    	Robot.intake.shooterArmFromLocation = fromLocation;
    	System.out.println("======end function========");
    	/*System.out.println("updated fromLoc to: " + fromLocation);
    	System.out.println("goToLocation is: " + goToLocation);
    	System.out.println("==========================");*/
    	delayWhat = "";
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
