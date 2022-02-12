package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.autonomous.AutonomousCommand;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.commands.DrivetrainArcadeDrive;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {

  private final XboxController mController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private final Drivetrain mDriveTrain = new Drivetrain();

  private SendableChooser<TargetTask> targetChooser = new SendableChooser<>();

  public RobotContainer() {
    
    mDriveTrain.setDefaultCommand(new DrivetrainArcadeDrive(mDriveTrain, mController));

    configureButtonBindings();

    targetChooser.setDefaultOption("Move Off Tarmac", TargetTask.MoveOffTarmac);
    targetChooser.addOption("Do Nothing", TargetTask.DoNothing);
    SmartDashboard.putData(targetChooser);
  }

  private void configureButtonBindings() {
    JoystickButton xButtonA = new JoystickButton(mController, 1);
    JoystickButton xButtonB = new JoystickButton(mController, 2);
    JoystickButton xButtonX = new JoystickButton(mController, 3);
    JoystickButton xButtonY = new JoystickButton(mController, 4);
    JoystickButton xButtonRightBumper = new JoystickButton(mController, 5);
    JoystickButton xButtonLeftBumper = new JoystickButton(mController, 6);

  }

  public Command getAutonomousCommand() {

		TargetTask targetTask = targetChooser.getSelected();

    return new AutonomousCommand(targetTask, mDriveTrain);
  }
}
