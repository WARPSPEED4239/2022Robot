
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakePistons;

public class IntakePistonsSetState extends CommandBase {
  
  private final IntakePistons mIntakePistons;
  private final boolean mPistonState;

  public IntakePistonsSetState(IntakePistons intakePistons, boolean pistonState) {
    mIntakePistons = intakePistons;
    mPistonState = pistonState;
    addRequirements(mIntakePistons);
  }

  @Override
  public void initialize() {
    mIntakePistons.setPistonsState(mPistonState);
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
