package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainDriveDistance extends CommandBase {
  
  Drivetrain mDrivetrain;
  double mDistanceInMeters;

  public DrivetrainDriveDistance(Drivetrain drivetrain, double distanceInMeters) {
    mDrivetrain = drivetrain;
    mDistanceInMeters = distanceInMeters;
    addRequirements(mDrivetrain);
  }

  @Override
  public void initialize() {
    mDrivetrain.resetEncoders();
  }
  
  @Override
  public void execute() {
    mDrivetrain.setPositionFeet(mDistanceInMeters);
    
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
