package SBIT.Scoreboard;


import java.util.Timer;
import java.util.TimerTask;


public class GSIHandler {
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

    }
}
