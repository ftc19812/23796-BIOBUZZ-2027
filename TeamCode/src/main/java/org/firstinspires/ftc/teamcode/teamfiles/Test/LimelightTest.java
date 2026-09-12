package org.firstinspires.ftc.teamcode.teamfiles.Test;

import com.qualcomm.hardware.limelightvision.LLFieldMap;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.LimelightManager;

import java.util.List;

@TeleOp(name = "Limelight Test", group = "Test")
public class LimelightTest extends OpMode {
    Limelight3A limelightObject;
    LimelightManager limelight;
    @Override
    public void init() {
        limelightObject = hardwareMap.get(Limelight3A.class, "limelight");
        limelight = new LimelightManager(limelightObject, telemetry);
        limelight.start();
    }

    @Override
    public void loop() {
        LLResult result = limelight.getLatestResult();
        String tagsStringList = "";
        if (result.isValid()) {
            // the valid is result
//            List<LLResultTypes.FiducialResult> aprilTagList = limelight.getAprilTagInfo(result);
//            for (LLResultTypes.FiducialResult aprilTagData : aprilTagList) {
//
//            }
        }

        limelight.telemetryAprilTags(result);
        telemetry.update();
    }

    @Override
    public void stop() {
        limelight.stop();
    }


}
