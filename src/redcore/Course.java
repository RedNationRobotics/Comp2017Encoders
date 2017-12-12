package redcore;

import org.usfirst.frc.team4576.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Course implements Runnable {
	
	protected Thread _Thread;
	protected double _ControllerLeftRight; 
	protected Control _Controller = new Control();
	protected boolean _Stop = false;
	public double _Course = 0.0;
	protected double _Max_deg_per_sec = 382.3;
	protected double _UpdateFrequency_Hz = 100.0;
	protected double MaxRateOfChange_deg_per_Hz = _Max_deg_per_sec / _UpdateFrequency_Hz;
	
	public void ControllerValue() {
		_ControllerLeftRight = Robot.driveStick.getRawAxis(4);
		
	}
	
	public void CalcCourseThread() {
		Thread.start();
	}
	
	public void Stop() {
		_Stop = true;
	}

	public void run() {
		System.out.println("Clac thread started");
		_Course = 0.0;
		while(!_Stop) {
			ComputeCourseError();
			WaitTiming();
		}
		System.out.println("Calc thread existing");
	}
	
	public void ComputeCourseError() {
		_ControllerLeftRight = (_Controller.nextDouble() * 2.0) - 1.0;
		_Course += _ControllerLeftRight * MaxRateOfChange_deg_per_Hz;
		if(_Course < 0) _Course += 360.0;
		if(_Course >= 360.0) _Course -= 360.0;
	}
	
	public void WaitTiming() {
		Thread.sleep((long) (1000 / _UpdateFrequency_Hz));
	}
	
	
	
}
