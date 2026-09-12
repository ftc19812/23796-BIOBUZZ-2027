package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

@TeleOp(name = "Webcam Name Sample")
public class WebcamNameSample extends OpMode {

    private WebcamName webcam;

    @Override
    public void init() {

        webcam = hardwareMap.get(WebcamName.class, "Webcam 1");

        telemetry.addData("Connected", webcam.isAttached());
        telemetry.update();
    }

    @Override
    public void loop() {

    }
}