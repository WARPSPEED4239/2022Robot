
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterSetSpeed extends CommandBase {
  
  private final Shooter mShooter;
  private final double mSpeed;

  public ShooterSetSpeed(Shooter shooter, double speed) {

    mShooter = shooter;
    mSpeed = speed;
    addRequirements(mShooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mShooter.ShooterSetSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
