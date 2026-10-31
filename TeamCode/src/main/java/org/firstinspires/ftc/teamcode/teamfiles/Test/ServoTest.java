package org.firstinspires.ftc.teamcode.teamfiles.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo Increment Test", group = "Test")
public class ServoTest extends OpMode {
    Servo testServo;
    String servoHardwareName = "testServo";
    double currentPosition = 0.0;
    double trackPos = 0.0;

    @Override
    public void init() {
        testServo = hardwareMap.get(Servo.class, servoHardwareName);
        testServo.setPosition(currentPosition);
    }

    @Override
    public void loop() {
        // a - increment by 0.1
        // b - increment by 0.01
        // x - set servo to 1
        // y - set servo to 0
        // right bumper - track a specific position
        // left bumper - set the servo to the tracked position (default 0)
        if (gamepad1.aWasPressed()) {
            currentPosition += 0.1;
        }
        if (gamepad1.bWasPressed()) {
            currentPosition += 0.01;
        }
        if (gamepad1.xWasPressed()) {
            currentPosition = 1;
        }
        if (gamepad1.yWasPressed()) {
            currentPosition = 0;
        }
        if (gamepad1.leftBumperWasPressed()) {
            trackPos = currentPosition;
        }
        if (gamepad1.rightBumperWasPressed()) {
            currentPosition = trackPos;
        }


        testServo.setPosition(currentPosition);

        telemetry.addLine("a - increment by 0.1\n" +
                "b - increment by 0.01\n" +
                "x - set servo to 1\n" +
                "y - set servo to 0\n" +
                "right bumper - track a specific position\n" +
                "left bumper - set the servo to the tracked position (default 0)");
        telemetry.addLine(""); // add a space to seperate
        telemetry.addData("Current Position", currentPosition);
        telemetry.addData("Tracked Position", trackPos);

        telemetry.update();

    }

}
