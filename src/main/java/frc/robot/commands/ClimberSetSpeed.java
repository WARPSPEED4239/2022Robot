package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberSetSpeed extends CommandBase {
  
  private final Climber mClimber;
  private final double mSpeed;

  public ClimberSetSpeed(Climber climber, double speed) {

    mClimber = climber;
    mSpeed = speed;
    addRequirements(mClimber);
  }
  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mClimber.ClimberSetSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
