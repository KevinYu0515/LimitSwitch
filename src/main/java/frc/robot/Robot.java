package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal; //引入 限位開關的常態模式
import com.ctre.phoenix.motorcontrol.LimitSwitchSource; //引入 限位開關的來源庫
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Robot extends TimedRobot {
  private TalonFX falcon = new TalonFX(15);
  private final Joystick m_stick = new Joystick(0);
  private final TalonSRX talon = new TalonSRX(0);
 // private final Timer m_timer = new Timer();

  @Override
  public void robotInit() {
  }

  @Override
  public void autonomousInit() {
   // m_timer.reset();
    //m_timer.start();
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    talon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed);
    //falcon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor,0,10);
    // 設定反輸出的限位開關來源
  }

  @Override
  public void teleopPeriodic() {
    if(talon.getSensorCollection().isRevLimitSwitchClosed()){//得到感測器回饋，是否有反向輸出
      talon.set(ControlMode.PercentOutput,0.5);
    }else{
      talon.set(ControlMode.PercentOutput,0);
    }
    
  }

  @Override
  public void testPeriodic() {
  }
}
