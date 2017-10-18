package redcore;


public class ArcCalc {
	public double _left_mm;
	public double _right_mm;
	
	public Pose _pose1;
	public Pose _pose2;
	
	public double _radius;
	public double _turn_rad;
	public double _width;
	public double _dleft;
	public double _dright;
	
	
	
	public void calc(Pose pose1, double _left_mm, double _right_mm) {
		_pose1 = pose1;
		
		find dright();
		find dleft();		
		find turn();
	}
	
	protected find dleft() {
		_dleft = 2 * 3.1415926536 * _radius;
	}
	
	protected find dright() {
		_dright = 2 * 3.1415926536 * (_radius + _width);
	}
	
	protected void find turn() {
		_turn_rad = (_dright - _dleft) / _width;
	}
