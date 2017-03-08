package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoBaseline extends Command {
	//LITERALLY COPIED AND PASTED FROM AUTONOMOUS CLASS
	public AutoBaseline()
	{
	}
	private boolean finished = false;
	private boolean next = false;
	@Override
	protected void initialize() {
	//	Robot.chassis.encoders();
		//robot.getChassis().setPosition(800000);
		//Timer.delay(5);
		finished = false;
		Robot.chassis.resetGyro();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
	//	Robot.chassis.setLeftRight(15, 15);
	
	
	
	if(Robot.chassis.getLeftPosition() > -10 * 768){
		Robot.chassis.setLeftRight(0.15, 0.15);
	}else{
		Robot.chassis.setLeftRight(.25, .25);
	}
	if(Robot.chassis.getLeftPosition() > -15 * 768)
	{
		next = true;
	}
		
		if(next)
		{
			if(Robot.chassis.getAngle() > 100)
			{
				finished = true;
			}
			Robot.chassis.setLeftRight(0.3, -0.3);
		}
		
		
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {
		Robot.chassis.setLeftRight(0, 0);
		

	}

	@Override
	protected void interrupted() {

	}

}
