package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@TeleOp(name = "DC Motor Sample")
public class DcMotorSample extends OpMode {
    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    Servo arm;
    boolean useVelocity = false;
    @Override
    public void init() {

        // use hardwareMap to map all the motors to hardware
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

        // let's say frontLeft and backRight were installed backwards. Let's reverse them!
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        // stop and reset encoders in all wheels from the beginning!
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // determine the mode of the motors depending on the boolean variable
        DetermineRunMode();

        // BRAKE is the default, but this is mostly just to display.
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    @Override
    public void loop() {

        if (gamepad1.rightBumperWasPressed()) {
            useVelocity = !useVelocity; // reverse the boolean
            frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            DetermineRunMode(); // determine the runMode
        }



        if (useVelocity) {
            frontLeft.setVelocity(0);
            frontRight.setVelocity(0);
            backLeft.setVelocity(0);
            backRight.setVelocity(0);

            if (gamepad1.a) {
                frontLeft.setVelocity(1500);
            } else if (gamepad1.b) {
                frontRight.setVelocity(1500);
            } else if (gamepad1.x) {
                backLeft.setVelocity(1500);
            } else if (gamepad1.y) {
                backRight.setVelocity(1500);
            }
        } else {
            frontLeft.setPower(0);
            frontRight.setPower(0);
            backLeft.setPower(0);
            backRight.setPower(0);

            if (gamepad1.a) {
                frontLeft.setPower(1.0);
            } else if (gamepad1.b) {
                frontRight.setPower(1.0);
            } else if (gamepad1.x) {
                backLeft.setPower(1.0);
            } else if (gamepad1.y) {
                backRight.setPower(1.0);
            }
        }

        telemetry.addData("Current: ", frontLeft.getCurrent(CurrentUnit.AMPS));
        telemetry.addData("Left Front Wheel Power: ", frontLeft.getPower());
        telemetry.addData("Left Front Wheel Vel: ", frontLeft.getVelocity());
    }

    public void DetermineRunMode() {
        if (useVelocity) {
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        } else {
            frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }



}
