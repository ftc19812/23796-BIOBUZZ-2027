package org.firstinspires.ftc.teamcode.samplefiles;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Linear OpMode Sample")
public class LinearOpModeSimple extends LinearOpMode {
    @Override
    public void runOpMode() {

        // this is where code for initializing motors and stuff would be.

        waitForStart(); // waits until the start is pressed

        while (opModeIsActive()) {
            System.out.println("OpMode is currently active");
            // do something while the opMode is active
            // usually, drive code or autonomous code would be here
        }
    }
}


