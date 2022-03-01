package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DrivetrainNoSensors extends CommandBase {
 
  private final Drivetrain mDrivetrain;
  private double mMove;
  private double mRotate;
  

  public DrivetrainNoSensors(Drivetrain drivetrain, double move, double rotate) {
    mMove = move;
    mRotate = rotate;
    mDrivetrain = drivetrain;
    addRequirements(mDrivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mDrivetrain.DrivetrainArcadeDrive(mMove, mRotate);
  }

  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
