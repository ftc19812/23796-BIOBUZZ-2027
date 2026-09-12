package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

@TeleOp(name = "IMU Sample")
public class IMUSample extends OpMode {

    private IMU imu;

    @Override
    public void init() {

        imu = hardwareMap.get(IMU.class, "imu");

        imu.initialize(
                new IMU.Parameters(
                        new RevHubOrientationOnRobot(
                                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
                        )
                )
        );
    }

    @Override
    public void loop() {

        double heading = imu.getRobotYawPitchRollAngles()
                .getYaw(AngleUnit.DEGREES);

        telemetry.addData("Heading", heading);
        telemetry.update();
    }
}