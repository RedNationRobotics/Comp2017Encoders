package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class Shoot extends Command {
	private boolean in = true;

	public Shoot(boolean in) {
		this.in = in;
		requires(Robot.shooter);
	}

	public Shoot() {
	
	}
	@Override
	protected void initialize() {
		if (in) {
			Robot.shooter.shoot();
		} else {
			Robot.shooter.stop();
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
