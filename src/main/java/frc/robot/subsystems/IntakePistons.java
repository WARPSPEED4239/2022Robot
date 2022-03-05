package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePistons extends SubsystemBase {
  
  
  private final DoubleSolenoid IntakePistons = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_SOLENOID_FORWARD_PORT, Constants.INTAKE_SOLENOID_REVERSE_PORT);

  public IntakePistons() {}

  @Override
  public void periodic() {}

  public void setPistonsState (boolean pistonState) {
    if (pistonState) {
      IntakePistons.set(Value.kReverse);
    } else {
      IntakePistons.set(Value.kForward);
    }
  }
}
