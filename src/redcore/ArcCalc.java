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
		
		FindTurn();
		FindDleft();
		FindDright();
	}
	
	protected void FindDleft() {
		_dleft = 2 * 3.1415926536 * _radius;
	}
	
	protected void FindDright() {
		_dright = 2 * 3.1415926536 * (_radius + _width);
	}
	
	protected void FindTurn() {
		_turn_rad = (_dright - _dleft) / _width;
	}
}
