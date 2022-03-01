package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterSetSpeedThrottle extends CommandBase {
  
  private final Shooter mShooter;
  private final Joystick mJoystick;

  public ShooterSetSpeedThrottle(Shooter shooter, Joystick joystick) {
    mShooter = shooter;
    mJoystick = joystick;
    addRequirements(mShooter);
  }
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    double speedFromJoystick = mJoystick.getThrottle(); // 1 to -1
    speedFromJoystick *= -1;                            // -1 to 1
    speedFromJoystick += 1;                             // 0 to 2
    speedFromJoystick *= 0.5;                           // 0 to 1
    
    mShooter.ShooterSetSpeed(speedFromJoystick);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
