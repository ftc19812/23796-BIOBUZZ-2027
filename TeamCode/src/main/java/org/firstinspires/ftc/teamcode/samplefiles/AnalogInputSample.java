package org.firstinspires.ftc.teamcode.samplefiles;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;

@TeleOp(name = "Analog Input Sample")
public class AnalogInputSample extends OpMode {

    private AnalogInput analog;

    @Override
    public void init() {
        analog = hardwareMap.get(AnalogInput.class, "potentiometer");
    }

    @Override
    public void loop() {

        telemetry.addData("Voltage", analog.getVoltage());

        telemetry.addData("Max Voltage", analog.getMaxVoltage());

        telemetry.update();
    }
}
