package org.usfirst.frc.team4576.robot.subsystems;

import org.usfirst.frc.team4576.robot.Robot;
import org.usfirst.frc.team4576.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogGyro;
//import edu.wpi.first.wpilibj.BuiltInAccelerometer;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {

	double rpm = 0;
	double Rvelocity, Lvelocity = 0;
	private AnalogGyro gyro = new AnalogGyro(1);

	public Chassis() {
		tsrxL2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxL2.set(tsrxL.getDeviceID());
		tsrxL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		tsrxR2.changeControlMode(CANTalon.TalonControlMode.Follower);
		tsrxR2.set(tsrxR.getDeviceID());
		tsrxR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		// tsrxR.configEncoderCodesPerRev(768);
		// tsrxL.configEncoderCodesPerRev(768);
		/*
		 * tsrxR.configPeakOutputVoltage(6, -6);
		 * tsrxL.configPeakOutputVoltage(6, -6);
		 * tsrxR.configNominalOutputVoltage(0,0);
		 * tsrxL.configNominalOutputVoltage(0, 0);
		 */

		tsrxL.setAllowableClosedLoopErr(0);
		tsrxL.reverseOutput(true);
		tsrxL.reverseSensor(true);
		tsrxR.setAllowableClosedLoopErr(0);

		// ******Commented out encoder to troubleshoot******
		// System.out.println("quadEncoderPos" + quadEncoderPos);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	boolean manualOverride = false;

	public CANTalon tsrxL = new CANTalon(RobotMap.LEFT_MASTER);
	public CANTalon tsrxR = new CANTalon(RobotMap.RIGHT_MASTER);
	public CANTalon tsrxL2 = new CANTalon(RobotMap.LEFT_SLAVE);
	public CANTalon tsrxR2 = new CANTalon(RobotMap.RIGHT_SLAVE);
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

	public void resetGyro() {
		gyro.reset();
	}

	public double getAngle() {
		return gyro.getAngle();
	}

	public void setFPID(double f, double p, double i, double d) {
		tsrxL.setF(f);
		tsrxR.setF(f);
		tsrxL.setPID(p, i, d);
		tsrxR.setPID(p, i, d);

	}

	public void disable() {
		tsrxR.disable();
		// tsrxR2.disable();
		tsrxL.disable();
		// tsrxL2.disable();

	}

	public void initAuto() {
		drive.setSafetyEnabled(false);
		tsrxL.setEncPosition(0);
		tsrxR.setEncPosition(0);
		tsrxL.setPosition(0);
		tsrxR.setPosition(0);

		tsrxL.changeControlMode(TalonControlMode.Position);
		tsrxR.changeControlMode(TalonControlMode.Position);
		/*
		 * tsrxL.enableControl(); tsrxR.enableControl();
		 */
		// tsrxL.setVoltageRampRate(10000);
		// tsrxR.setVoltageRampRate(10000);
		drive.setExpiration(20000);
	}

	public String getPositions() {
		return tsrxL.getEncPosition() + " " + tsrxR.getEncPosition();
	}

	public double getRightPosition() {
		return tsrxR.getEncPosition();
	}

	public double getLeftPosition() {
		return tsrxL.getEncPosition();
	}

	public void initTeleop() {
		drive.setSafetyEnabled(true);
		tsrxL.changeControlMode(TalonControlMode.PercentVbus);
		tsrxR.changeControlMode(TalonControlMode.PercentVbus);
		drive.setExpiration(drive.DEFAULT_SAFETY_EXPIRATION);
		tsrxL.setEncPosition(0);
		tsrxR.setEncPosition(0);
		tsrxL.setPosition(0);
		tsrxR.setPosition(0);
		tsrxL.configEncoderCodesPerRev(768);
		tsrxR.configEncoderCodesPerRev(768);

	}

	// This declares that for driving only the assigned axes are used.
	public void normalDrive() {
		rpm = Robot.shooter.tsrxS.getSpeed();

		SmartDashboard.putNumber("RPM", rpm);

		double Lvelocity = Robot.chassis.tsrxL.getSpeed();
		SmartDashboard.putNumber("Motor Velocity L:", Lvelocity);
		double Rvelocity = Robot.chassis.tsrxR.getSpeed();
		SmartDashboard.putNumber("Motor Velocity R:", Rvelocity);

		drive.arcadeDrive(Robot.driveStick.getRawAxis(FORWARD_AXIS), Robot.driveStick.getRawAxis(TURN_AXIS));
	}

	public void setPositionLeftRight(double left, double right) {
		tsrxL.setPosition(left);
		tsrxR.setPosition(right);
	}
	
	/*
	 * public void encoders() {
	 * tsrxL.changeControlMode(TalonControlMode.Position);
	 * tsrxR.changeControlMode(TalonControlMode.Position);
	 * 
	 * Robot.chassis.tsrxL.setEncPosition(0);
	 * Robot.chassis.tsrxR.setEncPosition(0); } public void teleopMode() {
	 * tsrxL.changeControlMode(TalonControlMode.PercentVbus);
	 * tsrxR.changeControlMode(TalonControlMode.PercentVbus); }
	 * 
	 * // public void encoders() {
	 * tsrxL.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	 * tsrxR.setFeedbackDevice(FeedbackDevice.QuadEncoder);
	 * tsrxL.changeControlMode(TalonControlMode.Position);
	 * tsrxR.changeControlMode(TalonControlMode.Position);
	 * tsrxL.configEncoderCodesPerRev(768); tsrxR.configEncoderCodesPerRev(768);
	 * tsrxL.setPosition(0); tsrxR.setPosition(0);
	 */
}
