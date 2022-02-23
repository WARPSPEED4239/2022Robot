
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  
  private final WPI_TalonSRX ShooterMotor = new WPI_TalonSRX(Constants.SHOOTER_MOTOR_PORT);
  private final WPI_TalonSRX ShooterMotor2 = new WPI_TalonSRX(Constants.SHOOTER_MOTOR_PORT2);
  public Shooter() {
    ShooterMotor2.follow(ShooterMotor);
    ShooterMotor.configFactoryDefault();
    ShooterMotor.setInverted(true);
    ShooterMotor2.setInverted(true);
    ShooterMotor.setNeutralMode(NeutralMode.Coast);
    ShooterMotor.configVoltageCompSaturation(12.0);
    ShooterMotor.enableVoltageCompensation(false);
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
