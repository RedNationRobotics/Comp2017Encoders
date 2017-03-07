package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoysticks extends Command {
	
	private Robot robot;
	public DriveWithJoysticks(Robot robot)
	{
		this.robot = robot;
	}
	
	public DriveWithJoysticks(){
		
		requires(robot.getChassis());
        robot.getChassis().initTeleop();
        
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		robot.getChassis().normalDrive();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
