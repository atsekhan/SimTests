package frc.robot;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.lib.TrajectoryHelpers;

public final class Constants {

    public static final class AutoConstants {

		public static double armInPerimeterAngle = -15; // move arm into perimeter

		private static final double fieldSizeX = 16.545814;
		private static final double fieldSizeY = 8.212;

		public static enum autoPoses {	// important poses

			// SPEAKER TAGS

			BLUE_SPEAKER_TAG (0, 4.986, 180),
			RED_SPEAKER_TAG (16.545814, 4.986, 0),

			// ========================================= AUTO POSES ======================================

			BLUE_SPEAKER_HIGHER (0.765, 6.764, 60),
			BLUE_SPEAKER_MID (1.346, 5.540, 0),
			BLUE_SPEAKER_LOWER (0.765, 4.315, -60),

			BLUE_HIGHER_POS_OUT(3.25, 7.1,0),
			BLUE_MID_POS_OUT(3.25,5.540,0),
			BLUE_LOWER_POS_OUT (3.25, 1.312, 0),

			RED_SPEAKER_HIGHER(fieldSizeX-BLUE_SPEAKER_HIGHER.getPose().getX(), BLUE_SPEAKER_HIGHER.getPose().getY(), 120),
			RED_SPEAKER_MID(fieldSizeX-BLUE_SPEAKER_MID.getPose().getX(), BLUE_SPEAKER_MID.getPose().getY(), 180),
			RED_SPEAKER_LOWER(fieldSizeX-BLUE_SPEAKER_LOWER.getPose().getX(), BLUE_SPEAKER_LOWER.getPose().getY(), -120),

			RED_HIGHER_POS_OUT(fieldSizeX-BLUE_HIGHER_POS_OUT.getPose().getX(), BLUE_HIGHER_POS_OUT.getPose().getY(), 180),
			RED_MID_POS_OUT(fieldSizeX-BLUE_MID_POS_OUT.getPose().getX(), BLUE_MID_POS_OUT.getPose().getY(), 180),
			RED_LOWER_POS_OUT(fieldSizeX-BLUE_LOWER_POS_OUT.getPose().getX(), BLUE_LOWER_POS_OUT.getPose().getY(), 180),

			BLUE_HIGHER_RING(2.896,7.015,0),
			BLUE_MID_RING(2.896,5.5535,0),
			BLUE_LOWER_RING(2.896,4.0055,0),

			RED_HIGHER_RING(fieldSizeX-BLUE_HIGHER_RING.getPose().getX(), BLUE_HIGHER_RING.getPose().getY(),180),
			RED_MID_RING(fieldSizeX-BLUE_MID_RING.getPose().getX(), BLUE_MID_RING.getPose().getY(),180),
			RED_LOWER_RING(fieldSizeX-BLUE_LOWER_RING.getPose().getX(), BLUE_LOWER_RING.getPose().getY(),180),

			BLUE_HIGHER_RING_TAKE_START(1.909,7.0115,0),
			BLUE_MID_RING_TAKE_START(1.909,5.5535,0),
			BLUE_LOWER_RING_TAKE_START(1.909,4.1055,0),

			BLUE_HIGHER_RING_TAKE_END(2.465,7.0115,0),
			BLUE_MID_RING_TAKE_END(2.465,5.5535,0),
			BLUE_LOWER_RING_TAKE_END(2.465,4.0055,0),

			// alex new

