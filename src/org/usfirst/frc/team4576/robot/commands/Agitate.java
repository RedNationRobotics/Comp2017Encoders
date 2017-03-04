package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Agitate extends Command {
	private boolean in = true;

	public Agitate(boolean in) {
		this.in = in;
		requires(Robot.agitator);
	}

	@Override
	protected void initialize() {
		if (in) {
			Robot.agitator.agitatorGo();
		} else {
			Robot.agitator.agitatorStop();
		}
	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		// changed to true to check issues
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {

	}

}
