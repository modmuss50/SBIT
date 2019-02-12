package SBIT.Schedule;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ScheduleController {

    public ComboBox gamesComboBox;
    public ComboBox currentGameComboBox;
    public Pane matchInfoPane;
    public ComboBox game1team1ComboBox;
    public ComboBox game1team2ComboBox;

    @FXML
    public void initialize() throws IOException {
        gamesComboBox.getItems().addAll(
                "2", "3", "4"
        );

    }

    public void gamesComboBoxAction(ActionEvent actionEvent) {
        if (gamesComboBox.getValue() != null) {
            currentGameComboBox.disableProperty().setValue(false);
        } else {
            currentGameComboBox.disableProperty().setValue(true);
        }
    }

    public void currentGameComboBoxAction(ActionEvent actionEvent) {
        if (!gamesComboBox.getItems().isEmpty()) {
            //TODO grab the item name from gamesComboBox and set that as the number of items in currentGameComboBox
        } else {
            return;
        }
    }
}
