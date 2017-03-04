package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem {

	public Pneumatics() {
		s0 = new Solenoid(0);/* Shifting */
		s1 = new Solenoid(1);/* Gear */
		s2 = new Solenoid(2);/* Ball Adcancing */
		s3 = new Solenoid(3);/* Ball Advancing */

	}

	private Compressor c;
	private Solenoid s0,s1,s2,s3;
	@Override
	protected void initDefaultCommand() {
		c = new Compressor();
	}

	public void setAutoEnabled() {

		c.setClosedLoopControl(true);
	}
//Shifting
	public void setShift(boolean closed) {
		s0.set(closed);
	}

	public void shiftUp() {
		s0.set(true);

	}

	public void shiftDown() {
		s0.set(false);
	}
//Ball Advancing
	public void Fire(boolean closed) {
		s2.set(closed);
		s3.set(!closed);
	}
	public void toggleFire() {
		
		boolean b = !s2.get();
		s2.set(b);
		s3.set(!b);

	}
//Gear Grabbing
	public void setGear(boolean closed) {
		s1.set(closed);
	}
	
	public void gear() {
		s1.set(!s1.get());
		
	}
	
//Compressor Toggle
	public void toggleComp() {
		if (c.enabled())
			c.stop();
		else
			c.start();
	}

	public void stopComp() {
		c.stop();
	}

}
