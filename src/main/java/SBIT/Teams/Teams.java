package SBIT.Teams;

import SBIT.Utilities;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Teams {
    public static void setteams() throws IOException {
        String team1name = TeamsController.controller.textboxTeam1.getText();
        String team2name = TeamsController.controller.textboxTeam2.getText();
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
        Object[] teamslistObject = TeamsController.controller.listTeams.getItems().toArray();
        String[] teamslistString = new String[teamslistObject.length];
        System.arraycopy(teamslistObject, 0, teamslistString, 0, teamslistObject.length);
        FileUtils.writeStringToFile(new File("saves/teams.txt"), Arrays.toString(teamslistString), StandardCharsets.UTF_8);
    }

    public static void loadTeams() throws IOException {
        String file = FileUtils.readFileToString(new File("saves/teams.txt"), StandardCharsets.UTF_8);
        String string = file.substring(1, file.length()-1);
        String[] array = string.split(", ");
        TeamsController.controller.listTeams.getItems().addAll(array);
        for (int i = 0; i < array.length; i++) {
            return;
        }

    }

    private static void writeteam(String names, String team) {
        String[] array = names.split("\n");
        for (int i = 0; i < array.length; i++) {
            Utilities.writeToTxt(team + "_player" + (i + 1), array[i]);
        }
    }
}
