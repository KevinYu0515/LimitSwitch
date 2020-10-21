package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;


public class Robot extends TimedRobot {
  TalonSRX talon = new TalonSRX(8);
  
  @Override
  public void robotInit() {
    talon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    talon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed,10);
    talon.configClearPositionOnLimitR(true, 10);//當反向限位閉合時使傳感器位置歸零
  }
  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    if(talon.getSensorCollection().isRevLimitSwitchClosed()) {
      talon.set(ControlMode.PercentOutput, 0);
    }else{
      talon.set(ControlMode.PercentOutput, 0.5);
    }
    SmartDashboard.putNumber("Encoder_P", talon.getSelectedSensorPosition());
  }
}
