// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;


public class DriftCorrection extends CommandBase {
  /** Creates a new DriftCorrection. */
  private double m_speed;
  private Drivetrain m_drive;
  double m_correction = 0.9945698630246768;


  public DriftCorrection(double speed, Drivetrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_speed = speed;
    m_drive = drive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_correction < 1) {
      m_drive.DifferentialDrive(m_speed * m_correction, m_speed);
    }
    else {
      m_drive.DifferentialDrive(m_speed, m_speed / m_correction);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_correction += ((m_drive.getRightDistanceInch() / m_drive.getLeftDistanceInch()) - 1);
    System.out.print(m_correction);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_drive.getAverageDistanceInch() > 75);
  }
}
