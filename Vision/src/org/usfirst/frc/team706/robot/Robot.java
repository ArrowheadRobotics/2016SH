package org.usfirst.frc.team706.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	public static WebCam cam;
	public static CANTalon leftMot;
	public static CANTalon rightMot;
	public static Joystick xbc;
	public static Shooter shooter;
	public static Integer count;
	public static RangeFinder rangeBot;
	public static RangeFinder rangeTop;
	public static AHRS nav;
	
	public void robotInit() {
    	cam = new WebCam("cam0");
    	rangeBot = new RangeFinder(0);
    	rangeTop = new RangeFinder(1);
    	xbc = new Joystick(2);
    	rightMot = new CANTalon(1);
    	leftMot = new CANTalon(2);
    	shooter = new Shooter();
    	count = new Integer(0);
    	try {
    		nav = new AHRS(SPI.Port.kMXP);
    	}
    	catch (RuntimeException rte) {
    		System.out.println("Error Initializing navX-MXP");
    	}
    	nav.reset();
    }
	
	public void operatorControl() {
    	cam.operator();
        while (isOperatorControl() && isEnabled()) {
        	cam.loop();
            Timer.delay(0.1);
            if (xbc.getRawButton(1)) {
            	count = 0;
            }
            if (xbc.getRawButton(2)) {
            	count = 1;
            }
            if (xbc.getRawButton(3)) {
            	count = 2;
            }
            if (xbc.getRawButton(4)) {
            	count = 3;
            }
            if (xbc.getRawButton(5)) {
            	nav.reset();
            	System.out.println("reset");
            }
            switch(count) {
            case 0:
            	if (xbc.getRawAxis(3) > xbc.getRawAxis(2)) {
            		leftMot.set(xbc.getRawAxis(3) *-1 + xbc.getRawAxis(0));
            		rightMot.set(xbc.getRawAxis(3) + xbc.getRawAxis(0));
            	}
            	else {
            		leftMot.set(xbc.getRawAxis(2) + xbc.getRawAxis(0));
            		rightMot.set(xbc.getRawAxis(2) * -1 + xbc.getRawAxis(0));
            	}
            	break;
            case 1:
            	shooter.goToAng(53);
            	break;
            case 2:
            	shooter.goToAng(142);
            	break;
            case 3:
            	shooter.goToAng(-113);
            }
        }
        cam.stop();
	}
}
