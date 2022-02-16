
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeederWheels;

public class FeederWheelsSetSpeed extends CommandBase {
  
  private final FeederWheels mFeederWheels;
  private final double mSpeed;

  public FeederWheelsSetSpeed(FeederWheels feederWheels, double speed) {
    mFeederWheels = feederWheels;
    mSpeed = speed;
    addRequirements(mFeederWheels);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mFeederWheels.FeederWheelsSetSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
