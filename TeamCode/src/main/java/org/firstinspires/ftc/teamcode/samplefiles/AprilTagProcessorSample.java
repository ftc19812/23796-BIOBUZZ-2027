package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

@TeleOp(name = "AprilTag Example")
public class AprilTagProcessorSample extends OpMode {

    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTag;

    @Override
    public void init() {

        WebcamName webcam = hardwareMap.get(WebcamName.class, "Webcam 1");

        aprilTag = new AprilTagProcessor.Builder()
                .build();

        visionPortal = new VisionPortal.Builder()
                .setCamera(webcam)
                .addProcessor(aprilTag)
                .build();
    }

    @Override
    public void loop() {

        for (AprilTagDetection detection :
                aprilTag.getDetections()) {

            telemetry.addData("Tag ID", detection.id);

            if (detection.ftcPose != null) {

                telemetry.addData("Range", detection.ftcPose.range);

                telemetry.addData("Bearing", detection.ftcPose.bearing);

                telemetry.addData("Yaw", detection.ftcPose.yaw);
            }
        }

        telemetry.update();
    }
}