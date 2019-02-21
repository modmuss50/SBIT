package SBIT.Teams;

import SBIT.Utilities;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Teams {
    public static void setteams() throws IOException {
        String team1name = TeamsController.controller.team1ComboBox.getValue();
        String team2name = TeamsController.controller.team2ComboBox.getValue();
        String team1players = TeamsController.controller.textareaTeam1.getText();
        String team2players = TeamsController.controller.textareaTeam2.getText();
        Utilities.writeToTxt("team1_name", team1name);
        Utilities.writeToTxt("team2_name", team2name);
        Utilities.writeToTxt("team1_players", team1players);
        Utilities.writeToTxt("team2_players", team2players);
        writeteam(team1players, "team1");
        writeteam(team2players, "team2");
    }

    public static void saveTeams() throws IOException {
        String output = String.join("\n", TeamsController.controller.listTeams.getItems());
        FileUtils.writeStringToFile(new File("saves/teams.txt"), output, StandardCharsets.UTF_8);
    }

    public static void loadTeams() throws IOException {
    	File file = new File("saves/teams.txt");
    	if(!file.exists()){
    		return;
	    }
        String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String[] array = string.split("\n");
        TeamsController.controller.listTeams.getItems().clear();
        TeamsController.controller.listTeams.getItems().addAll(array);

    }

    public static void fillComboBoxItems() throws IOException {
        TeamsController.controller.team1ComboBox.getItems().clear();
        TeamsController.controller.team2ComboBox.getItems().clear();
        File file = new File("saves/teams.txt");
        if(!file.exists()){
            return;
        }
        String string = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String[] array = string.split("\n");
        TeamsController.controller.team1ComboBox.getItems().addAll(array);
        TeamsController.controller.team2ComboBox.getItems().addAll(array);
    }

    private static void writeteam(String names, String team) {
        String[] array = names.split("\n");
        for (int i = 0; i < array.length; i++) {
            Utilities.writeToTxt(team + "_player" + (i + 1), array[i]);
        }
    }
}
