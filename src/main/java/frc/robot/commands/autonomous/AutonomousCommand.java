package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DrivetrainNoSensors;
import frc.robot.commands.IntakeSetSpeed;
import frc.robot.commands.RampSetState;
import frc.robot.commands.autonomous.SendableChoosers.TargetTask;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Ramp;
import frc.robot.subsystems.Shooter;

public class AutonomousCommand extends SequentialCommandGroup {
  private final TargetTask mTargetTask;
  private final Drivetrain mDrivetrain;
  private final Limelight mLimelight;
  private final Shooter mShooter;
  private final Ramp mRamp;
  private final Intake mIntake;

  public AutonomousCommand(TargetTask targetTask, Drivetrain drivetrain, Limelight limelight, Shooter shooter, Ramp ramp, Intake intake) {
    super();

    mTargetTask = targetTask;
    mDrivetrain = drivetrain;
    mLimelight = limelight;
    mShooter = shooter;
    mRamp = ramp;
    mIntake = intake;

    switch (mTargetTask) {
      case MoveOffTarmac:
        //addCommands(new DrivetrainDriveDistance(drivetrain, UnitConversion.convertFeetToMeters(-7.5)));
        break;
      case DriveBackwardsNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(mDrivetrain, -0.75, 0.0), 
                                          new WaitCommand(1.0)));
        break;
      case DriveBackAndShootNoSensors:
        addCommands(new ParallelRaceGroup(new DrivetrainNoSensors(mDrivetrain, -0.75, 0.18), 
                                          new WaitCommand(1.0)),
                    new ParallelRaceGroup(new VisionTrackingAuto(mDrivetrain, mLimelight, mShooter),
                                          new IntakeSetSpeed(mIntake, .55),
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