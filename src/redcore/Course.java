package redcore;

import java.util.concurrent.Callable;

public class Course implements Runnable {
	
	protected Thread _Thread;
	protected double _ControllerLeftRight; 
	protected boolean _Stop = false;
	public double _Course = 0.0;
	protected double _Max_deg_per_sec = 382.3;
	protected double _UpdateFrequency_Hz = 100.0;
	protected double MaxRateOfChange_deg_per_Hz = _Max_deg_per_sec / _UpdateFrequency_Hz;
	protected Callable<Double> _GetLeftRightFunction;
	
	public interface RobotInterface {
		double FetchJoystickLeftRight();
	}
	
	protected RobotInterface _robotInterface;
	
	public Course(RobotInterface robotInterface) {
		_robotInterface = robotInterface;
	}
	
	public void Demo() {
		double lr = _robotInterface.FetchJoystickLeftRight();
		System.out.println(lr);
	}
	
	public Course(Callable<Double> GetLeftRightFunction) {
		_GetLeftRightFunction = GetLeftRightFunction;
	}
	

	public void ControllerValue(double ControllerLeftRight) {
		_ControllerLeftRight = ControllerLeftRight;
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
		try {
			_ControllerLeftRight = _GetLeftRightFunction.call();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_Course += _ControllerLeftRight * MaxRateOfChange_deg_per_Hz;
		if(_Course < 0) _Course += 360.0;
		if(_Course >= 360.0) _Course -= 360.0;
		
	}
	
	public void WaitTiming() {
		Thread.sleep((long) (1000 / _UpdateFrequency_Hz));
	}
	
	
	
}
