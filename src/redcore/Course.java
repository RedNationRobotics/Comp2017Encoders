package redcore;

import java.util.concurrent.Callable;


public class Course implements Runnable {
	
	protected Thread _Thread;
	protected double _ControllerLeftRight = 0.0; 
	protected boolean _Stop = false;
	public double _Kp = 0.0;
	public double _Kj = 0.0;
	public double _Heading = 0.0;
	public double _Course_ = 0.0;
	public double _Course_Error = 0.0;
	public double _Course_Correction = 0.0;
	protected double _Max_deg_per_sec = 382.3;
	protected double _UpdateFrequency_Hz = 100.0;
	protected double _360_Turn_per_sec = .942408377;
	protected double MaxRateOfChange_deg_per_Hz = _Max_deg_per_sec / _UpdateFrequency_Hz;
	protected Callable<Double> _GetLeftRightFunction;
	
	public interface RobotInterface {
		double FetchJoystickLeftRight();
	};
	
	protected RobotInterface _robotInterface;
	
	public Course(RobotInterface robotInterface) {
		_robotInterface = robotInterface;
		_Thread = new Thread(this);
	}
	
	public void Demo() {
		double lr = _robotInterface.FetchJoystickLeftRight();
		System.out.println(lr);
	}
	

	public void ControllerValue(double ControllerLeftRight) {
		_ControllerLeftRight = ControllerLeftRight;
	}
	
	public void CalcCourseThread() {
		_Thread.start();
	}
	
	public void Stop() {
		_Stop = true;
	}

	public void run() {
		System.out.println("Clac thread started");
		_Course_ = 0.0;
		while(!_Stop) {
			ComputeCourseError();
			WaitTiming();
		}
		System.out.println("Calc thread existing");
	}
	
	public double ComputeCourseError() {
		try {
			_ControllerLeftRight = _GetLeftRightFunction.call();
	} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		//Sets range logic for Course leading to an output of 0 to 360 and also states what the new course will be
		_Course_ += _robotInterface.FetchJoystickLeftRight() * MaxRateOfChange_deg_per_Hz;
		if(_Course_ < 0) _Course_ += 360.0;
		if(_Course_ >= 360.0) _Course_ -= 360.0;
		
		//Sets range logic for Course Error leading to an output of -180 to 180
		if(_Course_Error > 180) _Course_Error -= 360;
		if(_Course_Error < -180) _Course_Error += 360;
		
		//Sets Wobble mode range logic leading to an output of -1.0 to 1.0
		_Course_Correction = _Course_Error * _Kp;
		if(_Course_Correction < -1.0) _Course_Correction -= 1.0;
		if(_Course_Correction > 1.0) _Course_Correction += 1.0;
		
		_Course_Error = _Course_ - _Heading;
		_Kj = (360 * _360_Turn_per_sec) / 1000;
		_Course_ = _Course_ + (_ControllerLeftRight * _Kj);
		
		return _Course_;
		
}
	
	public void WaitTiming() {
		try {
			Thread.sleep((long) (1000 / _UpdateFrequency_Hz));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
