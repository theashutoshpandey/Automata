package deviser;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class TabularEventFileWriter {

    public static String testFilePath;
    public static boolean isAllowedToWrite = true;
    private static final String secretKey = "JHKLXABYZGF!!!!";

    public static void bufferFileWriter(String str) {

        if (!isAllowedToWrite)
            return;

        synchronized (TabularEventFileWriter.class) {
            try {
                File file = new File(testFilePath);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(AESUtils.encrypt(str + "," + System.currentTimeMillis(), secretKey) + "\n");
                // bufferedWriter.write(str + "," + System.currentTimeMillis() + "\n");
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int getRGB(String str) {
        String[] str1 = str.replaceAll("\\s+", "_").split(",");
        String x = str1[1].replaceAll("^.", "");
        String y = str1[2].replaceAll(".$", "");
        int rgb = 0;
        try {
            Robot r = new Robot();
            Color color = r.getPixelColor(Integer.parseInt(x), Integer.parseInt(y));
            rgb = color.getRGB();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rgb;
    }

}
