
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  
  private final WPI_VictorSPX ShooterMotor = new WPI_VictorSPX(Constants.SHOOTER_MOTOR_PORT);

  public Shooter() {
    ShooterMotor.configFactoryDefault();
    ShooterMotor.setInverted(false);
    ShooterMotor.setNeutralMode(NeutralMode.Coast);
    ShooterMotor.configVoltageCompSaturation(12.0);
    ShooterMotor.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
    
  }

  public void ShooterSetSpeed(double speed) {
    if (speed > 1.0) {
      speed = 1.0;
    } else if (speed < -1.0) {
      speed = -1.0;
    }
    
    ShooterMotor.set(speed);
  }
}
