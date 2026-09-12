package org.firstinspires.ftc.teamcode.teamfiles.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "4 Wheel Test", group = "Test")
public class FourWheelTest extends OpMode {
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;
    @Override
    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
    }

    @Override
    public void loop() {
        // A = Front Left
        // B = Front Right
        // X = Back Left
        // Y = Back Right

        if (gamepad1.a) {
            frontLeft.setPower(0.2);
        } else {
            frontLeft.setPower(0.0);
        }

        if (gamepad1.b) {
            frontRight.setPower(0.2);
        } else {
            frontRight.setPower(0.0);
        }

        if (gamepad1.x) {
            backLeft.setPower(0.2);
        } else {
            backLeft.setPower(0.0);
        }

        if (gamepad1.y) {
            backRight.setPower(0.2);
        } else {
            backRight.setPower(0.0);
        }
    }
}
