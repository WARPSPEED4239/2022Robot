package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ConveyorBelt extends SubsystemBase {
  
  private final WPI_TalonSRX ConveyorBeltMotors = new WPI_TalonSRX(Constants.CONVEYOR_BELT_MOTOR_PORT);

  public ConveyorBelt() {
    ConveyorBeltMotors.configFactoryDefault();
    ConveyorBeltMotors.setInverted(true);
    ConveyorBeltMotors.setNeutralMode(NeutralMode.Coast);
    ConveyorBeltMotors.configVoltageCompSaturation(12.0);
    ConveyorBeltMotors.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
    
  }

  public void ConveyorBeltSetSpeed(double speed) {
    if (speed > 1.0) {
      speed = 1.0;
    } else if (speed < -1.0) {
      speed = -1.0;
    }
    
    ConveyorBeltMotors.set(speed);
  }
}
