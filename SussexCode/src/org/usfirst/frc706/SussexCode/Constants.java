 package org.usfirst.frc706.SussexCode;

public class Constants {
	public static final int PCM_ONE_ID = 10;
	public static final int PCM_TWO_ID = 9;
	
	public class Setpoints {
		public static final double POINT_ONE_SHOOTER = 0;
		public static final double POINT_ONE_INTAKE = 2104;

		public static final double POINT_TWO_SHOOTER = 0;
		public static final double POINT_TWO_INTAKE = 0;

		public static final double POINT_THREE_SHOOTER = 0;
		public static final double POINT_THREE_INTAKE = 0;
	}
	
	public class Chassis {
		public static final int LEFT_MOTOR_ONE = 2;
		public static final int LEFT_MOTOR_TWO = 3;
		public static final int RIGHT_MOTOR_ONE = 4;
		public static final int RIGHT_MOTOR_TWO = 5;
		public static final int SPIKE_PORT = 0;
	}
	
	public class Intake {
		//PID
		public static final double P_INTAKE = 0.25;
		public static final double I_INTAKE = 0;
		public static final double D_INTAKE = 0;
		
		//Talon CAN IDs
		public static final int INTAKE_DRIVE = 0;
		public static final int INTAKE_ANGLE = 1;
		
		//Speeds 
		public static final double INTAKE_ANGLE_SPEED = 0.4;
		public static final double INTAKE_DRIVE_SPEED = 1;
		public static final double INTAKE_LIFT_SPEED = 1;
	}
	
	public class Shooter {
		//PID
		public static final double P_SHOOTER = 0.25;
		public static final double I_SHOOTER = 0;
		public static final double D_SHOOTER = 0;
		
		public static final int SHOOTER_ANGLE = 6;
		
		public static final double SHOOTER_ANGLE_SPEED = 0.8 ;
		
		public static final int SHOOTER_SOL_ONE_FORWARD = 3;
		public static final int SHOOTER_SOL_ONE_REVERSE = 0;
		public static final int SHOOTER_SOL_TWO_FORWARD = 1;
		public static final int SHOOTER_SOL_TWO_REVERSE = 2;
		public static final int TRIGGER_SOL_FORWARD = 4;
		public static final int TRIGGER_SOL_REVERSE = 5;
		
	}
	
	public class Winch {
		
		public static final double WINCH_DRIVE_SPEED = 1;
		
		public static final int PTO_FORWARD = 2;
		public static final int PTO_REVERSE = 3;
	}
	
	public class Controls {
		public static final int XBOX_PORT = 0;
		public static final int LEFT_JOY_PORT = 1;
		public static final int RIGHT_JOY_PORT = 2;
		
		public static final int A_BUTT = 1;
		public static final int B_BUTT = 2;
		public static final int X_BUTT = 3;
		public static final int Y_BUTT = 4;
		public static final int LB = 5;
		public static final int RB = 6;
		
		public static final int RIGHT_JOY_TRIGGER = 1;
		public static final int LEFT_JOY_TRIGGER = 1;
		
	}
}
