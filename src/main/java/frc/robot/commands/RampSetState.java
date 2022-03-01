package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Ramp;

public class RampSetState extends CommandBase {

  private final Ramp mRamp;
  private final boolean mPistonState;
  
  public RampSetState(Ramp ramp, boolean pistonState) {
    mRamp = ramp;
    mPistonState = pistonState;
    addRequirements(mRamp);
  }

  @Override
  public void initialize() {
    mRamp.setPistonState(mPistonState);
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
