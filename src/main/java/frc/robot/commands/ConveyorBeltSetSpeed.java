package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ConveyorBelt;

public class ConveyorBeltSetSpeed extends CommandBase {

  private final ConveyorBelt mConveyorBelt;
  private final double mSpeed;
  
  public ConveyorBeltSetSpeed(ConveyorBelt conveyorBelt, double speed) {

    mConveyorBelt = conveyorBelt;
    mSpeed = speed;

    addRequirements(mConveyorBelt);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    mConveyorBelt.ConveyorBeltSetSpeed(mSpeed);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
