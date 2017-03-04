package org.usfirst.frc.team4576.robot.subsystems;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;
	public CANTalon tsrxS = new CANTalon(4);

	double motorOutput = tsrxS.getOutputVoltage() / tsrxS.getBusVoltage();
	
	// public SendableChooser RPMchooser;
	// public double preset1 = (double) (4500);
	// public double preset2 = (double) (4000);
	// public double preset3 = (double) (3500);
	// public double preset4 = (double) (3000);
	//double sliderVal = (double) 0.0;
	//double targetSpeed = SmartDashboard.getNumber("DB/Slider 0", sliderVal) * 1000.0;
	double targetSpeed = (double) 4000.0;

	public Shooter() {

		/*
		 * RPMchooser = new SendableChooser(); RPMchooser.addObject("RPM: 4500",
		 * Robot.shooter.preset1()); RPMchooser.addObject("RPM: 4000",
		 * Robot.shooter.preset2()); RPMchooser.addObject("RPM: 3500",
		 * Robot.shooter.preset3()); RPMchooser.addObject("RPM: 3000",
		 * Robot.shooter.preset4());
		 */

	//	SmartDashboard.putNumber("DB/Slider 0", sliderVal);
		
		
		
		
		tsrxS.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		tsrxS.reverseSensor(true);
		tsrxS.changeControlMode(TalonControlMode.Speed);
		tsrxS.configNominalOutputVoltage(+0.0f, -0.0f);
		tsrxS.configPeakOutputVoltage(+12.0f, -0.0f);
		tsrxS.setEncPosition(0);
		/* set closed loop gains in slot0 */
		tsrxS.setProfile(0);
		tsrxS.setF(.0317);
		tsrxS.setP(0);
		tsrxS.setI(0);
		tsrxS.setD(0);
	}

	/*
	 * private Object preset1() { tsrxS.set(4500.0); return null; }
	 * 
	 * private Object preset2() { tsrxS.set(4000.0); return null; }
	 * 
	 * private Object preset3() { tsrxS.set(3500.0); return null; } private
	 * Object preset4() { tsrxS.set(3000.0); return null; }
	 */

	public void shoot() {
		tsrxS.set(targetSpeed);
		
		// RPMchooser.getSelected();
	}

	/*
	 * public void Shoot() { tsrxS.set(targetSpeed); /* 1500 RPM in either
	 * direction
	 */

	public void stop() {
		tsrxS.set(0);
	}
	
	protected void initDefaultCommand() {
		/* get gamepad axis */

	}

}
