package org.firstinspires.ftc.teamcode.teamfiles.Test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
//import com.qualcomm.robotcore.hardware.D;

import java.util.ArrayList;
import java.util.Collection;

class TrackedMotorData {
    DcMotorEx motor;
    String name;
    double currentPower = 0.0;
    double currentVelocity = 0.0;
    double trackPower = 0.0;
    double trackVelocity = 0.0;
    public TrackedMotorData(DcMotorEx motor, String name) {
        this.motor = motor;
        this.name = name;
    }
}
@TeleOp(name = "Group Motor Increment Test", group = "Test")
public class MotorTestAll extends OpMode {
    Collection<DcMotorEx> allMotors;
    ArrayList<TrackedMotorData> allMotorData = new ArrayList<>();
    TrackedMotorData currentMotor;
    int motorIndex = 0;
    boolean velocityMode = false;
    @Override
    public void init() {
        allMotors = hardwareMap.getAll(DcMotorEx.class);
        for (DcMotorEx motor : allMotors) {
            // Don't set Motors to any positions initially
            allMotorData.add(new TrackedMotorData(
                    motor, motor.getDeviceName()
            ));
        }
    }

    @Override
    public void loop() {
        if (allMotors.isEmpty()) {
            telemetry.addLine("No Motors detected");
            telemetry.update();
            return;
        }
        // dpad up - switch from velocity mode -> power mode
        // dpad right - go to the next Motor in list
        // dpad left - go to the previous Motor in list
        // dpad down - set power/velocity to 0
        // a - increment by 0.1 / 200
        // b - increment by 0.01 / 20
        // x - increment by -0.1 / -200
        // y - increment by -0.01 / -20
        // right bumper - track a specific power/velocity
        // left bumper - set the Motor to the tracked power/velocity (default 0)
        if (gamepad1.dpadLeftWasPressed()) {
            motorIndex--;
            if (motorIndex < 0) motorIndex = allMotors.size() - 1;
            SetCurrentMotor(motorIndex);
        }
        if (gamepad1.dpadRightWasPressed()) {
            motorIndex++;
            motorIndex %= allMotors.size();
            SetCurrentMotor(motorIndex);
        }
        if (gamepad1.dpadDownWasPressed()) {
            if (velocityMode) {
                currentMotor.currentVelocity = 0;
            } else {
                currentMotor.currentPower = 0;
            }
        }
        if (gamepad1.dpadUpWasPressed()) {
            velocityMode = !velocityMode;
        }
        if (gamepad1.aWasPressed()) {
            if (velocityMode) {
                currentMotor.currentVelocity += 200;
            } else {
                currentMotor.currentPower += 0.1;
            }
        }

        if (gamepad1.bWasPressed()) {
            if (velocityMode) {
                currentMotor.currentVelocity += 20;
            } else {
                currentMotor.currentPower += 0.01;
            }
        }

        if (gamepad1.xWasPressed()) {
            if (velocityMode) {
                currentMotor.currentVelocity -= 200;
            } else {
                currentMotor.currentPower -= 0.1;
            }

        }
        if (gamepad1.yWasPressed()) {
            if (velocityMode) {
                currentMotor.currentVelocity -= 20;
            } else {
                currentMotor.currentPower -= 0.01;
            }

        }
        if (gamepad1.leftBumperWasPressed()) {
            if (velocityMode) {
                currentMotor.trackVelocity = currentMotor.currentVelocity;
            } else {
                currentMotor.trackPower = currentMotor.currentPower;
            }
        }
        if (gamepad1.rightBumperWasPressed()) {
            if (velocityMode) {
                currentMotor.currentVelocity = currentMotor.trackVelocity;
            } else {
                currentMotor.currentPower = currentMotor.trackPower;
            }
        }

        currentMotor.currentPower = Math.min(currentMotor.currentPower, 1.0);
        currentMotor.currentPower = Math.max(currentMotor.currentPower, -1.0);

        currentMotor.motor.setPower(currentMotor.currentPower);

        telemetry.addLine(
        "dpad right - go to the next Motor in list\n" +
                "dpad left - go to the previous Motor in list\n"+
                "a - increment by 0.1\n" +
                "b - increment by 0.01\n" +
                "x - set Motor to 1\n" +
                "y - set Motor to 0\n" +
                "right bumper - track a specific position\n" +
                "left bumper - set the Motor to the tracked position (default 0)\n" +
                " ");
        telemetry.addData("Current Motor", currentMotor.name);
        telemetry.addData("Mode", velocityMode ? "Velocity" : "Power");
        if (velocityMode) {
            telemetry.addData("Current Velocity", currentMotor.currentVelocity);
            telemetry.addData("Tracked Velocity", currentMotor.trackVelocity);
        } else {
            telemetry.addData("Current Power", currentMotor.currentPower);
            telemetry.addData("Tracked Power", currentMotor.trackPower);
        }

        telemetry.update();

    }

    public void SetCurrentMotor(int index) {
        currentMotor = allMotorData.get(index);
    }

}
