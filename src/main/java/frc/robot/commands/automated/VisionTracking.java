package frc.robot.commands.automated;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class VisionTracking extends CommandBase {
  
  private final Drivetrain mDrivetrain;
  private final Limelight mLimelight;
  private final Shooter mShooter;
  private final XboxController mController;
  private final Joystick mJoystick;

  private final double kPDrivetrain = 0.03; // TODO TUNE
  private final double kHeightOfGoalInches = 103.0;
  private final double kHeightOfLimelightInches = 26.5;
  private final double kAngleOfLimelightDegrees = 28.77;

  public VisionTracking(Drivetrain drivetrain, Limelight limelight, Shooter shooter, XboxController controller, Joystick joystick) {
    mDrivetrain = drivetrain;
    mLimelight = limelight;
    mShooter = shooter;
    mController = controller;
    mJoystick = joystick;
    addRequirements(mDrivetrain, mLimelight);
  }

  @Override
  public void initialize() {
    mLimelight.setCamMode(0);
    mLimelight.setPipeline(1);
    mLimelight.setLEDMode(3);
  }

  @Override
  public void execute() {
    double tv = mLimelight.getTv();

    if (tv == 1 && !mJoystick.getRawButton(12)) { // Hold Button 12 on Joystick to disable vision tracking
      double move;
      double rotate;
      double tx = mLimelight.getTx();
      double ty = mLimelight.getTy();
      double distanceToGoal = ((kHeightOfGoalInches - kHeightOfLimelightInches) / (Math.tan(Math.toRadians(kAngleOfLimelightDegrees)  + Math.toRadians(ty)))); // TODO Maybe fix this calculation
      SmartDashboard.putNumber("distance", distanceToGoal);

      if (Math.abs(tx) < 0.5) {
          rotate = 0.0;
      } else {
        rotate = kPDrivetrain * tx;
      }
      move = mController.getRightTriggerAxis() - mController.getLeftTriggerAxis();
      mDrivetrain.DrivetrainArcadeDrive(move, rotate);

      // 2700 RPM at 12 feet
      // 3700 RPM at 17 feet
      // RPM = (constant * distance) + offset
      // double RPM = 3400;
      double RPM = (12.76 * distanceToGoal) + 1500;
      SmartDashboard.putNumber("RPM", RPM);
      mShooter.setVelocity(RPM);
    } else {
      double move = mController.getRightTriggerAxis() - mController.getLeftTriggerAxis();
      double rotate = (.533333 * Math.pow(mController.getLeftX(), 3) + .466666 * mController.getLeftX());
      mDrivetrain.DrivetrainArcadeDrive(move, rotate);

      double speedFromJoystick = mJoystick.getThrottle(); // 1 to -1
      speedFromJoystick *= -1;                            // -1 to 1
      speedFromJoystick += 1;                             // 0 to 2
      speedFromJoystick *= 0.5;                           // 0 to 1
      mShooter.ShooterSetSpeed(speedFromJoystick);
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}