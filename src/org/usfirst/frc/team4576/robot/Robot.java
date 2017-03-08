
package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.AutoBaseline;
import org.usfirst.frc.team4576.robot.commands.AutoMiddleGear;
import org.usfirst.frc.team4576.robot.commands.Autonomous;
import org.usfirst.frc.team4576.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team4576.robot.subsystems.Agitator;
import org.usfirst.frc.team4576.robot.subsystems.Chassis;
import org.usfirst.frc.team4576.robot.subsystems.Climber;
import org.usfirst.frc.team4576.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4576.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Agitator agitator = new Agitator();
	public static final Chassis chassis = new Chassis();
	public static final Climber climber = new Climber();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final Shooter shooter = new Shooter();
	public static OI oi;

	public static Joystick driveStick = new Joystick(0);
	UsbCamera camera = new UsbCamera("cam0", 0);

	Command teleopCommand;
	Command autonomousCommand;
	final String defaultAuto = "Default";
	final String baselineAuto = "Baseline Auto";
	final String timedMiddleGear = "Timed Middle Gear";
	String autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();
	// SendableChooser chooser;

	public void robotInit() {
		chooser = new SendableChooser<>();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("Baseline Auto", baselineAuto);
		chooser.addObject("Middle Gear Auto", timedMiddleGear);
		SmartDashboard.putData("Auto Choices", chooser);
		System.out.println("RNR 2017 Robot Code Initializing...");
		oi = new OI();
		// chooser = new SendableChooser();
		// chooser.addDefault("Auto Drive 1", new AutoDrive1());
		// chooser.addObject("Auto Drive 2", new AutoDrive2());
		// SmartDashboard.putData("Auto Choices:", chooser);

		teleopCommand = new DriveWithJoysticks();
		autonomousCommand = new Autonomous();
		autonomousCommand = new AutoBaseline();

		camera.setFPS(15);
		camera.setResolution(320, 240);
		CameraServer.getInstance().startAutomaticCapture(camera);

	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the RPMchooser code above) shows how to
	 * select between different autonomous modes using the dashboard. The
	 * sendable RPMchooser code works with the Java SmartDashboard. If you
	 * prefer the LabVIEW Dashboard, remove all of the RPMchooser code and
	 * uncomment the getString code to get the auto name from the text box below
	 * the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {

		switch (chooser.getSelected()) {
		case "baselineAuto":
			autonomousCommand = new AutoBaseline();
			break;
		case "timedMiddleGear":
			autonomousCommand = new AutoMiddleGear();
			break;
		default:
			autonomousCommand = new Autonomous();
			break;
		}

		if (autonomousCommand != null)

		chassis.setFPID(0, .2, 0, 0);
		chassis.initAuto();
		autonomousCommand.start();

	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putString("Postions: ", chassis.getPositions());
	}

	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		chassis.initTeleop();
		teleopCommand.start();
		// Robot.chassis.teleopMode();

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
