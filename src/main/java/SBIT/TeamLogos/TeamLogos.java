package SBIT.TeamLogos;

import SBIT.Utilities;

import java.io.File;
import java.util.Arrays;

public class TeamLogos {
    public static void loadLogos() {
        File[] teamLogos = new File("Files/Images/Logos/").listFiles();
        Arrays.stream(teamLogos)
                .filter(file -> !file.isDirectory())
                .map(file -> file.getName().replace(".png", ""))
                .forEach(file -> {
                    TeamLogosContoller.controller.team1ComboBox.getItems().add(file);
                    TeamLogosContoller.controller.team2ComboBox.getItems().add(file);
                });
    }
    public static void setTeamLogos(){
        String team1filename = TeamLogosContoller.controller.team1ComboBox.getValue() + ".png";
        Utilities.replacePngFromFile("Files/Images/Logos/" + team1filename, "team1Logo");
        String team2filename = TeamLogosContoller.controller.team2ComboBox.getValue() + ".png";
        Utilities.replacePngFromFile("Files/Images/Logos/" + team2filename, "team2Logo");
    }
}
