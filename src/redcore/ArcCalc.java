package redcore;


public class ArcCalc {
	public double _left_mm;
	public double _right_mm;
	
	public Pose _pose1;
	public Pose _pose2;
	
	public double _turn_rad;
	
	public double _width;
	
	public void calc(Pose pose1, double _left_mm, double _right_mm) {
		_pose1 = pose1;
		_left_mm = l;
		_right_mm = r;
				
		find turn();
	}
	
	protected find turn() {
		_turn_rad = (_right_mm - _left_mm)/_width;
	}
}
