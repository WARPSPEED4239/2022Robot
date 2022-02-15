package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  
  private WPI_VictorSPX IntakeMotors = new WPI_VictorSPX(Constants.INTAKE_MOTORS_PORT);

  public Intake() {
    IntakeMotors.configFactoryDefault();
    IntakeMotors.setInverted(false);
    IntakeMotors.setNeutralMode(NeutralMode.Brake);
    IntakeMotors.configVoltageCompSaturation(12.0);
    IntakeMotors.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
    
  }

  public void setPercentOutput(double speed) {
    if (speed > 1.0) {
      speed = 1.0;
    } else if (speed < -1.0) {
      speed = -1.0;
    }
    
    IntakeMotors.set(speed);
  }
}
