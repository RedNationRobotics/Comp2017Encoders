package redcore;


public class ArcCalc {
	public double Pie = 3.1415926536;
	
	public double _left_mm;
	public double _right_mm;
	
	public Pose _pose1;
	public Pose _pose2;
	
	public double _radius;
	public double _turn_rad;
	public double _width;
	public double _dleft;
	public double _dright;
	public double _dir_to_center;
	public double _sx;
	public double _sy;
	public double _x;
	public double _y;
	public double _i;
	public double _j;
	public double _R_left;
	public double _R_right;
	public double _circ = 2 * Pie * _radius;
	public double _Rpose;
	
	
	public void calc(Pose pose1, double _left_mm, double _right_mm) {
		_pose1 = pose1;
		
		FindTurn();
		FindDleft();
		FindDright();
		FindCenter();
		
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
	
	
	protected void FindPose() {
		_x = _i + (Math.cos(_turn_rad) * _Rpose);
		_y = _j + (Math.sin(_turn_rad) * _Rpose);
	}
	
	
	protected void FindCenter() {
		_R_left = _dleft / (_turn_rad * 2 * Math.PI);
		_i = _sx + (Math.cos(_dir_to_center)* _Rpose);
		_j = _sy + (Math.sin(_dir_to_center)* _Rpose);
	}
	
	
	protected void FindRpose() {
		_Rpose = _R_left + (_width / 2);
	}
		
}
