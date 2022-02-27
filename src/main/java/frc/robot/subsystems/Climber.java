package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
  
  private final WPI_TalonSRX ClimberMotor = new WPI_TalonSRX(Constants.CLIMBER_MOTOR_PORT);
  

  public Climber() {
    ClimberMotor.configFactoryDefault();
    ClimberMotor.setInverted(false);
    ClimberMotor.setNeutralMode(NeutralMode.Coast);
    ClimberMotor.configVoltageCompSaturation(12.0);
    ClimberMotor.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
    
  }

  public void ClimberSetSpeed(double speed) {
    if (speed > 1.0) {
      speed = 1.0;
    } else if (speed < -1.0) {
      speed = -1.0;
    }
    
    ClimberMotor.set(speed);
  }
}
