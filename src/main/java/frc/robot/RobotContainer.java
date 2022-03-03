package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ConveyorBeltSetSpeed;
import frc.robot.commands.DrivetrainArcadeDrive;
import frc.robot.commands.DrivetrainNoSensors;
import frc.robot.commands.DrivetrainShifterSetState;
import frc.robot.commands.FeederWheelsSetSpeed;
import frc.robot.commands.IntakePistonsSetState;
import frc.robot.commands.IntakeSetSpeed;
import frc.robot.commands.LimelightDriversMode;
import frc.robot.commands.RampSetState;
import frc.robot.commands.ShooterSetSpeedThrottle;
import frc.robot.commands.automated.VisionTracking;
import frc.robot.commands.autonomous.AutonomousCommand;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.DrivetrainShifter;
import frc.robot.subsystems.FeederWheels;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.IntakePistons;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Ramp;
import frc.robot.subsystems.Shooter;

public class RobotContainer {
  private final XboxController mController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private final Joystick mJoystick = new Joystick(Constants.JOYSTICK_PORT);
  private SendableChooser<TargetTask> targetChooser = new SendableChooser<>();
  private final Drivetrain mDriveTrain = new Drivetrain();
  private final Intake mIntake = new Intake();
  private final ConveyorBelt mConveyorBelt = new ConveyorBelt();
  private final Shooter mShooter = new Shooter();
  private final FeederWheels mFeederWheels = new FeederWheels();
  private final IntakePistons mIntakePistons = new IntakePistons();
  private final Ramp mRamp = new Ramp();
  private final DrivetrainShifter mShifter = new DrivetrainShifter();
  private final Limelight mLimelight = new Limelight();

  public RobotContainer() {
    mDriveTrain.setDefaultCommand(new DrivetrainArcadeDrive(mDriveTrain, mController));
    mIntake.setDefaultCommand(new IntakeSetSpeed(mIntake, 0.0));
	mConveyorBelt.setDefaultCommand(new ConveyorBeltSetSpeed(mConveyorBelt, 0.0));
	mFeederWheels.setDefaultCommand(new FeederWheelsSetSpeed(mFeederWheels, 0.0));
	mShooter.setDefaultCommand(new ShooterSetSpeedThrottle(mShooter, mJoystick));

	mIntakePistons.setDefaultCommand(new IntakePistonsSetState(mIntakePistons, false));
	mRamp.setDefaultCommand(new RampSetState(mRamp, false));
	mShifter.setDefaultCommand(new DrivetrainShifterSetState(mShifter, false));
	mLimelight.setDefaultCommand(new LimelightDriversMode(mLimelight));

    configureButtonBindings();

    targetChooser.setDefaultOption("Do Nothing", TargetTask.DoNothing);
	//targetChooser.addOption("Move Off Tarmac", TargetTask.MoveOffTarmac);
	targetChooser.addOption("Move Backwards No Sensors", TargetTask.DriveBackwardsNoSensors);
	targetChooser.addOption("Shoot Move Backwards No Sensors", TargetTask.ShootDriveBackNoSensors);
    SmartDashboard.putData(targetChooser);
	
	UsbCamera cam0 = CameraServer.startAutomaticCapture();
	cam0.setResolution(320, 240);
	cam0.setFPS(10);
  }

  private void configureButtonBindings() {
		JoystickButton xButtonA, xButtonB, xButtonX, xButtonY, xButtonLeftBumper, xButtonRightBumper, xButtonLeftStick,
				xButtonRightStick;
		JoystickButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9,
				jButton10, jButton11;
			JoystickButton joyButton1, joyButton2, joyButton3, joyButton4, joyButton5, joyButton6, joyButton7, joyButton8, joyButton9,
				joyButton10, joyButton11;

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

		xButtonA.whenPressed(new DrivetrainShifterSetState(mShifter, false));
		xButtonB.whenPressed(new DrivetrainShifterSetState(mShifter, true));

		jButton1.whileHeld(new VisionTracking(mDriveTrain, mLimelight, mShooter, mController, mJoystick));
		jButton2.whileHeld(new RampSetState(mRamp, true));

    	jButton3.whileHeld(new IntakeSetSpeed(mIntake, -0.50));
		jButton4.whileHeld(new IntakeSetSpeed(mIntake, 0.50));

		jButton3.whileHeld(new ConveyorBeltSetSpeed(mConveyorBelt, -0.65));
		jButton4.whileHeld(new ConveyorBeltSetSpeed(mConveyorBelt, 0.65));

		jButton3.whileHeld(new FeederWheelsSetSpeed(mFeederWheels, -0.45));
		jButton4.whileHeld(new FeederWheelsSetSpeed(mFeederWheels, 0.45));

		jButton5.whenPressed(new IntakePistonsSetState(mIntakePistons, false));
		jButton6.whenPressed(new IntakePistonsSetState(mIntakePistons, true));

		// jButton7.whileHeld(new ClimberSetSpeed(mClimber, mJoystick, -1.0));
		// jButton8.whileHeld(new ClimberSetSpeed(mClimber, mJoystick, 1.0));
		// jButton12 is used to toggle manual control for vison tracking in VisionTracking.java
  }

  public Command getAutonomousCommand() {
	TargetTask targetTask = targetChooser.getSelected();

    return new AutonomousCommand(targetTask, mDriveTrain, mLimelight, mShooter, mRamp);
  }
}

