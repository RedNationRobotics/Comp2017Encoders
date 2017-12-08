package org.usfirst.frc.team4576.robot;

import org.usfirst.frc.team4576.robot.commands.Agitate;
import org.usfirst.frc.team4576.robot.commands.Climb;
import org.usfirst.frc.team4576.robot.commands.ClimbReverse;
import org.usfirst.frc.team4576.robot.commands.Fire;
import org.usfirst.frc.team4576.robot.commands.Gear;
import org.usfirst.frc.team4576.robot.commands.Shift;
import org.usfirst.frc.team4576.robot.commands.Shoot;
import org.usfirst.frc.team4576.robot.commands.ToggleCompressor;
//import org.usfirst.frc.team4576.robot.commands.ToggleFlashlight;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

// Button Values:
//
// 1: A
// 2: B
// 3: X
// 4: Y
// 5: Left Bumper
// 6: Right Bumper
// 7: Back
// 8: Start
// 9: Left Joystick pressed down
// 10: Right Joystick pressed down
//
//
// Axis values:
//
// 1 - LeftX
// 2 - LeftY
// 3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
// 4 - RightX 
// 5 - RightY
// 6 - DPad Left/Right
public class OI {
	Button dsA = new JoystickButton(Robot.driveStick, 1);
	Button dsB = new JoystickButton(Robot.driveStick, 2);
	Button dsX = new JoystickButton(Robot.driveStick, 3);
	Button dsY = new JoystickButton(Robot.driveStick, 4);
	Button dsBACK = new JoystickButton(Robot.driveStick, 7);
	Button dsSTART = new JoystickButton(Robot.driveStick, 8);
	
	Button ssA = new JoystickButton(Robot.secondaryStick, 1);
	Button ssRPRESS = new JoystickButton(Robot.secondaryStick, 10);
	Button ssY = new JoystickButton(Robot.secondaryStick, 4);
	Button ssLB = new JoystickButton(Robot.secondaryStick, 5);
	Button ssRB = new JoystickButton(Robot.secondaryStick, 6);
	Button ssBACK = new JoystickButton(Robot.secondaryStick, 7);

	public OI() {
		dsX.whenPressed(new Shift(true));
		dsA.whenPressed(new Shift(false));
		dsSTART.whenPressed(new ToggleCompressor());

		dsY.whenPressed(new Gear());
		//dsB.whenPressed(new ToggleFlashlight());
		
		
		ssA.whileHeld(new Agitate(true));
		ssA.whenReleased(new Agitate(false));
		ssLB.whenPressed(new Fire());
		ssRB.whileHeld(new Shoot(true));
		ssRB.whenReleased(new Shoot(false));
		ssY.whileHeld(new Climb(true));
		ssY.whenReleased(new Climb(false));
		ssBACK.whileHeld(new ClimbReverse(true));
		ssBACK.whenReleased(new ClimbReverse(false));

	}
}