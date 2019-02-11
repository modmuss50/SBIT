package SBIT.Teams;

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
        FileUtils.writeStringToFile(new File("team1_name.txt"), team1name, StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File("team2_name.txt"), team2name, StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File("team1_players.txt"), team1players, StandardCharsets.UTF_8);
        FileUtils.writeStringToFile(new File("team2_players.txt"), team2players, StandardCharsets.UTF_8);
        writeteam(team1players, "team1");
        writeteam(team2players, "team2");
    }

    private static void writeteam(String names, String team) throws IOException {
        String[] array = names.split("\n");
        for (int i = 0; i < array.length; i++) {
                FileUtils.writeStringToFile(new File(team + "_player" + (i+1) + ".txt"), array[i], StandardCharsets.UTF_8);

        }
    }
}
