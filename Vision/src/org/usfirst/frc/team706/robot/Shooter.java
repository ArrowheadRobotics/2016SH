package org.usfirst.frc.team706.robot;

public class Shooter {
	private final float kpDist = 0.005f;
	private final float kpAng = 0.005f;
	
	public void goToDist(float dist) {
		float startDist = this.getDistance();
		if (startDist == -1) {
			Robot.leftMot.set(0.0f);
			Robot.rightMot.set(0.0f);
		}
		float error = dist - startDist;
		float value = error * kpDist;
		Robot.leftMot.set(value);
		Robot.rightMot.set(value * -1);
	}
	
	public void goToAng(float ang) {
		float startAng = this.getAngle();
		if (Math.abs(startAng) > 180) {
			startAng -= (Math.sqrt(startAng * startAng) / startAng) * 360;
		}
		float error = ang - startAng;
		float value = error * this.kpAng;
		boolean neg = (value < 0);
		value = Math.abs(value);
		value = (float) Math.sqrt(value);
		if (neg) {
			value *= -1;
		}
		Robot.leftMot.set(value);
		Robot.rightMot.set(value);
	}
	
	public float getDistance() {
		float top = Robot.rangeTop.getDistance();
		float bot = Robot.rangeBot.getDistance();
		if (Math.abs((top + bot) / 2 - top) < 10) {
			return -1.0f;
		}
		return (top + bot) / 2;
	}
	
	public float getAngle() {
		return (float) Robot.nav.getYaw();
	}
}