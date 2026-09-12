package org.firstinspires.ftc.teamcode.testfiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "TestFile", group = "Samples")

public class SampleFile extends OpMode {
    private int theNumber = 1;
    private CRServo servo;
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        servo.getConnectionInfo();
        telemetry.addData("Status", "Running");
        telemetry.addData("The Number Value", theNumber);
        theNumber += 1;
    }
}
