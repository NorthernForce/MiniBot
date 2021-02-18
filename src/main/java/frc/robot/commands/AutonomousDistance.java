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
      //Perfect Measurements:
        // new DriveDistance(0.5, 4.5, drivetrain),
        // new ArcDriveDegrees(0.5, 13.5, -90, drivetrain),
        // new ArcDriveDegrees(0.5, 4.5, -116.5, drivetrain),
        // new DriveDistance(0.5, 12.8, drivetrain),
        // new ArcDriveDegrees(0.5, 4.5, 116.5, drivetrain),
        // new ArcDriveDegrees(0.5, 13.5, 90, drivetrain),
        // new DriveDistance(0.5, 4.5, drivetrain),
        // new StopDrive(drivetrain));

      //Adjusted Measurements:
        new DriveDistance(0.5, 3, drivetrain),
        new ArcDriveDegrees(0.7, 12.615, -90, drivetrain),
        new ArcDriveDegrees(0.7, 4, -119, drivetrain),
        new DriveDistance(0.7, 16, drivetrain),
        new ArcDriveDegrees(0.6, 4.2, 109, drivetrain),
        new DriveDistance(0.6, 0.825, drivetrain),
        new ArcDriveDegrees(0.65, 12.615, 83, drivetrain),
        new DriveDistance(0.45, 5.76, drivetrain),
        new StopDrive(drivetrain));
  }
}