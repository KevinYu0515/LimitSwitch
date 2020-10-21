package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Limitswitch1 extends TimedRobot {
  private TalonSRX talon = new TalonSRX(8);
  private final Joystick m_stick = new Joystick(0);
  private DigitalInput limit = new DigitalInput(1); //設置數位輸出物件

  @Override
  public void robotInit() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    if(limit.get()){ //是否有得到回饋，get()為布林值
      talon.set(ControlMode.PercentOutput,0.1);
    }
    else{
      talon.set(ControlMode.PercentOutput,0);
    }
  }
}
