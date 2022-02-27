package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberPistons;

public class ClimberPistonsSetState extends CommandBase {
  
  private final ClimberPistons mClimberPistons;
  private final boolean mPistonState;

  public ClimberPistonsSetState(ClimberPistons climberPistons, boolean pistonState) {
    mClimberPistons = climberPistons;
    mPistonState = pistonState;
    addRequirements(mClimberPistons);
  }

  @Override
  public void initialize() {
    mClimberPistons.setPistonsState(mPistonState);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
