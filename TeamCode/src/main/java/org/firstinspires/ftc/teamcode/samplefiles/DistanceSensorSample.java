package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp(name = "Distance Sensor Sample")
public class DistanceSensorSample extends OpMode {

    private DistanceSensor distance;

    @Override
    public void init() {
        distance = hardwareMap.get(DistanceSensor.class, "distance");
    }

    @Override
    public void loop() {

        double cm = distance.getDistance(DistanceUnit.CM);

        telemetry.addData("Distance (cm)", cm);

        if (cm < 10) {
            telemetry.addLine("Object Nearby");
        }

        telemetry.update();
    }
}
