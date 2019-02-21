package SBIT.Schedule;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ScheduleMatchLine {
    public HBox hBox = new HBox(5);
    public Label matchName = new Label();
    public ComboBox<String> team1ComboBox = new ComboBox<>();
    public CheckBox vsCheck = new CheckBox();
    public Label vs = new Label();
    public ComboBox<String> team2ComboBox = new ComboBox<>();
    public ComboBox<String> time = new ComboBox<>();

    public HBox makeHBox(int matchNumber){
        matchName.setText(matchNumber + ":");
        matchName.setPrefHeight(25);
        team1ComboBox.setPrefWidth(180);
        team1ComboBox.setPromptText("Team 1");
        vs.setText("vs.");
        vs.setPrefHeight(25);
        vsCheck.setText("vs.");
        vsCheck.setPrefHeight(25);
        vsCheck.setSelected(true);
        team2ComboBox.setPrefWidth(180);
        team2ComboBox.setPromptText("Team 2");

        try {
            loadTeams();
        } catch (IOException e) {
            e.printStackTrace();
        }

        time.setPrefWidth(71);
        time.setPromptText("Time");
        for (int i = 12; i < 23; i++) {
            String hour = String.format("%02d", i);
            time.getItems().add(hour+":00");
            time.getItems().add(hour+":15");
            time.getItems().add(hour+":30");
            time.getItems().add(hour+":45");
        }

        hBox.getChildren().add(matchName);
        hBox.getChildren().add(team1ComboBox);
        hBox.getChildren().add(vsCheck);
        hBox.getChildren().add(team2ComboBox);
        hBox.getChildren().add(time);
        return hBox;
    }
    public void loadTeams() throws IOException {
        File file = new File("saves/teams.txt");
        if(!file.exists()){
            return;
        }
        String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String[] array = string.split("\n");
        team1ComboBox.getItems().addAll(array);
        team2ComboBox.getItems().addAll(array);
    }
}
