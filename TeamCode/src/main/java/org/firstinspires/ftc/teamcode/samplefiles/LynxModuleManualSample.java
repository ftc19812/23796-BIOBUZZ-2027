package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.List;

@TeleOp(name = "Manual Bulk Cache")
public class LynxModuleManualSample extends OpMode {

    private List<LynxModule> hubs;

    @Override
    public void init() {

        hubs = hardwareMap.getAll(LynxModule.class);

        for (LynxModule hub : hubs) {
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }

    @Override
    public void loop() {

        for (LynxModule hub : hubs) {
            hub.clearBulkCache();
        }

        telemetry.addData("Encoder",
                hardwareMap.get(DcMotor.class, "leftMotor")
                        .getCurrentPosition());

        telemetry.update();
    }
}
