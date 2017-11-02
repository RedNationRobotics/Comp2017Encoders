package redcore;


public class ArcCalc {
	
	public double _left_mm;
	public double _right_mm;
	
	
	public Pose _pose2 = new Pose();
	
	public double _turn;
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
	public double _circ;
	public double _Rpose;
	
	
	public void calc(Pose pose1, double _left_mm, double _right_mm) {
		
		FindTurn();
		FindDleft();
		FindDright();
		FindCenter();
		
	}
	
	
	
	protected void FindDleft() {
		
		_dleft = (int) (2 * Math.PI * _radius);
	}
	
	
	
	protected void FindDright() {
		
		_dright = 2 * Math.PI * (_radius + _width);
	}
	
	
	
	protected void FindTurnRadians() {
		
		_turn_rad = (_dright - _dleft) / _width;
	}
	protected void FindCenter() {
		
		_i = _sx + (Math.cos(_dir_to_center)* _Rpose);
		
		_j = _sy + (Math.sin(_dir_to_center)* _Rpose);
		
		
		
	}
	
	protected void FindPose() {
		
		_circ = 2 * Math.PI  * _radius;
		
		_dleft = _turn * 2 * Math.PI * _R_left;
		
		_R_left = _dleft / (_turn * 2 * Math.PI);
		
		_x = _i + (Math.cos(_turn_rad) * _Rpose);
		
		_y = _j + (Math.sin(_turn_rad) * _Rpose);
		
ArcCalc a = new ArcCalc();
		
		Pose pose1 = new Pose();
		
		pose1.x = 2.3;
		pose1.y = 5.2;
		pose1.vector = 1.5707963268;
		
		a.calc(pose1, 123, 134);
		
		_pose2.x = 0.0;
		_pose2.y = 0.0;
		_pose2.vector = 1.5707963268 + _turn_rad;
		
	}
	protected void FindTurn() {
		
	_turn = (_dright - _dleft) / (2 * Math.PI * _width);
	
	}
}
