package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.TouchSensor;

@TeleOp(name = "Touch Sensor Sample")
public class TouchSensorSample extends OpMode {

    private TouchSensor touch;

    @Override
    public void init() {
        touch = hardwareMap.get(TouchSensor.class, "touch");
    }

    @Override
    public void loop() {

        if (touch.isPressed()) {
            telemetry.addLine("Button Pressed");
        }
        else {
            telemetry.addLine("Button Released");
        }

        telemetry.update();
    }
}