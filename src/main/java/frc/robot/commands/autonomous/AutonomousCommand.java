package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DrivetrainNoSensors;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.subsystems.Drivetrain;
import frc.robot.tools.UnitConversion;

public class AutonomousCommand extends SequentialCommandGroup {
  
  public AutonomousCommand(TargetTask targetTask, Drivetrain drivetrain) {
    super();

    switch (targetTask) {
      case MoveOffTarmac:
        addCommands(new DrivetrainDriveDistance(drivetrain, UnitConversion.convertFeetToMeters(-7.5)));
        break;
      case DriveBackwardsNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(drivetrain, -0.5, 0.0), 
                                          new WaitCommand(2)));
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