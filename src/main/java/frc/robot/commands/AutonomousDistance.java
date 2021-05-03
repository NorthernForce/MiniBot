// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonomousDistance extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain) {
    addCommands(
        new DriveDistance(0.5, 7.5, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, -90, drivetrain),
        new DriveDistance(0.3, 3.0, drivetrain),

        new ArcDriveDegrees(0.3, 0.0, 180, drivetrain),
        new DriveDistance(0.5, 3.0, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, 22.5, drivetrain),
        new DriveDistance(0.5, 16.7, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, 67.5, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, -90, drivetrain),
        new DriveDistance(0.5, 15.0, drivetrain),
        new DriveDistance(0.3, 3.0, drivetrain),

        new ArcDriveDegrees(0.3, 0.0, 180, drivetrain),
        new DriveDistance(0.5, 18.0, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, -90, drivetrain),
        new DriveDistance(0.5, 7.5, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, -90, drivetrain),
        new DriveDistance(0.5, 15.0, drivetrain),
        new DriveDistance(0.3, 3.0, drivetrain),

        new ArcDriveDegrees(0.3, 0.0, 180, drivetrain),
        new DriveDistance(0.5, 3.0, drivetrain),
        new ArcDriveDegrees(0.6, 7.5, -90, drivetrain),
        new DriveDistance(0.5, 7.5, drivetrain),

        new StopDrive(drivetrain));
  }
}