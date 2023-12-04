package studio;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

/*
 *@author Ashutosh Pandey
 */

public class NativeMouseHandler {

    private Robot robot;
    private static NativeMouseHandler instance;

    public static NativeMouseHandler getMouseHandler() {
        if (instance == null)
            instance = new NativeMouseHandler();
        return instance;
    }

    private Robot getRobot() {
        if (robot == null) {
            try {
                robot = new Robot();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return robot;
    }

    public void nativeMouseMove(String x, String y) {
        try {
            robot = this.getRobot();
            robot.mouseMove(Integer.parseInt(x), Integer.parseInt(y));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nativeMouseClickLeft(String x, String y) {
        int mask = InputEvent.BUTTON1_MASK;
        try {
            robot = this.getRobot();
            robot.mouseMove(Integer.parseInt(x), Integer.parseInt(y));
            robot.mousePress(mask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nativeMouseReleaseLeft(String x, String y) {
        int mask = InputEvent.BUTTON1_MASK;
        try {
            robot = this.getRobot();
            robot.mouseMove(Integer.parseInt(x), Integer.parseInt(y));
            robot.mouseRelease(mask);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nativeMouseClickRight(String x, String y) {
        try {
            robot = this.getRobot();
            robot.mouseMove(Integer.parseInt(x), Integer.parseInt(y));
            robot.mousePress(KeyEvent.BUTTON1_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nativeMouseReleaseRight(String x, String y) {
        try {
            robot = this.getRobot();
            robot.mouseMove(Integer.parseInt(x), Integer.parseInt(y));
            robot.mousePress(KeyEvent.BUTTON1_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nativeMouseWheel(String x, String y, String wheelAmt) {
        try {
            robot = this.getRobot();
            robot.mouseMove(Integer.parseInt(x), Integer.parseInt(y));
            robot.mouseWheel(Integer.parseInt(wheelAmt));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
