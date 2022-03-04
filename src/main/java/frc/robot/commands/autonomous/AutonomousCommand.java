package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DrivetrainNoSensors;
import frc.robot.commands.RampSetState;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Ramp;
import frc.robot.subsystems.Shooter;

public class AutonomousCommand extends SequentialCommandGroup {
  
  public AutonomousCommand(TargetTask targetTask, Drivetrain drivetrain, Limelight limelight, Shooter shooter, Ramp ramp) {
    super();

    switch (targetTask) {
      case MoveOffTarmac:
        //addCommands(new DrivetrainDriveDistance(drivetrain, UnitConversion.convertFeetToMeters(-7.5)));
        break;
      case DriveBackwardsNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(drivetrain, -0.75, 0.0), 
                                          new WaitCommand(2.5)));
        break;
      case ShootDriveBackNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(drivetrain, -0.75, 0.0), 
                                          new WaitCommand(1.0)),
                    new ParallelRaceGroup(new VisionTrackingAuto(drivetrain, limelight, shooter),
                                          new WaitCommand(2.5)),
                    new ParallelRaceGroup(new VisionTrackingAuto(drivetrain, limelight, shooter),
                                          new RampSetState(ramp, true),
                                          new WaitCommand(1.0)),
                    new ParallelRaceGroup(new DrivetrainNoSensors(drivetrain, -0.75, 0.0), 
                                          new WaitCommand(1.5)));
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