package redcore;


public class Test {
	void main() {
		ArcCalc a = new ArcCalc();
		Pose pose1 = new Pose();
		
		pose1.x = 0.0;
		pose1.y = 0.0;
			
		pose1.vector = 1.5707963268;
		
		a.calc(pose1, 123, 134);
		
	}
}
