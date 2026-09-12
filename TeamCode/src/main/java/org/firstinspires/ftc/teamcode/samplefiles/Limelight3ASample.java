package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Limelight Example")
public class Limelight3ASample extends OpMode {

    private Limelight3A limelight;

    @Override
    public void init() {

        limelight = hardwareMap.get(Limelight3A.class,"limelight");

        limelight.start();

        limelight.pipelineSwitch(0);
    }

    @Override
    public void loop() {

        LLResult result = limelight.getLatestResult();

        if (result.isValid()) {

            telemetry.addData("TX", result.getTx());

            telemetry.addData("TY", result.getTy());

            telemetry.addData("Area", result.getTa());
        }
        else {

            telemetry.addLine("No Target");
        }

        telemetry.update();
    }
}
