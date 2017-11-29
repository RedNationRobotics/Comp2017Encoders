package redcore;

public class Course implements Runnable{
	
	protected Thread _Thread;
	protected double _ControllerLeftRight = 0.0;
	protected Control _Controller = new Control();
	//The object control has yet to be created
	protected boolean _Stop = false;
	public double _Course = 0.0;
	protected double _Max_deg_per_sec = 1.7;
	//Number needs to be updated
	protected double _UpdateFrequency_Hz = 100.0;
	protected double MaxRateOfChange_deg_per_Hz = _Max_deg_per_sec / _UpdateFrequency_Hz;
	
	public void CalcCourseThread() {
		Thread t = new Thread();
		Thread.start();
	}
	
	public void Stop() {
		_Stop = true;
		while(_Thread.isAlive()) WaitTiming();
	}

	public void run() {
		System.out.println("Clac thread startd");
		_Course = 0.0;
		while(!_Stop) {
			ComputeCourse();
			WaitTiming();
		}
		System.out.println("Calc thread existing");
	}
	
	protected void ComputeCourse() {
		_ControllerLeftRight = (_Controller.nextDouble() * 2.0) - 1.0;
		_Course += _ControllerLeftRight * MaxRateOfChange_deg_per_Hz;
		if(_Course < 0) _Course += 360.0;
		if(_Course >= 360.0) _Course -= 360.0;
	}
	
	protected void WaitTiming() {
		try {
			Thread.sleep((long) (1000 / _UpdateFrequency_Hz)); 
		}
		
		catch (InterruptedExcpeption e) {
			e.printStackTrace();
		}
	}
}
