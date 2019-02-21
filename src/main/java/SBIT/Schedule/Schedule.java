package SBIT.Schedule;

import SBIT.Utilities;
import com.sun.javafx.fxml.builder.JavaFXSceneBuilder;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.*;

public class Schedule {
    public static void setScheduleImage() {
        File images = new File("Files/Images");

        int games = Integer.parseInt(ScheduleController.controller.gamesComboBox.getValue());
        int currentgame = Integer.parseInt(ScheduleController.controller.currentGameComboBox.getValue());
        String resourceName = "schedule/" + "games" + games + "-" + "current" + currentgame + ".png";

        Utilities.replacePngFromResource(resourceName, "scheduleimage");
    }

    public static void setScheduleText() {

    }
}