			// TAKE_START pose rotated using the note center as origin, to the number of degrees - from the center of the speaker looking forward to point to the note
			BLUE_HIGHER_RING_TAKE_START_OPTIMIZED(
				TrajectoryHelpers.correctEndingPoseBasedOnNoteLocation(
					BLUE_HIGHER_RING.getPose(),
					BLUE_HIGHER_RING_TAKE_START.getPose(),
					TrajectoryHelpers.rotateToPointToSecondPose(BLUE_SPEAKER_MID.getPose(), BLUE_HIGHER_RING.getPose()).getDegrees()  // angle to point from middle of the speaker to the ring
				)
			),
			BLUE_HIGHER_RING_TAKE_END_OPTIMIZED(
				TrajectoryHelpers.correctEndingPoseBasedOnNoteLocation(
					BLUE_HIGHER_RING.getPose(),
					BLUE_HIGHER_RING_TAKE_END.getPose(),
					TrajectoryHelpers.rotateToPointToSecondPose(BLUE_SPEAKER_MID.getPose(), BLUE_HIGHER_RING.getPose()).getDegrees()
				)
			),

			RED_HIGHER_RING_TAKE_START(fieldSizeX-BLUE_HIGHER_RING_TAKE_START.getPose().getX(), BLUE_HIGHER_RING_TAKE_START.getPose().getY(),180),
			RED_MID_RING_TAKE_START(fieldSizeX-BLUE_MID_RING_TAKE_START.getPose().getX(), BLUE_MID_RING_TAKE_START.getPose().getY(),180),
			RED_LOWER_RING_TAKE_START(fieldSizeX-BLUE_LOWER_RING_TAKE_START.getPose().getX(), BLUE_LOWER_RING_TAKE_START.getPose().getY(),180),

			RED_HIGHER_RING_TAKE_END(fieldSizeX-BLUE_HIGHER_RING_TAKE_END.getPose().getX(), BLUE_HIGHER_RING_TAKE_END.getPose().getY(),180),
			RED_MID_RING_TAKE_END(fieldSizeX-BLUE_MID_RING_TAKE_END.getPose().getX(), BLUE_MID_RING_TAKE_END.getPose().getY(),180),
			RED_LOWER_RING_TAKE_END(fieldSizeX-BLUE_LOWER_RING_TAKE_END.getPose().getX(), BLUE_LOWER_RING_TAKE_END.getPose().getY(),180),

			//Constants to pick up far note
			BLUE_FAR_DRIVE_W1(5.03, 0.453, 0),
			BLUE_FAR_LOWER_TAKE_START(7.40, 0.453, 0),
			BLUE_FAR_LOWER_TAKE_END(8.2, 0.453, 0),
			BLUE_SPEAKER_LOWER_2(1.265, 4.315, -60),

			RED_FAR_DRIVE_W1(fieldSizeX-BLUE_FAR_DRIVE_W1.getPose().getX(), BLUE_FAR_DRIVE_W1.getPose().getY(), 180),
			RED_FAR_LOWER_TAKE_START(fieldSizeX-BLUE_FAR_LOWER_TAKE_START.getPose().getX(), BLUE_FAR_LOWER_TAKE_START.getPose().getY(), 180),
			RED_FAR_LOWER_TAKE_END(fieldSizeX-BLUE_FAR_LOWER_TAKE_END.getPose().getX(), BLUE_FAR_LOWER_TAKE_END.getPose().getY(), 180),
			RED_SPEAKER_LOWER_2(fieldSizeX-BLUE_SPEAKER_LOWER_2.getPose().getX(), BLUE_SPEAKER_LOWER_2.getPose().getY(), -120)

			;

			private Pose2d pose;

			autoPoses(double x, double y, double angle) {
				this.pose = new Pose2d(x, y, Rotation2d.fromDegrees(angle));
			}
			autoPoses(Pose2d p) {
				this.pose = p;
			}
			public Pose2d getPose() {
				return pose;
			}
		}

		public static enum centerNotes {	// important poses
			
			LOW1 (8.272, 0.753),
			LOW2 (8.272, 2.411),
			MID3 (8.272, 4.106),
			HIGH4 (8.272, 5.782),
			HIGH5 (8.272, 7.458)
			;

			private Translation2d translation;

			centerNotes(double x, double y) {
				this.translation = new Translation2d(x, y);
			}
			public Translation2d getTranslation() {
				return translation;
			}
		}
		
	}
    
}
