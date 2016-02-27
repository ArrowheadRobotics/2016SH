package org.usfirst.frc.team706.robot;

import edu.wpi.first.wpilibj.AnalogInput;

public class RangeFinder {
	protected int pin;
	protected AnalogInput value;
	public float[] average;
	
	public RangeFinder(int n) {
		this.pin = n;
		this.value = new AnalogInput(n);
		this.average = new float[5];
		for (int x = 0; x < average.length; x++) {
			this.average[x] = (this.getRawValue() / 0.8f) / 25.4f;
		}
	}
	
	public float getAverage() {
		float s = 0;
		for (int x = 0; x < average.length; x++) {
			s += this.average[x];
		}
		return (s / this.average.length);
	}
	
	public float getRawValue() {
		return this.value.getValue();
	}
	
	public float getDistance() {
		float dist = (this.getRawValue() / 0.8f) / 25.4f;
		return dist;
	}
	
	public void shiftAverage() {
		for (int x = 0; x < average.length - 1; x++) {
			this.average[x+1] = this.average[x];
		}
	}
}
