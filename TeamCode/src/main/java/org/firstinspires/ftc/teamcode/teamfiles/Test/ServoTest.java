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


    }

}
