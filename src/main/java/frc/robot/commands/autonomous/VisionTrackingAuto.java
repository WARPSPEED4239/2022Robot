package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;

public class VisionTrackingAuto extends CommandBase {
  
  private final Drivetrain mDrivetrain;
  private final Limelight mLimelight;
  private final Shooter mShooter;

  private final double kPDrivetrain = 0.03;
  private final double kHeightOfGoalInches = 103.0;
  private final double kHeightOfLimelightInches = 26.5;
  private final double kAngleOfLimelightDegrees = 28.77;

  public VisionTrackingAuto(Drivetrain drivetrain, Limelight limelight, Shooter shooter) {
    mDrivetrain = drivetrain;
    mLimelight = limelight;
    mShooter = shooter;
    addRequirements(mDrivetrain, mLimelight, mShooter);
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
    SmartDashboard.putNumber("tv", tv);

    if (tv == 1) {
      double rotate;
      double tx = mLimelight.getTx();
      double ty = mLimelight.getTy();
      double distanceToGoal = ((kHeightOfGoalInches - kHeightOfLimelightInches) / (Math.tan(Math.toRadians(kAngleOfLimelightDegrees)  + Math.toRadians(ty))));
      SmartDashboard.putNumber("distance", distanceToGoal);

      if (Math.abs(tx) < 0.5) {
          rotate = 0.0;
      } else {
        rotate = kPDrivetrain * tx;
      }
    
      mDrivetrain.DrivetrainArcadeDrive(0.0, rotate);

      // 2700 RPM at 12 feet
      // 3700 RPM at 17 feet
      // RPM = (constant * distance) + offset
      double RPM = (12.76 * distanceToGoal) + 1550;
      //double RPM = 2975;
      SmartDashboard.putNumber("RPM", RPM);
      mShooter.setVelocity(RPM);
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