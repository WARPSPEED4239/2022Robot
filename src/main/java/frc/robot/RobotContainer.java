package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DrivetrainArcadeDrive;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {

  private final XboxController mController = new XboxController(Constants.XBOX_CONTROLLER_PORT);
  private final Drivetrain mDriveTrain = new Drivetrain();

  public RobotContainer() {
    
    mDriveTrain.setDefaultCommand(new DrivetrainArcadeDrive(mDriveTrain, mController));

    configureButtonBindings();
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
    return null;
  }













































}//class
