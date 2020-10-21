package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;//引入 限位開關常態
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;//引入 限位開關來源庫
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {
  private TalonSRX a = new TalonSRX(8);
  private final Joystick m_stick = new Joystick(0);

  @Override
  public void robotInit() {
  }

  @Override
  public void teleopInit() {
    a.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    //設定限位開關反輸出來源
  }

  @Override
  public void teleopPeriodic() {
    if(a.getSensorCollection().isRevLimitSwitchClosed()){//得到感測器回饋，反輸入
      a.set(ControlMode.PercentOutput,0.1);
    }else{
      a.set(ControlMode.PercentOutput,0);
    }
  }
}
