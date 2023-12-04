package deviser;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

import java.util.logging.LogManager;

public class GlobalEventListener implements NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener {

    private boolean isEventListenerOn = false;

    public void initiateEventListener() {
        // Switch Logs
        isEventListenerOn = true;
        LogManager.getLogManager().reset();
        if (!GlobalScreen.isNativeHookRegistered()) {
            try {
                // Register hook
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        // Register key listener
        GlobalScreen.addNativeKeyListener(new GlobalEventListener());
        GlobalScreen.addNativeMouseListener(new GlobalEventListener());
        GlobalScreen.addNativeMouseWheelListener(new GlobalEventListener());
        GlobalScreen.addNativeMouseMotionListener(new GlobalEventListener());
    }

    public boolean isEventListenerOn(){
        return this.isEventListenerOn;
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeKeyEvent.paramString()
                + "," + nativeKeyEvent.getRawCode());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeKeyEvent.paramString()
                + "," + nativeKeyEvent.getRawCode());
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeKeyEvent.paramString()
                + "," + nativeKeyEvent.getRawCode());
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeMouseEvent.paramString()
                + "," + TabularEventFileWriter.getRGB(nativeMouseEvent.paramString()));
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeMouseEvent.paramString()
                + "," + TabularEventFileWriter.getRGB(nativeMouseEvent.paramString()));
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeMouseEvent.paramString());
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeMouseEvent.paramString()
                + "," + TabularEventFileWriter.getRGB(nativeMouseEvent.paramString()));
    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeMouseEvent.paramString()
                + "," + TabularEventFileWriter.getRGB(nativeMouseEvent.paramString()));
    }

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent nativeMouseWheelEvent) {
        TabularEventFileWriter.bufferFileWriter(nativeMouseWheelEvent.paramString()
                + "," + TabularEventFileWriter.getRGB(nativeMouseWheelEvent.paramString()));
    }

}
