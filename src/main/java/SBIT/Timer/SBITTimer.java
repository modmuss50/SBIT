package SBIT.Timer;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("ALL")
public class SBITTimer {
    public static int seconds = 0;
    public static boolean hidden = true;


    public static void setup() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ticker();
            }
        }, 0, 1000);
    }

    public static void ticker() {
        if (hidden){
            try {
                FileUtils.writeStringToFile(new File("timer.txt"), "", StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
       if (seconds > 0){
           seconds --;
           int mins = seconds / 60;
           int secs = seconds % 60;
           String output = String.format("%02d:%02d", mins, secs);

           try {
               FileUtils.writeStringToFile(new File("timer.txt"), output, StandardCharsets.UTF_8);
           } catch (IOException e) {
               e.printStackTrace();
           }
           TimerController.controller.currentTime.setText(output);
       }
    }

}
