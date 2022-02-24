package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticController extends SubsystemBase {

  private final Compressor mCompressor = new Compressor(Constants.COMPRESSOR, PneumaticsModuleType.CTREPCM);
  //private final AnalogInput mPressureSensor = new AnalogInput(Constants.PRESSURE_SENSOR);

  private final double DEFAULT_VOLTS = 4.52;
  private final double SLOPE = 250.0;
  private final double Y_INTERCEPT = -25.0;

  public PneumaticController() {
  }

  @Override
  public void periodic() {
  }

  public void setCompressorState(boolean on) {
    boolean mOn = on;

    if (mOn) {
      mCompressor.enableDigital();
    } else {
      mCompressor.disable();
    }
  }

  public boolean getCompressorStatus() {
    return mCompressor.enabled();
  }

  // public double getTankPressure() {
  //   return SLOPE * (mPressureSensor.getVoltage() / DEFAULT_VOLTS) + Y_INTERCEPT;
  // }

  // public double getPressureSensorVolts() {
  //   return mPressureSensor.getVoltage();
  // }
}