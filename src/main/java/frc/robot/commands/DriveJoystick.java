// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.NavX;

import static frc.robot.Constants.Controller.*;

public class DriveJoystick extends CommandBase {
  private Drivebase m_Drivebase;
  private NavX m_gyro;

  /** Creates a new ManualControl. */
  public DriveJoystick(Drivebase drivebase, NavX __gyro) {
    m_Drivebase = drivebase;
    m_gyro = __gyro;

    addRequirements(m_Drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Manual Control Ran");
    double ySpeed = JOYSTICK0.getRawAxis(1); // Y joystick is inverted
    double xSpeed = JOYSTICK0.getRawAxis(0); // X drive is inverted
    double rSpeed = JOYSTICK0.getRawAxis(2);
    SmartDashboard.putNumber("xSpeed", xSpeed * xSpeed);
    SmartDashboard.putNumber("ySpeed", ySpeed * ySpeed);
    //Detect if the left joystick is being used to determine whether to set PID goal
    //m_subsystem.drive(xSpeed , ySpeed, 0);

    double co = 0.8;
    //co = Math.abs(JOYSTICK0.getRawAxis(3));

    //if (JOYSTICK0.getRawButton(9)) co = 0.8;

    m_Drivebase.drive(xSpeed * co, ySpeed * co, 0);
    //m_Drivebase.driveWithField(ySpeed * co, xSpeed * co, rSpeed * co, m_gyro.getRotation2d().unaryMinus()); //X and Y is swapped in Controller vs Robot axis
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}