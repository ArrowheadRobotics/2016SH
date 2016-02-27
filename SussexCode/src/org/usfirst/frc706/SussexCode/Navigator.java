package org.usfirst.frc706.SussexCode;

import com.kauailabs.navx.frc.AHRS;

public class Navigator {
	private AHRS ahrs;
	
	public Navigator() {
		this.ahrs = Robot.nav;
		this.ahrs.reset();
	}
	
	public void reset() {
		this.ahrs.reset();
	}
	
	public void print() {
		System.out.println(
				"Yaw : " + this.ahrs.getYaw() +
				" | Pitch : " + this.ahrs.getPitch() +
				" | Roll : " + this.ahrs.getRoll()
				);
	}
}
