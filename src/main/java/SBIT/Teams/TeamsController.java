package SBIT.Teams;

import SBIT.Schedule.ScheduleMatchLine;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TeamsController {


    public TextArea textareaTeam1;
    public TextArea textareaTeam2;
    public ListView<String> listTeams;
    public TextField textboxAddTeam;
    public ComboBox<String> team1ComboBox;
    public ComboBox<String> team2ComboBox;
    public static TeamsController controller;


    public void buttonSetClicked(MouseEvent mouseEvent) throws IOException {
        Teams.setteams();
    }

    @FXML
    public void initialize() throws IOException {
        controller = this;
        Teams.loadTeams();
        if (!new File("Files/team1_name.txt").exists()) {
            return;
        }
        String input3 = FileUtils.readFileToString(new File("Files/team1_players.txt"), StandardCharsets.UTF_8);
        String input4 = FileUtils.readFileToString(new File("Files/team2_players.txt"), StandardCharsets.UTF_8);
        textareaTeam1.setText(input3);
        textareaTeam2.setText(input4);
        File file = new File("saves/teams.txt");
        Teams.fillComboBoxItems();
    }

    public void buttonClearClicked(MouseEvent mouseEvent) throws IOException {
        Teams.fillComboBoxItems();
        textareaTeam1.clear();
        textareaTeam2.clear();
    }

    public void addButtonClicked(MouseEvent mouseEvent) throws IOException {
        if(!textboxAddTeam.getText().isEmpty()){
            listTeams.getItems().add(textboxAddTeam.getText());
            textboxAddTeam.setText("");
            Teams.saveTeams();
        }
    }

    public void removeButtonClicked(MouseEvent mouseEvent) throws IOException {
        listTeams.getItems().remove(listTeams.getSelectionModel().getSelectedItem());
        Teams.saveTeams();
    }

}
