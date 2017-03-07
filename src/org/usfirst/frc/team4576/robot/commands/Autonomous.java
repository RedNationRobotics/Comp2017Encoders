package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Autonomous extends Command {
	
	private Robot robot;
	public Autonomous(Robot robot)
	{
		super();
		this.robot = robot;
	}
	private boolean finished = false;
	private boolean next = false;
	@Override
	protected void initialize() {
	//	Robot.chassis.encoders();
		//robot.getChassis().setPosition(800000);
		//Timer.delay(5);
		finished = false;
		robot.getChassis().resetGyro();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
	//	Robot.chassis.setLeftRight(15, 15);
	
	
	
	if(robot.getChassis().getLeftPosition() > 400 * 768){
		robot.getChassis().setLeftRight(-0.5, -0.5);
	}else{
		robot.getChassis().setLeftRight(-1, -1);
	}
	if(robot.getChassis().getLeftPosition() > 500 * 768)
	{
		next = true;
	}
		
		if(next)
		{
			if(robot.getChassis().getAngle() > 100)
			{
				finished = true;
			}
			robot.getChassis().setLeftRight(0.3, -0.3);
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {
		robot.getChassis().setLeftRight(0, 0);
		

	}

	@Override
	protected void interrupted() {

	}

}