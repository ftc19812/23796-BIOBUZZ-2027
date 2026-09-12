package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "CR Servo Sample")
public class CRServoSample extends OpMode {

    private CRServo intake;

    @Override
    public void init() {
        intake = hardwareMap.get(CRServo.class, "intake");
    }

    @Override
    public void loop() {

        if (gamepad1.right_trigger > 0.1) {
            intake.setPower(1.0);
        }
        else if (gamepad1.left_trigger > 0.1) {
            intake.setPower(-1.0);
        }
        else {
            intake.setPower(0.0);
        }

        telemetry.addData("Power", intake.getPower());
        telemetry.update();
    }
}