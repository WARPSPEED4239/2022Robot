package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainShifter extends SubsystemBase {

  private final DoubleSolenoid Shifter = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.SHIFTER_SOLENOID_FORWARD_PORT, Constants.SHIFTER_SOLENOID_REVERSE_PORT);

  public DrivetrainShifter() {}

  @Override
  public void periodic() {}

  public void setPistonState (boolean pistonState) {
    if (pistonState) {
      Shifter.set(Value.kReverse);
    } else {
      Shifter.set(Value.kForward);
    }
  }
}
