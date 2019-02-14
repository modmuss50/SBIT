package SBIT.TeamLogos;

import SBIT.Utilities;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import me.modmuss50.jgsi.api.models.Map;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class TeamLogosContoller {

    public static TeamLogosContoller controller;
    public ComboBox<String> team1ComboBox;
    public ComboBox<String> team2ComboBox;

    @FXML
    public void initialize() {
        controller = this;
        File teamlogos = new File("Files/Images/Logos/");
        teamlogos.mkdirs();
        if(teamlogos.listFiles().length > 0){
            TeamLogos.loadLogos();
        } else {
            Utilities.showErrorBox("Add some logos to the Files/Images/Logos/ directory then restart");
        }
    }

    public void setButtonClicked(MouseEvent mouseEvent) {
        TeamLogos.setTeamLogos();
    }
}
