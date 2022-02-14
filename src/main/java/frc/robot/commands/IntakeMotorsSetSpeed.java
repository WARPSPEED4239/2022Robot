package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeMotorsSetSpeed extends CommandBase {
  
  private double mSpeed;
  private final Intake mIntake;

  public IntakeMotorsSetSpeed(Intake intake, double speed) {

    mIntake = intake;
    mSpeed = speed;
    addRequirements(mIntake);
  }
  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mIntake.setPercentOutput(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
