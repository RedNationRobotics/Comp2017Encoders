package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoMiddleGear extends Command {

	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		//99 inches to barb. ticks per inch L:373.3 R:-356.7
		//Robot.chassis.setPositionLeftRight(36956.7, -35313.3);
		Robot.chassis.tsrxL.setPosition(36956.7);
		Robot.chassis.tsrxR.setPosition(-35313.3);
		//Timer.delay(4);
		Robot.pneumatics.gearUp();
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