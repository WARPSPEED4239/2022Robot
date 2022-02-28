package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber;

public class ClimberSetSpeed extends CommandBase {
  
  private final Climber mClimber;
  private final Joystick mJoystick;
  private final double mSpeed;

  public ClimberSetSpeed(Climber climber, Joystick joystick, double speed) {

    mClimber = climber;
    mJoystick = joystick;
    mSpeed = speed;
    addRequirements(mClimber);
  }
  
  @Override
  public void initialize() {}

  @Override
  public void execute() {
    int jPOV = mJoystick.getPOV();
    System.out.println(jPOV);

    if(jPOV == 0) {
      mClimber.ClimberSetSpeed(-1.0);
    } else if(jPOV == 180){
      mClimber.ClimberSetSpeed(1.0);
    } else {
      mClimber.ClimberSetSpeed(0.0);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
