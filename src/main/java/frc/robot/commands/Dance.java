package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IntakePistons;

public class Dance extends CommandBase {
  private final Drivetrain mDrivetrain;
  private final IntakePistons mIntakePistons;
  private final Timer mMotorTimer;
  private final Timer mPistonTimer;

  public Dance(Drivetrain drivetrain, IntakePistons intakePistons) {
    mDrivetrain = drivetrain;
    mIntakePistons = intakePistons;
    mMotorTimer = new Timer();
    mPistonTimer = new Timer();
    addRequirements(mDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mMotorTimer.stop();
    mMotorTimer.reset();
    mPistonTimer.stop();
    mPistonTimer.reset();

    mMotorTimer.start();
    mPistonTimer.start();

    
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double motorTime = mMotorTimer.get();
    double pistonTime = mPistonTimer.get();
    if(motorTime < 0.5 ) {
      mDrivetrain.DrivetrainArcadeDrive(-0.85, 0.85);
    } else if(motorTime > 0.5) {
      mDrivetrain.DrivetrainArcadeDrive(0.85, -0.85);
  
    } else if(motorTime > 1) {
      mMotorTimer.reset();
    }

    if(pistonTime < 4.0) {
      mIntakePistons.setPistonsState(true);
    } else if(pistonTime > 4.0) {
      mIntakePistons.setPistonsState(false);
    } else if(pistonTime > 8.0) {
      mPistonTimer.reset();
    }
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
