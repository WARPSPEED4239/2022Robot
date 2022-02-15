package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.autonomous.AutonomousCommand;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.commands.ConveyorBeltSetSpeed;
import frc.robot.commands.DrivetrainArcadeDrive;
import frc.robot.commands.IntakeMotorsSetSpeed;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;


public class RobotContainer {

  private final XboxController mController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private final Joystick mJoystick = new Joystick(Constants.JOYSTICK_PORT);
  private final Drivetrain mDriveTrain = new Drivetrain();

  private SendableChooser<TargetTask> targetChooser = new SendableChooser<>();

  private final Intake mIntake = new Intake();
  private final ConveyorBelt mConveyorBelt = new ConveyorBelt();

  public RobotContainer() {
    
    mDriveTrain.setDefaultCommand(new DrivetrainArcadeDrive(mDriveTrain, mController));
    mIntake.setDefaultCommand(new IntakeMotorsSetSpeed(mIntake, 0.0));
	mConveyorBelt.setDefaultCommand(new ConveyorBeltSetSpeed(mConveyorBelt, 0.0));

    configureButtonBindings();

    targetChooser.setDefaultOption("Move Off Tarmac", TargetTask.MoveOffTarmac);
    targetChooser.addOption("Do Nothing", TargetTask.DoNothing);
    SmartDashboard.putData(targetChooser);
  }

  private void configureButtonBindings() {
		JoystickButton xButtonA, xButtonB, xButtonX, xButtonY, xButtonLeftBumper, xButtonRightBumper, xButtonLeftStick,
				xButtonRightStick;
		JoystickButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9,
				jButton10, jButton11, jButton12;

		xButtonA = new JoystickButton(mController, 1);
		xButtonB = new JoystickButton(mController, 2);
		xButtonX = new JoystickButton(mController, 3);
		xButtonY = new JoystickButton(mController, 4);
		xButtonLeftBumper = new JoystickButton(mController, 5);
		xButtonRightBumper = new JoystickButton(mController, 6);
		xButtonLeftStick = new JoystickButton(mController, 9);
		xButtonRightStick = new JoystickButton(mController, 10);

		jButton1 = new JoystickButton(mJoystick, 1);
		jButton2 = new JoystickButton(mJoystick, 2);
		jButton3 = new JoystickButton(mJoystick, 3);
		jButton4 = new JoystickButton(mJoystick, 4);
		jButton5 = new JoystickButton(mJoystick, 5);
		jButton6 = new JoystickButton(mJoystick, 6);
		jButton7 = new JoystickButton(mJoystick, 7);
		jButton8 = new JoystickButton(mJoystick, 8);
		jButton9 = new JoystickButton(mJoystick, 9);
		jButton10 = new JoystickButton(mJoystick, 10);
		jButton11 = new JoystickButton(mJoystick, 11);
		jButton12 = new JoystickButton(mJoystick, 12);

    	jButton3.whileHeld(new IntakeMotorsSetSpeed(mIntake, -1.0));
		jButton4.whileHeld(new IntakeMotorsSetSpeed(mIntake, 1.0));

		jButton3.whileHeld(new ConveyorBeltSetSpeed(mConveyorBelt, -1.0));
		jButton4.whileHeld(new ConveyorBeltSetSpeed(mConveyorBelt, 1.0));


  }

  public Command getAutonomousCommand() {

	TargetTask targetTask = targetChooser.getSelected();

    return new AutonomousCommand(targetTask, mDriveTrain);
  }
}
