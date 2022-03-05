package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Ramp extends SubsystemBase {
  
  private final DoubleSolenoid IntakePistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.RAMP_SOLENOID_FORWARD_PORT, Constants.RAMP_SOLENOID_REVERSE_PORT);

  public Ramp() {}

  @Override
  public void periodic() {}

  public void setPistonState (boolean pistonState) {
    if (pistonState) {
      IntakePistons.set(Value.kReverse);
    } else {
      IntakePistons.set(Value.kForward);
    }
  }
}
