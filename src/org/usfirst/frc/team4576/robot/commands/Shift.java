package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Shift extends Command {
	private boolean in = true;

	public Shift(boolean in) {
		this.in = in;
		requires(Robot.pneumatics);
	}

	@Override
	protected void initialize() {
		if (in) {
			Robot.pneumatics.shiftUp();
		} else {
			Robot.pneumatics.shiftDown();
		}
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		// changed to true to check issues
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
