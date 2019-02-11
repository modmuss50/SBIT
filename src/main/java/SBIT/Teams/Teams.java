package SBIT.Teams;

import SBIT.Utilities;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Teams {
    public static void setteams() throws IOException {
        String team1name = TeamsController.controller.textboxTeam1.getText();
        String team2name = TeamsController.controller.textboxTeam2.getText();
        String team1players = TeamsController.controller.textareaTeam1.getText();
        String team2players = TeamsController.controller.textareaTeam2.getText();
        Utilities.writeToFile("team1_name", team1name);
        Utilities.writeToFile("team2_name", team2name);
        Utilities.writeToFile("team1_players", team1players);
        Utilities.writeToFile("team2_players", team2players);
        writeteam(team1players, "team1");
        writeteam(team2players, "team2");
    }

    private static void writeteam(String names, String team) {
        String[] array = names.split("\n");
        for (int i = 0; i < array.length; i++) {
            Utilities.writeToFile(team + "_player" + (i + 1), array[i]);
        }
    }
}
