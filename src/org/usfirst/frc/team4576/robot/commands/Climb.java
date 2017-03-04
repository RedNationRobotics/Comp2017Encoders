package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command {
	private boolean in = true;

	public Climb(boolean in) {
		this.in = in;
		requires(Robot.climber);
	}

	@Override
	protected void initialize() {
		if (in) {
			Robot.climber.climb();
		} else {
			Robot.climber.stop();
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
