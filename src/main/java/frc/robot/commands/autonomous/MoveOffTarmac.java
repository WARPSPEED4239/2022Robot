package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.tools.UnitConversion;

public class MoveOffTarmac extends CommandBase {
  
  Drivetrain mDrivetrain;
  double distanceToMoveOffTarmac = UnitConversion.convertInchesToFeet(130);

  public MoveOffTarmac(Drivetrain drivetrain) {
    mDrivetrain = drivetrain;
    addRequirements(mDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mDrivetrain.resetEncoders();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mDrivetrain.setPositionFeet(-distanceToMoveOffTarmac);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
