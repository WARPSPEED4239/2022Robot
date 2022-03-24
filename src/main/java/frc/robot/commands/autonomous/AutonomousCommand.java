package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ConveyorBeltSetSpeed;
import frc.robot.commands.DrivetrainNoSensors;
import frc.robot.commands.DrivetrainShifterSetState;
import frc.robot.commands.RampSetState;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.DrivetrainShifter;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Ramp;
import frc.robot.subsystems.Shooter;

public class AutonomousCommand extends SequentialCommandGroup {
  private final TargetTask mTargetTask;
  private final ConveyorBelt mConveyorBelt;
  private final Drivetrain mDrivetrain;
  private final DrivetrainShifter mDrivetrainShifter;
  private final Limelight mLimelight;
  private final Shooter mShooter;
  private final Ramp mRamp;

  public AutonomousCommand(TargetTask targetTask, ConveyorBelt conveyorBelt, Drivetrain drivetrain, DrivetrainShifter shifter, Limelight limelight, Shooter shooter, Ramp ramp) {
    super();

    mTargetTask = targetTask;
    mConveyorBelt = conveyorBelt;
    mDrivetrain = drivetrain;
    mDrivetrainShifter = shifter;
    mLimelight = limelight;
    mShooter = shooter;
    mRamp = ramp;

    switch (mTargetTask) {
      case MoveOffTarmac:
        //addCommands(new DrivetrainDriveDistance(drivetrain, UnitConversion.convertFeetToMeters(-7.5)));
        break;
      case DriveBackwardsNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(mDrivetrain, -0.75, 0.0),
                                          new DrivetrainShifterSetState(shifter, true), 
                                          new WaitCommand(1.0)));
        break;
      case DriveBackAndShootNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(mDrivetrain, -0.75, 0.18),
                                          new DrivetrainShifterSetState(mDrivetrainShifter, true),
                                          new WaitCommand(1.0)),
                    new ParallelRaceGroup(new VisionTrackingAuto(mDrivetrain, mLimelight, mShooter),
                                          new ConveyorBeltSetSpeed(mConveyorBelt, -0.4),
                                          new WaitCommand(5.0)),
                    new ParallelRaceGroup(new VisionTrackingAuto(mDrivetrain, mLimelight, mShooter),
                                          new RampSetState(mRamp, true),
                                          new WaitCommand(1.0)));
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