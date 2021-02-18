// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;

import java.io.Console;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ArcDriveDegrees extends CommandBase {
  /** Creates a new ArcDriveDegrees. */

  private final Drivetrain m_drive;
  private final double m_speed;
  private final double m_radius;
  private final double m_degrees;
  private boolean m_right;
  private double m_powerScale;


  public ArcDriveDegrees(double speed, double radius, double degrees, Drivetrain drive) {
    m_speed = speed;
    m_radius = radius;
    m_drive = drive;
    m_degrees = degrees;
    addRequirements(drive);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_right = (m_degrees > 0.0);
    m_powerScale = (m_radius - 2.7755)/(m_radius + 2.7755); //2.7755 is half of the distance between the wheels
    m_drive.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // System.out.print(m_right);
    if (m_right) {
      m_drive.DifferentialDrive(m_speed,(m_speed * m_powerScale));
    }
    else {
      m_drive.DifferentialDrive((m_speed * m_powerScale), m_speed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double inchPerDegree = Math.PI * m_radius / 180;
    // Compare distance travelled from start to distance based on degree turn
    return getAverageTurningDistance() >= Math.abs(inchPerDegree * m_degrees);
  }

  private double getAverageTurningDistance() {
    double leftDistance = m_drive.getLeftDistanceInch();
    double rightDistance = m_drive.getRightDistanceInch();
    return (leftDistance + rightDistance) / 2.0;
  }
}
