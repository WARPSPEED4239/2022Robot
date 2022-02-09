package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {

    public static final int 
        LEFT_MOTOR_PORT_ONE = 1,
        LEFT_MOTOR_PORT_TWO = 2,
        LEFT_MOTOR_PORT_THREE = 3,
        RIGHT_MOTOR_PORT_ONE = 4,
        RIGHT_MOTOR_PORT_TWO = 5,
        RIGHT_MOTOR_PORT_THREE = 6,
        
        XBOX_CONTROLLER_PORT = 0,

        PIGEON_IMU = 1,
        
        COUNTS_PER_REVOLUTION_ENCODER = 4096,
        //TRACK_WIDTH_METERS;
        //GEARBOX_RATIO;
        TIMEOUT_MS = 30;
        
    public static final double
        RAMP_RATE = 0.3,
        WHEEL_DIAMETER_METERS = Units.inchesToMeters(6.0),
        WHEEL_DIAMETER = 6.0,
        kP = 0.05,// 0.464;//0.297;
        kI = 0.0,
        kD = 0.0;
}
