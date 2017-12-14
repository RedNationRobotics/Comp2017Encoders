package org.usfirst.frc.team4576.robot.commands;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightAuto extends Command {

double encoder_Rclicks = Robot.chassis.getRightPosition();
	@Override
	protected void initialize() {
		Robot.chassis.initAuto();
	}

	@Override
	protected void execute() {
		//-,+ for forward, +,- for backwards
		//99 inches to barb. ticks per inch L:373.3 R:-356.7
		//Robot.chassis.setPositionLeftRight(36956.7, -35313.3);
		//moveauto: double targetLclicks, double targetRclicks, ECommand command, double seconds
		//Robot.chassis.tsrxL.setPosition(36956.7);
		//Robot.chassis.tsrxR.setPosition(-35313.3);
		//Timer.delay(4);
	        // Drive forwards for 50 units
	//	resetEncoders();
	        do {
	            Robot.chassis.setLeftRight(0.5, 0.0);
	        } while (getAverageEncoderPosition() < 50.0);
	        Robot.chassis.setLeftRight(0,0);
	    }		

private double getAverageEncoderPosition() {
    return (Robot.chassis.getLeftPosition()+ Robot.chassis.getRightPosition()) / 2;
}

/*public void resetEncoders(){
    Robot.chassis.tsrxL.setEncPosition(0);
    Robot.chassis.tsrxR.setEncPosition(0);
*/


int _MaxEncoderDifference = 300;
double targetLclicks = Robot.move._targetLclicks;
double currentLclicks = Robot.chassis.getLeftPosition();
public double GetPowerLeft(double currentLclicks, double targetLclicks)
{
	double difference = Math.abs(Robot.move._targetLclicks - Robot.chassis.getLeftPosition());
	
	if(difference > _MaxEncoderDifference){
		if(targetLclicks > currentLclicks)
			return 0.25;
		if(targetLclicks < currentLclicks)
			return -0.25;
	}
	return 0.0;
}
double targetRclicks = Robot.move._targetLclicks;
double currentRclicks = Robot.chassis.getLeftPosition();
public double GetPowerRight(double currentRclicks, double targetRclicks)
{
	double difference = Math.abs(Robot.move._targetRclicks - Robot.chassis.getRightPosition());
	
	if(difference > _MaxEncoderDifference){
		if(targetRclicks > currentRclicks)
			return 0.25;
		if(targetRclicks < currentRclicks)
			return -0.25;
	}
	return 0.0;
}

	/*public void Move() {
		do { 
			_encoderLeft_clicks = - (1234);
			_encoderRight_clicks = - (1234); 
			
			_LeftPower = GetPower(_encoderLeft_clicks, _CurrentMove._targetLeft_clicks);
			_RightPower = GetPower(_encoderRight_clicks, _CurrentMove._targetRight_clicks);
		}  while(_LeftPower !=0.0 && _RightPower !=0.0);
	}
	*/
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