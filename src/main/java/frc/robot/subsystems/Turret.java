// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.CAN_ID.*;

public class Turret extends SubsystemBase {
  public WPI_TalonSRX turret = new WPI_TalonSRX(TURRET);
  /** Creates a new Turret. */
  public Turret() {}

  public void rotate(double x) {
    turret.set(x);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}