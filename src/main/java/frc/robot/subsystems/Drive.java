/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
 
import frc.robot.Robot;
import frc.robot.RobotMap;


public class Drive extends Subsystem {
private final TalonSRX m_leftDriveMaster;
private final TalonSRX m_leftDriveSlave1;
private final TalonSRX m_leftDriveSlave2;

private final TalonSRX m_rightDriveMaster;
private final TalonSRX m_rightDriveSlave1;
private final TalonSRX m_rightDriveSlave2;



  public Drive() {
    m_leftDriveMaster = new TalonSRX(RobotMap.leftDriveMasterID);
    m_leftDriveSlave1 = new TalonSRX (RobotMap.leftDriveSlave1ID);
    m_leftDriveSlave2 = new TalonSRX(RobotMap.leftDriveSlave2ID);

    m_rightDriveMaster = new TalonSRX(RobotMap.rightDriveMasterID);
    m_rightDriveSlave1 = new TalonSRX(RobotMap.rightDriveSlave1ID);
    m_rightDriveSlave2 = new TalonSRX(RobotMap.rigthDriveSlave2ID);
    
    m_leftDriveSlave1.follow(m_leftDriveMaster);
    m_leftDriveSlave2.follow(m_leftDriveMaster);

    m_rightDriveSlave1.follow(m_rightDriveMaster);
    m_rightDriveSlave2.follow(m_rightDriveSlave2);
  
  }

  @Override
  protected void initDefaultCommand() {
  
}
    public void setDrivePower(double percentleft, double percentright){
    m_leftDriveMaster.set(ControlMode.PercentOutput, percentleft);
    m_rightDriveMaster.set(ControlMode.PercentOutput, percentright);
}


}