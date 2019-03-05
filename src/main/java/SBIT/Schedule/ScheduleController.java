package SBIT.Schedule;

import SBIT.Utilities;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class ScheduleController {
    public static ScheduleController controller;
    public ComboBox<String> gamesComboBox;
    public ComboBox<String> currentGameComboBox;
    public VBox scheduleVBox;
    public HashMap<Integer, ScheduleMatchLine> hashMap = new HashMap<>();

    @FXML
    public void initialize() throws IOException {
        controller = this;
        gamesComboBox.getItems().addAll(
                "2", "3", "4"
        );
    }

    public void gamesComboBoxAction(ActionEvent actionEvent) {
        if (gamesComboBox.getValue() != null) {
            currentGameComboBox.getItems().clear();
            for (int i = 1; i <= Integer.parseInt(gamesComboBox.getValue()); i++) {
                currentGameComboBox.getItems().add("" + i);
            }
            currentGameComboBox.disableProperty().setValue(false);

            scheduleVBox.getChildren().clear();
            scheduleVBox.setSpacing(20);
            hashMap.clear();

            for (int i = 1; i <= Integer.parseInt(gamesComboBox.getValue()); i++) {
                ScheduleMatchLine scheduleMatchLine = new ScheduleMatchLine();
                scheduleVBox.getChildren().add(scheduleMatchLine.makeHBox(i));
                hashMap.put(i, scheduleMatchLine);
            }
        } else {
            currentGameComboBox.disableProperty().setValue(true);
        }
    }

    public void setImageButtonClicked(MouseEvent mouseEvent) {
        Schedule.setScheduleImage();

        for (int i = 1; i <= 4; i++) {
            String output = "";
            String time = "";
            if (hashMap.containsKey(i)) {
                ScheduleMatchLine scheduleMatchLine = hashMap.get(i);
                if(scheduleMatchLine.vsCheck.isSelected()){
                    output = scheduleMatchLine.team1ComboBox.getValue() + " vs " + scheduleMatchLine.team2ComboBox.getValue();
                } else {
                    output = scheduleMatchLine.team1ComboBox.getValue();
                }
                time = scheduleMatchLine.time.getValue();
            }
            Utilities.writeToTxt("scheduleMatch" + i, output);
            Utilities.writeToTxt("scheduleMatch" + i + "Time", time);
        }
        for (int i = 1; i <= 4; i++) {
            Utilities.writeToTxt("scheduleMatchNumber" + i, "");
        }
        for (int i = 1; i <= Integer.parseInt(gamesComboBox.getValue()); i++) {
            Utilities.writeToTxt("scheduleMatchNumber" + i, ""+i);
        }
    }
}
