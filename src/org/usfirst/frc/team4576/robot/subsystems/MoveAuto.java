package org.usfirst.frc.team4576.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

//enum ECommand {
//	eMove, eWait, eOpenTray
//}

public class MoveAuto extends Subsystem {
	public double _targetLclicks;
	public double _targetRclicks;
	// public ECommand _command;
	public double _seconds;

	public MoveAuto() {
	}

	public void Move(double targetLclicks, double targetRclicks,
			/* ECommand command, */ double seconds) {
		_targetLclicks = targetLclicks;
		_targetRclicks = targetRclicks;
		// _command = command;
		Timer.delay(seconds);
	}

	public void torricelliMove(double initialvelocity, double decelleration) {

	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	// TODO Auto-generated method stub

}
