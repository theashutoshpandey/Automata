package studio;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/*
 *@author Ashutosh Pandey
 */

public class NativeKeyHandler {

    private static Robot robot;
    private static NativeKeyHandler instance;

    private NativeKeyHandler() {
    }

    public static NativeKeyHandler getKeyHandler() {
        if (instance == null)
            instance = new NativeKeyHandler();
        return instance;
    }

    private Robot getRobot() {
        if (robot == null) {
            try {
                robot = new Robot();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return robot;
    }

    public void nativeKeyPress(String[] args) {
        try {
            robot = this.getRobot();
            if (args[2].contains("Ctrl"))
                robot.keyPress(KeyEvent.VK_CONTROL);
            else if (args[2].contains("Alt"))
                robot.keyPress(KeyEvent.VK_ALT);
            else if (args[2].contains("Enter"))
                robot.keyPress(KeyEvent.VK_ENTER);
            else if (args[2].contains("Period"))
                robot.keyPress(KeyEvent.VK_PERIOD);
            else if (args[2].contains("Comma"))
                robot.keyPress(KeyEvent.VK_COMMA);
            else if (args[2].contains("Back_Slash"))
                robot.keyPress(KeyEvent.VK_BACK_SLASH);
            else if (args[2].contains("Slash"))
                robot.keyPress(KeyEvent.VK_SLASH);
            else if (args[2].contains("Semicolon"))
                robot.keyPress(KeyEvent.VK_SEMICOLON);
            else if (args[2].contains("Minus"))
                robot.keyPress(KeyEvent.VK_MINUS);
            else if (args[2].contains("Equals"))
                robot.keyPress(KeyEvent.VK_EQUALS);
            else if (args[2].contains("Back_Quote"))
                robot.keyPress(KeyEvent.VK_BACK_QUOTE);
            else if (args[2].contains("Open_Bracket"))
                robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
            else if (args[2].contains("Close_Bracket"))
                robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
            else if (args[2].contains("Home"))
                robot.keyPress(KeyEvent.VK_HOME);
            else if (args[2].contains("End"))
                robot.keyPress(KeyEvent.VK_END);
            else if (args[2].contains("Insert"))
                robot.keyPress(KeyEvent.VK_INSERT);
            else if (args[2].contains("Delete"))
                robot.keyPress(KeyEvent.VK_DELETE);
            else if (args[2].contains("Meta"))
                robot.keyPress(KeyEvent.VK_WINDOWS);
            else if (args[2].contains("Shift") || args[2].contains("Unknown"))
                robot.keyPress(KeyEvent.VK_SHIFT);
            else {
                String key = args[args.length - 2];
                this.nativeKeyPress(key);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "--" + args[2]);
        }
    }

    public void nativeKeyRelease(String[] args) {
        try {
            robot = this.getRobot();
            if (args[2].contains("Ctrl"))
                robot.keyRelease(KeyEvent.VK_CONTROL);
            else if (args[2].contains("Alt"))
                robot.keyRelease(KeyEvent.VK_ALT);
            else if (args[2].contains("Enter"))
                robot.keyRelease(KeyEvent.VK_ENTER);
            else if (args[2].contains("Period"))
                robot.keyRelease(KeyEvent.VK_PERIOD);
            else if (args[2].contains("Comma"))
                robot.keyRelease(KeyEvent.VK_COMMA);
            else if (args[2].contains("Back_Slash"))
                robot.keyRelease(KeyEvent.VK_BACK_SLASH);
            else if (args[2].contains("Slash"))
                robot.keyRelease(KeyEvent.VK_SLASH);
            else if (args[2].contains("Semicolon"))
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
            else if (args[2].contains("Minus"))
                robot.keyRelease(KeyEvent.VK_MINUS);
            else if (args[2].contains("Equals"))
                robot.keyRelease(KeyEvent.VK_EQUALS);
            else if (args[2].contains("Back_Quote"))
                robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
            else if (args[2].contains("Open_Bracket"))
                robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
            else if (args[2].contains("Close_Bracket"))
                robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
            else if (args[2].contains("Home"))
                robot.keyRelease(KeyEvent.VK_HOME);
            else if (args[2].contains("End"))
                robot.keyRelease(KeyEvent.VK_END);
            else if (args[2].contains("Insert"))
                robot.keyRelease(KeyEvent.VK_INSERT);
            else if (args[2].contains("Delete"))
                robot.keyRelease(KeyEvent.VK_DELETE);
            else if (args[2].contains("Meta"))
                robot.keyRelease(KeyEvent.VK_WINDOWS);
            else if (args[2].contains("Shift") || args[2].contains("Unknown"))
                robot.keyRelease(KeyEvent.VK_SHIFT);
            else {
                String key = args[args.length - 2];
                this.nativeKeyRelease(key);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "--" + args[2]);
        }
    }

    public void nativeKeyPress(String keyInt) {
        try {
            robot = this.getRobot();
            robot.keyPress(Integer.parseInt(keyInt));
        } catch (Exception e) {
            System.out.println(e.getMessage() + "--" + keyInt);
        }
    }

    // Native Key Release
    public void nativeKeyRelease(String keyInt) {
        try {
            robot = this.getRobot();
            robot.keyRelease(Integer.parseInt(keyInt));
        } catch (Exception e) {
            System.out.println(e.getMessage() + "--" + keyInt);
        }
    }

}
