package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutonomousCommand extends CommandBase {
  
  private final Drivetrain mDrivetrain;
  private final double mPositionInMeters;

  public AutonomousCommand(Drivetrain drivetrain, double positionInMeters) {

    mDrivetrain = drivetrain;
    mPositionInMeters = positionInMeters;
    addRequirements(mDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mDrivetrain.resetEncoders();
    mDrivetrain.setPosition(mPositionInMeters);
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
