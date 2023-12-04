package studio;

import java.awt.*;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class RecorderUtils {

    private static String file_name;
    private static ScreenRecorder screenRecorder;
    private static boolean isRecordingOn = false;

    public boolean isRecordingOn() {
        return isRecordingOn;
    }

    public void startRecording() {
        try {
            isRecordingOn = true;
            GraphicsConfiguration gc = GraphicsEnvironment
                    .getLocalGraphicsEnvironment()
                    .getDefaultScreenDevice()
                    .getDefaultConfiguration();

            screenRecorder = new ScreenRecorder(gc,
                    gc.getBounds(),
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, 24, FrameRateKey, Rational.valueOf(30),
                            QualityKey, 1.0f,
                            KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "white", FrameRateKey, Rational.valueOf(15)),
                    null,
                    new File(System.getProperty("user.home") + File.separator + "AutoMata"
                            + File.separator + "Output" + File.separator));
            screenRecorder.start();
            file_name = screenRecorder.getCreatedMovieFiles().get(0).toString();
        } catch (Exception e) {
            UserCaseImpl.cout.setText(e.getMessage());
        }
    }

    public void stop(String scriptName) {
        try {
            screenRecorder.stop();
            File tempFile = new File(file_name);
            tempFile.renameTo(new File(tempFile.getAbsolutePath().replace("ScreenRecording", scriptName)));
            isRecordingOn = false;
        } catch (Exception e) {
            UserCaseImpl.cout.setText(e.getMessage());
        }
    }

}
