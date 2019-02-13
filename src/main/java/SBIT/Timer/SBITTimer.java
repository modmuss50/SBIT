package SBIT.Timer;

import SBIT.Utilities;

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
        if (hidden) {
            Utilities.writeToTxt("timer", "");
            return;
        }
        if (seconds > 0) {
            seconds--;
            int mins = seconds / 60;
            int secs = seconds % 60;
            String output = String.format("%02d:%02d", mins, secs);
            Utilities.writeToTxt("timer", output);
            TimerController.controller.currentTime.setText(output);
        }
    }

}
