package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeSetSpeed extends CommandBase {
  
  private final Intake mIntake;
  private final double mSpeed;

  public IntakeSetSpeed(Intake intake, double speed) {

    mIntake = intake;
    mSpeed = speed;
    addRequirements(mIntake);
  }
  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mIntake.IntakeSetSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
