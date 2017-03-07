package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutoMiddleGear extends Command {
	
	public AutoMiddleGear(){
	}
	@Override
	protected void initialize() {
	//	Robot.chassis.encoders();
		//Robot.chassis..setPosition(800000);
		//Timer.delay(5);
		Robot.chassis.resetGyro();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
	//	Robot.chassis.setLeftRight(15, 15);
	
	Robot.chassis.setLeftRight(-1, -1);
	Timer.delay(5);
	Robot.pneumatics.setGear(true);
		
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