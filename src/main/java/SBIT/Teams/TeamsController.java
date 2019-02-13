package SBIT.Teams;

import javafx.fxml.FXML;
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


    public TextField textboxTeam1;
    public TextField textboxTeam2;
    public TextArea textareaTeam1;
    public TextArea textareaTeam2;


    public static TeamsController controller;
    public ListView listTeams;
    public TextField textboxAddTeam;

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
        String input1 = FileUtils.readFileToString(new File("Files/team1_name.txt"), StandardCharsets.UTF_8);
        String input2 = FileUtils.readFileToString(new File("Files/team2_name.txt"), StandardCharsets.UTF_8);
        String input3 = FileUtils.readFileToString(new File("Files/team1_players.txt"), StandardCharsets.UTF_8);
        String input4 = FileUtils.readFileToString(new File("Files/team2_players.txt"), StandardCharsets.UTF_8);
        textboxTeam1.setText(input1);
        textboxTeam2.setText(input2);
        textareaTeam1.setText(input3);
        textareaTeam2.setText(input4);

    }

    public void buttonClearClicked(MouseEvent mouseEvent) {
        textboxTeam1.clear();
        textboxTeam2.clear();
        textareaTeam1.clear();
        textareaTeam2.clear();
    }

    public void addButtonClicked(MouseEvent mouseEvent) throws IOException {
        if(!textboxAddTeam.getText().isEmpty()){
            listTeams.getItems().add(textboxAddTeam.getText());
            textboxAddTeam.setText("");
            Teams.saveTeams();
        } else {
            return;
        }
    }

    public void removeButtonClicked(MouseEvent mouseEvent) throws IOException {
        listTeams.getItems().remove(listTeams.getSelectionModel().getSelectedItem());
        Teams.saveTeams();
    }

    public void listTeamsClicked(MouseEvent mouseEvent) {

    }
}
