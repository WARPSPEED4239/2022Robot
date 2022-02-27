package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberPistons extends SubsystemBase {
  
  
  private final DoubleSolenoid ClimberPistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.CLIMBER_SOLENOID_FORWARD_PORT, Constants.CLIMBER_SOLENOID_REVERSE_PORT);

  public ClimberPistons() {
  }

  @Override
  public void periodic() {
  }

  public void setPistonsState (boolean pistonState) {
    if (pistonState) {
      ClimberPistons.set(Value.kReverse);
    } else {
      ClimberPistons.set(Value.kForward);
    }
  }
}
