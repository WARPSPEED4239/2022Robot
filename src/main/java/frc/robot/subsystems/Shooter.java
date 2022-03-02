package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

    ShooterMotor.configClosedLoopPeakOutput(0, 1.0);
    ShooterMotor2.configClosedLoopPeakOutput(0, 1.0);

    ShooterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    ShooterMotor.setSensorPhase(true);

    ShooterMotor.config_kF(0, 0.025);
    ShooterMotor.config_kP(0, 0.25);
    ShooterMotor.config_kI(0, 0.0);
    ShooterMotor.config_kD(0, 0.0);

    ShooterMotor.configVoltageCompSaturation(12.0);
    ShooterMotor.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter RPM", getRPM());
    SmartDashboard.putNumber("Shooter Encoder Value", ShooterMotor.getSelectedSensorPosition(0));
  }

  public void ShooterSetSpeed(double speed) {
    if (speed > 1.0) {
      speed = 1.0;
    } else if (speed < -1.0) {
      speed = -1.0;
    }
    ShooterMotor.set(speed);
  }

  public void setVelocity(double RPM) {
    int velocityInSRX = (int) (RPM / 600.0 * Constants.COUNTS_PER_REVOLUTION_ENCODER);
    ShooterMotor.set(ControlMode.Velocity, velocityInSRX);
  }

  public double getRPM() {
    double RPM = ShooterMotor.getSelectedSensorVelocity(0) * 600.0 / Constants.COUNTS_PER_REVOLUTION_ENCODER;
    return RPM;
  }
}
