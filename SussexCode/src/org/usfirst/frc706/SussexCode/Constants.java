package org.usfirst.frc706.SussexCode;

public class Constants {
	
	public class Setpoints {
		//Intake
		public static final int INTAKE_VERTICAL = -2750; 
		public static final int INTAKE_HORIZONTAL = -870;
		public static final int INTAKE_LOWER = -150;
		
		//Shooter
		public static final int SHOOTER_DOWN = -7100;
		public static final int SHOOTER_HOLD = -4000;
		public static final int SHOOTER_TOP = 0;
	}
	
	public class PID {
		//Intake
		public static final double P_INTAKE = 2.25;
		public static final double I_INTAKE = 0;
		public static final double D_INTAKE = 20;
		
		//Shooter
		public static final double P_SHOOTER = 2.5;
		public static final double I_SHOOTER = 0.0001;
		public static final double D_SHOOTER = 20;
	}
	
	public class Controls {
		//Joysticks
		public static final int XBOX_PORT = 0;
		public static final int LEFT_JOY_PORT = 1;
		public static final int RIGHT_JOY_PORT = 2;
		
		//Xbox Buttons
		public static final int A_BUTT = 1;
		public static final int B_BUTT = 2;
		public static final int X_BUTT = 3;
		public static final int Y_BUTT = 4;
		public static final int LB = 5;
		public static final int RB = 6;
		public static final int START = 8;
		
		//Joystick Buttons
		public static final int RIGHT_JOY_TRIGGER = 1;
		public static final int LEFT_JOY_TRIGGER = 1;
		public static final int HOOK_BUTTON_ONE = 2;
		public static final int HOOK_BUTTON_TWO = 2;
		public static final int WINCH_BUTTON_ONE = 4;
		public static final int WINCH_BUTTON_TWO = 5;
		public static final int CONTROL_BUTTON = 8;
	}
	
	public class Talons {
		//Chassis 
		public static final int LEFT_MOTOR_ONE = 2;
		public static final int LEFT_MOTOR_TWO = 3;
		public static final int RIGHT_MOTOR_ONE = 4;
		public static final int RIGHT_MOTOR_TWO = 5;
		
		//Intake
		public static final int INTAKE_DRIVE = 0;
		public static final int INTAKE_ANGLE = 1;
		
		//Shooter
		public static final int SHOOTER_ANGLE = 6;
	}
	
	public class PCM {
		//PCM IDs
		public static final int PCM_ONE_ID = 10;
		public static final int PCM_TWO_ID = 9;
		
		//Shooter
		public static final int SHOOTER_SOL_ONE_FORWARD = 3;
		public static final int SHOOTER_SOL_ONE_REVERSE = 0;
		public static final int SHOOTER_SOL_TWO_FORWARD = 1;
		public static final int SHOOTER_SOL_TWO_REVERSE = 2;
		public static final int TRIGGER_SOL_FORWARD = 4;
		public static final int TRIGGER_SOL_REVERSE = 5;
		
		//Winch
		public static final int PTO_FORWARD = 2;
		public static final int PTO_REVERSE = 3;
	}
	
	public class Speeds {
		//Shooter
		public static final double SHOOTER_ANGLE_SPEED = 0.8 ;
		
		//Intake
		public static final double INTAKE_ANGLE_SPEED = 0.4;
		public static final double INTAKE_DRIVE_SPEED = 1;
		
		//Winch
		public static final double WINCH_DRIVE_SPEED = 1;
		
		//Other & Shared
		public static final double ZERO_SPEED = 0.6;
	}
	
	public class Encoders {
		//Drive
		public static final int LEFT_ENC_PORT = 0;
		public static final int RIGHT_ENC_PORT = 1;
	}
	
	public class Deadzones {
		//Drive 
		public static final double DRIVE_DEADZONE = 0.2;
	}
	
	public class Autonomous {
		//Distances
		public static final int TO_PORTCULLIS = 6500;
		public static final int LIFT_PORTCULLIS = 1000;
		public static final int OVER_PORTCULLIS = 10000;
		public static final int TO_CHEVAL = 6900;
		public static final int ON_CHEVAL = 5000;
		public static final int OVER_CHEVAL = 12000;
		public static final int MOAT_DISTANCE = 25000;
		public static final int RAMPART_DISTANCE = 25000;
		public static final int ROCKWALL_DISTANCE = 25000;
		public static final int TERRAIN_DISTANCE = 20000;
		public static final int LOWBAR_DISTANCE = 20000;
		
		//Speeds
		public static final double DEFAULT_SPEED = -0.6;
		public static final double CHEVAL_SPEED = -0.8;
		public static final double MOAT_SPEED = -0.9;
		public static final double RAMPART_SPEED = -0.7;
		public static final double ROCKWALL_SPEED = -0.6;
	}
}
