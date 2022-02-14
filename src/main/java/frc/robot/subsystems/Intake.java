package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  
  private WPI_VictorSPX IntakeMoters = new WPI_VictorSPX(Constants.INTAKE_MOTORS_PORT);

  public Intake() {
    IntakeMoters.configFactoryDefault();
    IntakeMoters.setInverted(false);
    IntakeMoters.setNeutralMode(NeutralMode.Brake);
    IntakeMoters.configVoltageCompSaturation(12.0);
    IntakeMoters.enableVoltageCompensation(true);
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
    
    IntakeMoters.set(speed);
  }
}
