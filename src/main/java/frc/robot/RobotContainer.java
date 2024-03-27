// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants.AutoConstants.autoPoses;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
    testMethod();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public void testMethod() {
    Pose2d p1 = new Pose2d(5,1,Rotation2d.fromDegrees(180));
    Pose2d p2 = new Pose2d(2,1,Rotation2d.fromDegrees(180));

    Pose2d relativePoseTurned = p2.relativeTo(p1).rotateBy(Rotation2d.fromDegrees(90));

    System.out.println("P2:"+p2);

    Transform2d t = relativePoseTurned.minus(new Pose2d()); // converts relative pose to a transformation
    Pose2d r =  p1.transformBy(t);

    System.out.println("R:"+r);

    Pose2d p3 = new Pose2d(5,1,Rotation2d.fromDegrees(-180));
    Translation2d t3 = new Translation2d(-1,new Rotation2d().fromDegrees(0));
    Transform2d tr3 = new Transform2d(t3, new Rotation2d().fromDegrees(0));
    Pose2d p4 = p3.plus(tr3);

    System.out.println("T3:"+t3);
    System.out.println("TR3:"+tr3);
    System.out.println("P43:"+p4);
  

    Pose2d p5 = new Pose2d(5,1,Rotation2d.fromDegrees(-30));
    Pose2d p6 = new Pose2d(6,2,Rotation2d.fromDegrees(180));
    Pose2d p7 = p6.relativeTo(p5);
    System.out.println("P7:"+p7);
    System.out.println("P7A:"+p7.getTranslation().getAngle().getDegrees());

    Pose2d p8 = new Pose2d(5,1,Rotation2d.fromDegrees(0));
    Pose2d p9 = p8.transformBy(new Transform2d(-1, 0, Rotation2d.fromDegrees(30)));
    System.out.println("P9:"+p9);
   
    System.out.println("BLUE_HIGHER_RING"+autoPoses.BLUE_HIGHER_RING.getPose());
    System.out.println("BLUE_SPEAKER_HIGHER"+autoPoses.BLUE_SPEAKER_HIGHER.getPose());
    System.out.println("BLUE_HIGHER_RING_TAKE_START"+autoPoses.BLUE_HIGHER_RING_TAKE_START.getPose());
    System.out.println("BLUE_HIGHER_RING_TAKE_START_OPTIMIZED"+autoPoses.BLUE_HIGHER_RING_TAKE_START_OPTIMIZED.getPose());
    System.out.println("BLUE_HIGHER_RING_TAKE_END"+autoPoses.BLUE_HIGHER_RING_TAKE_END.getPose());
    System.out.println("BLUE_HIGHER_RING_TAKE_END_OPTIMIZED"+autoPoses.BLUE_HIGHER_RING_TAKE_END_OPTIMIZED.getPose());

  }
}
