package org.usfirst.frc.team4576.robot.subsystems;

import com.ctre.CANTalon;

//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {

	public Climber() {
	}

	CANTalon tsrxC = new CANTalon(5);

	@Override
	protected void initDefaultCommand() {

	}

	public void climb() {
		tsrxC.set(1);	// shooterWheelR.set(1);

	}
	public void reverse() {
		tsrxC.set(-1);
	}

	public void stop() {
		// shooterElevL.set(0);
		tsrxC.set(0);

	}

}
