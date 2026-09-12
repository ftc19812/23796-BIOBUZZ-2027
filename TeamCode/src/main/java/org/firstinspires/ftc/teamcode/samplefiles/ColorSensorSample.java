package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

public class ColorSensorSample extends OpMode {

    private ColorSensor color;

    @Override
    public void init() {
        color = hardwareMap.get(ColorSensor.class, "color");
    }

    @Override
    public void loop() {

        if (color.red() > 200 && color.red() > color.blue() && color.red() > color.green()) {
            // since red intensity is > 200, and red > both blue and green,
            // there is a high probability that the object is red.
            telemetry.addLine("Red Object Detected!");
        }

        telemetry.addData("Red", color.red());
        telemetry.addData("Green", color.green());
        telemetry.addData("Blue", color.blue());
        telemetry.addData("Alpha", color.alpha());

        telemetry.update();
    }
}