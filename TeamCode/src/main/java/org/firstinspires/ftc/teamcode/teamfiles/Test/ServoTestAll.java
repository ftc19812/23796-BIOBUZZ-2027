package org.firstinspires.ftc.teamcode.teamfiles.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class TrackedServoData {
    Servo servo;
    String name;
    double currentPosition = 0.0;
    double trackPos = 0.0;
    public TrackedServoData(Servo servo, String name) {
        this.servo = servo;
        this.name = name;
    }
}
@TeleOp(name = "Group Servo Increment Test", group = "Test")
public class ServoTestAll extends OpMode {
    Collection<Servo> allServos;
    ArrayList<TrackedServoData> allServoData = new ArrayList<>();
    TrackedServoData currentServo;
    int servoIndex = 0;
    double currentPosition = 0.0;
    double trackPos = 0.0;

    @Override
    public void init() {
        allServos = hardwareMap.getAll(Servo.class);
        for (Servo servo : allServos) {
            // Don't set servos to any positions initially
            allServoData.add(new TrackedServoData(
                    servo, servo.getDeviceName()
            ));
        }
    }

    @Override
    public void loop() {
        if (allServos.isEmpty()) {
            telemetry.addLine("No servos detected");
            telemetry.update();
            return;
        }
        // dpad right - go to the next servo in list
        // dpad left - go to the previous servo in list
        // a - increment by 0.1
        // b - increment by 0.01
        // x - set servo to 1
        // y - set servo to 0
        // right bumper - track a specific position
        // left bumper - set the servo to the tracked position (default 0)
        if (gamepad1.dpad_left) {
            servoIndex--;
            if (servoIndex < 0) servoIndex = allServos.size() - 1;
            SetCurrentServo(servoIndex);
        }
        if (gamepad1.dpad_right) {
            servoIndex++;
            servoIndex %= allServos.size();
            SetCurrentServo(servoIndex);
        }

        if (gamepad1.aWasPressed()) {
            currentServo.currentPosition += 0.1;
        }
        if (gamepad1.bWasPressed()) {
            currentServo.currentPosition += 0.01;
        }
        if (gamepad1.xWasPressed()) {
            currentServo.currentPosition = 1;
        }
        if (gamepad1.yWasPressed()) {
            currentServo.currentPosition = 0;
        }
        if (gamepad1.leftBumperWasPressed()) {
            currentServo.trackPos = currentServo.currentPosition;
        }
        if (gamepad1.rightBumperWasPressed()) {
            currentServo.currentPosition = currentServo.trackPos;
        }


        currentServo.servo.setPosition(currentServo.currentPosition);

        telemetry.addLine(
        "dpad right - go to the next servo in list\n" +
                "dpad left - go to the previous servo in list\n"+
                "a - increment by 0.1\n" +
                "b - increment by 0.01\n" +
                "x - set servo to 1\n" +
                "y - set servo to 0\n" +
                "right bumper - track a specific position\n" +
                "left bumper - set the servo to the tracked position (default 0)\n" +
                " ");
        telemetry.addData("Current Servo", currentServo.name);
        telemetry.addData("Current Position", currentServo.currentPosition);
        telemetry.addData("Tracked Position", currentServo.trackPos);

        telemetry.update();

    }

    public void SetCurrentServo(int index) {
        currentServo = allServoData.get(index);
//        currentPosition = currentServo.currentPosition;
//        trackPos = currentServo.trackPos;
    }

}
