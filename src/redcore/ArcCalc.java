package redcore;


public class ArcCalc {
	
	public double _turn;
	public double _radius;
	public double _turn_rad;
	public double _width;
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
	public double _d_left_mm;
	public double _d_right_mm;
	public Pose _pose1;
	public Pose _pose2 = new Pose();
	
	protected double _radiusLeft_mm;
	public double _poseRadius_mm;
	public double _turn_radians;
	protected double _dirToCenter_radians;
	
	public void calc(Pose pose1, double distanceLeft_mm, double distanceRight_mm) {
		
		_pose1 = pose1;
		_d_left_mm = distanceLeft_mm;
		_d_right_mm = distanceLeft_mm;
		
		FindTurn();
		FindRadiusLeft();
		FindPoseRadius();
		FindCenter();
		
	}

	
	
	protected void FindTurn() {
		_turn_rad = (_d_right_mm - _d_left_mm) / EncConstants.Width;
		_pose2.vector = _pose1.vector + _turn_rad;
	}
	
	
	
	protected void FindRadiusLeft() {
		_R_left = (EncConstants.Width * _d_left_mm) / (_d_right_mm - _d_left_mm);
		
	}
	
	
	
	protected void FindPoseRadius() {
		_poseRadius_mm = _radiusLeft_mm + (EncConstants.Width * 0.5);
	}
	protected void FindCenter() {
		_dirToCenter_radians = _pose1.vector * 1.570796325794;
		
		_pose2.x = _pose1.x + (Math.cos(_dirToCenter_radians) * _poseRadius_mm);
		_pose2.y = _pose1.y + (Math.sin(_dirToCenter_radians) * _poseRadius_mm);
	}
	
	protected void FindPose() {
		
		_circ = 2 * Math.PI  * _radius;
		
		_d_left_mm = _turn * 2 * Math.PI * _R_left;
		
		_R_left = _d_left_mm / (_turn * 2 * Math.PI);
		
		_x = _i + (Math.cos(_turn_rad) * _Rpose);
		
		_y = _j + (Math.sin(_turn_rad) * _Rpose);
	}
	protected void FindTurn2() {
		
	_turn = (_d_right_mm - _d_left_mm) / (2 * Math.PI * _width);
	
	}
}
