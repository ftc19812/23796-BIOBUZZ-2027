package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

@TeleOp(name = "Vision Portal Sample")
public class VisionPortalSample extends OpMode {

    private WebcamName webcam;
    private VisionPortal visionPortal;
    private AprilTagProcessor aprilTag;

    @Override
    public void init() {

        webcam = hardwareMap.get(WebcamName.class, "Webcam 1");

        aprilTag = new AprilTagProcessor.Builder()
                .build();

        visionPortal = new VisionPortal.Builder()
                .setCamera(webcam)
                .addProcessor(aprilTag)
                .build();
    }

    @Override
    public void loop() {

        telemetry.addData("Camera State", visionPortal.getCameraState());

        telemetry.update();
    }
}