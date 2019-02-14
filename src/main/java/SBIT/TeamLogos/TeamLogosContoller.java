package SBIT.TeamLogos;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.io.InputStream;

public class TeamLogosContoller {

    public ComboBox team1ComboBox;
    public ComboBox team2ComboBox;

    @FXML
    public void initialize() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("images/teamlogos/" );
        team1ComboBox.getItems().addAll(inputStream);
        System.out.println(inputStream);
    }
}
