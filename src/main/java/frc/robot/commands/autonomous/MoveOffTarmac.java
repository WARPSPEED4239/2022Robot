package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.tools.UnitConversion;

public class MoveOffTarmac extends CommandBase {
  
  Drivetrain mDrivetrain;
  double distanceToMoveOffTarmac = UnitConversion.convertInchesToFeet(100);

  public MoveOffTarmac(Drivetrain drivetrain) {
    mDrivetrain = drivetrain;
    addRequirements(mDrivetrain);
  }

  @Override
  public void initialize() {
    mDrivetrain.resetEncoders();
  }
  
  @Override
  public void execute() {
    mDrivetrain.setPositionFeet(-distanceToMoveOffTarmac);
    
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
