package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederWheels extends SubsystemBase {

  private final WPI_TalonSRX FeederWheelMotor = new WPI_TalonSRX(Constants.FEEDER_WHEELS_PORT);
  
  public FeederWheels() {
    FeederWheelMotor.configFactoryDefault();
    FeederWheelMotor.setInverted(true);
    FeederWheelMotor.setNeutralMode(NeutralMode.Coast);
    FeederWheelMotor.configVoltageCompSaturation(12.0);
    FeederWheelMotor.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {}

  public void FeederWheelsSetSpeed(double speed) {
    if (speed > 1.0) {
      speed = 1.0;
    } else if (speed < -1.0) {
      speed = -1.0;
    }

    FeederWheelMotor.set(speed);
  }
}
