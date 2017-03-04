package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;

import com.ctre.CANTalon;

//import edu.wpi.first.wpilibj.BuiltInAccelerometer;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	
	double rpm = 0;

	public Chassis() {
		tsrxL2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxL2.set(tsrxL.getDeviceID());
		tsrxR2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxR2.set(tsrxR.getDeviceID());
		//******Commented out encoder to troubleshoot******
		//System.out.println("quadEncoderPos" + quadEncoderPos);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	boolean manualOverride = false;

	public CANTalon tsrxL = new CANTalon(0);
	public CANTalon tsrxR = new CANTalon(1);
	public CANTalon tsrxL2 = new CANTalon(2);
	public CANTalon tsrxR2 = new CANTalon(3);
	// ******Commented out encoder to troubleshoot******
	// double quadEncoderPos = tsrxR.getEncPosition();

	// This defines the talons used to drive.
	RobotDrive drive = new RobotDrive(tsrxL, tsrxR);
	// These 2 lines declare the axes for turning	
	public static final int FORWARD_AXIS = 1;
	public static final int TURN_AXIS = 4;
	// Encoder right = new Encoder(1,2);

	PowerDistributionPanel pdp = new PowerDistributionPanel();

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	// This defines whether a talon is on the right or left.
	public void setLeftRight(double left, double right) {
		tsrxL.set(left);
		// tsrxL2.set(left);
		tsrxR.set(right);
		// tsrxR2.set(right);

	}

	public void disable() {
		tsrxR.disable();
		// tsrxR2.disable();
		tsrxL.disable();
		// tsrxL2.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
	}

	public void initTeleop() {
		drive.setSafetyEnabled(false);
	}

	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {
		rpm = Robot.shooter.tsrxS.getSpeed();

		SmartDashboard.putNumber("RPM", rpm);
		drive.arcadeDrive(Robot.driveStick.getRawAxis(FORWARD_AXIS), Robot.driveStick.getRawAxis(TURN_AXIS));
	}

/*	public void encoders() {
		tsrxL.changeControlMode(TalonControlMode.Position);
		tsrxR.changeControlMode(TalonControlMode.Position);

		Robot.chassis.tsrxL.setEncPosition(0);
		Robot.chassis.tsrxR.setEncPosition(0);
	}
	public void teleopMode() {
		tsrxL.changeControlMode(TalonControlMode.PercentVbus);
		tsrxR.changeControlMode(TalonControlMode.PercentVbus);
	}

	//
	 * public void encoders() {
	 * tsrxL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	 * tsrxR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	 * tsrxL.changeControlMode(TalonControlMode.Position);
	 * tsrxR.changeControlMode(TalonControlMode.Position);
	 * tsrxL.configEncoderCodesPerRev(768); tsrxR.configEncoderCodesPerRev(768);
	 * tsrxL.setPosition(0); tsrxR.setPosition(0);
	 */
}
