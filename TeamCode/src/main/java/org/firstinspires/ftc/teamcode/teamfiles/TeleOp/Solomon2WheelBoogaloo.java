package org.firstinspires.ftc.teamcode.teamfiles.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Solomon2WheelBoogaloo extends OpMode {

    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;


    ColorSensor beeEyes;
    DcMotorEx fixedWheel;
    DcMotorEx moveWheel;
    Servo adjustServo;


    @Override
    public void init() {
        fixedWheel = hardwareMap.get(DcMotorEx.class, "nomotionWheel");
        moveWheel = hardwareMap.get(DcMotorEx.class, "motionWheel");
        beeEyes = hardwareMap.get(ColorSensor.class, "honeyEyes");
        adjustServo = hardwareMap.get(Servo.class, "moveWheel");
    }

    @Override
    public void loop() {
        // while a is held
        // fixedWheel and moveWheel are constantly running
        // colorsensor checks for the color
        // the servo adjusts depending on the color
        if(gamepad1.a){
            fixedWheel.setVelocity(2000);
            moveWheel.setVelocity(2500);


            // detects red
            if(beeEyes.red() > 200 && beeEyes.green() <= 140 && beeEyes.blue() <= 140){
                adjustServo.setPosition(1);
            }

            // detects yellow
            if(beeEyes.red() >= 180 && beeEyes.green() >= 180 && beeEyes.blue() < 130) {
                adjustServo.setPosition(0);
            }

        }
    }
}
