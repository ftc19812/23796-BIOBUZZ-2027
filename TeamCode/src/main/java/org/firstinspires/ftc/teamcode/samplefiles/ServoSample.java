package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo Sample")
public class ServoSample extends OpMode {

    private Servo claw;

    @Override
    public void init() {
        claw = hardwareMap.get(Servo.class, "claw");

        claw.setPosition(0.0); // Start open
    }

    @Override
    public void loop() {

        if (gamepad1.a) {
            claw.setPosition(1.0); // Close
        }

        if (gamepad1.b) {
            claw.setPosition(0.0); // Open
        }

        telemetry.addData("Position", claw.getPosition());
        telemetry.update();
    }
}