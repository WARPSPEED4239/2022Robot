package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.tools.UnitConversion;

public class Drivetrain extends SubsystemBase {

  private final double kDrumDiameter = 1.65;
  // private final double TRACK_WIDTH_METERS;
  private final double WHEEL_DIAMETER = 6.0;
  private final double WHEEL_DIAMETER_METERS = Units.inchesToMeters(6.0);
  // private final double GEARBOX_RATIO;
  private final int ENCODER_TICKS_PER_REV = 2048;
  
    //Left Leader
    private final WPI_TalonFX LeftMotorOne = new WPI_TalonFX(Constants.LEFT_MOTOR_PORT_ONE);
    private final WPI_TalonFX LeftMotorTwo = new WPI_TalonFX(Constants.LEFT_MOTOR_PORT_TWO);
    private final WPI_TalonFX LeftMotorThree = new WPI_TalonFX(Constants.LEFT_MOTOR_PORT_THREE);
    //Right Leader
    private final WPI_TalonFX RightMotorOne = new WPI_TalonFX(Constants.RIGHT_MOTOR_PORT_ONE);
    private final WPI_TalonFX RightMotorTwo = new WPI_TalonFX(Constants.RIGHT_MOTOR_PORT_TWO);
    private final WPI_TalonFX RightMotorThree = new WPI_TalonFX(Constants.RIGHT_MOTOR_PORT_THREE);
  
    private final DifferentialDrive DriveTrain = new DifferentialDrive(LeftMotorOne, RightMotorOne);

  public Drivetrain() {
    LeftMotorOne.configFactoryDefault();
    LeftMotorTwo.configFactoryDefault();
    LeftMotorThree.configFactoryDefault();
    RightMotorOne.configFactoryDefault();
    RightMotorTwo.configFactoryDefault();
    RightMotorThree.configFactoryDefault();

    LeftMotorTwo.follow(LeftMotorOne);
    LeftMotorThree.follow(LeftMotorOne);
    RightMotorTwo.follow(RightMotorOne);
    RightMotorThree.follow(RightMotorOne);

    LeftMotorOne.setInverted(true);
    LeftMotorTwo.setInverted(InvertType.FollowMaster);
    LeftMotorThree.setInverted(InvertType.FollowMaster);
    RightMotorOne.setInverted(false);
    RightMotorTwo.setInverted(InvertType.FollowMaster);
    RightMotorThree.setInverted(InvertType.FollowMaster);

    LeftMotorOne.setNeutralMode(NeutralMode.Brake);
    LeftMotorTwo.setNeutralMode(NeutralMode.Brake);
    LeftMotorThree.setNeutralMode(NeutralMode.Brake);
    RightMotorOne.setNeutralMode(NeutralMode.Brake);
    RightMotorTwo.setNeutralMode(NeutralMode.Brake);
    RightMotorThree.setNeutralMode(NeutralMode.Brake);

    LeftMotorOne.configOpenloopRamp(Constants.RAMP_RATE);
    LeftMotorTwo.configOpenloopRamp(Constants.RAMP_RATE);
    LeftMotorThree.configOpenloopRamp(Constants.RAMP_RATE);
    RightMotorOne.configOpenloopRamp(Constants.RAMP_RATE);
    RightMotorTwo.configOpenloopRamp(Constants.RAMP_RATE);
    RightMotorThree.configOpenloopRamp(Constants.RAMP_RATE);

    LeftMotorOne.configVoltageCompSaturation(12.0);
    RightMotorOne.configVoltageCompSaturation(12.0);

    LeftMotorOne.enableVoltageCompensation(true);
    LeftMotorTwo.enableVoltageCompensation(true); 

    LeftMotorOne.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    LeftMotorTwo.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

  }

  @Override
  public void periodic() {
    
  }

  public void DrivetrainArcadeDrive(double move, double rotate) {
    DriveTrain.arcadeDrive(move, rotate);
  }

  public void resetEncoders() {
    LeftMotorOne.setSelectedSensorPosition(0);
    RightMotorOne.setSelectedSensorPosition(0);
  }
  
  public void setPosition(double positionInInches) {
    double positionInRotations = UnitConversion.convertPositionInInchesToRotations(positionInInches, kDrumDiameter);
    double positionInFXUnits = UnitConversion.convertRotationsToSRXUnits(positionInRotations);

    LeftMotorOne.set(ControlMode.MotionMagic, positionInFXUnits);
    RightMotorOne.set(ControlMode.MotionMagic, positionInFXUnits);
  }
}
