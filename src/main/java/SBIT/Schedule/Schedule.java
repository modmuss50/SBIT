package SBIT.Schedule;

import SBIT.Utilities;

import java.io.*;

public class Schedule {
    public static void setScheduleImage() {
        File images = new File("Files/Images");

        int games = Integer.parseInt(ScheduleController.controller.gamesComboBox.getValue());
        int currentgame = Integer.parseInt(ScheduleController.controller.currentGameComboBox.getValue());
        String resourceName = "schedule/" + "games" + games + "-" + "current" + currentgame + ".png";

        Utilities.replacePng(resourceName, "scheduleimage");
    }
}
