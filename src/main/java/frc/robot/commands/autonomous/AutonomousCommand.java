package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.subsystems.Drivetrain;

public class AutonomousCommand extends SequentialCommandGroup {
  
  public AutonomousCommand(TargetTask targetTask, Drivetrain drivetrain) {
    super();

    switch (targetTask) {
      case MoveOffTarmac:
        addCommands(new MoveOffTarmac(drivetrain));
        break;
      case DoNothing:
        addCommands(new WaitCommand(15.0));
        break;
      default:
        addCommands(new WaitCommand(15.0));
        break;
      }
  }
}
