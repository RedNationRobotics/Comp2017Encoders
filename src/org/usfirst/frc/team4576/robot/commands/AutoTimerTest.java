package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoTimerTest extends Command{
	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		//-,- to turn right, +,+ to turn left
		

		Robot.chassis.setLeftRight(-.6, .6);
		Timer.delay(1.85);
		Robot.chassis.setLeftRight(.6, .6);//idk if this is correct. its supposed to turn left
		Timer.delay(.4);
		Robot.chassis.setLeftRight(-.6, .6);
		Timer.delay(.5);
	

		

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
