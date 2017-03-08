package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoMiddleGear extends Command {

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		Robot.chassis.setLeftRight(-0.5, 0.5);
		Timer.delay(1.5);
		Robot.pneumatics.gear();
		Robot.chassis.setLeftRight(0, 0);

	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);
		

	}

	@Override
	protected void interrupted() {

	}

}