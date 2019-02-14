package SBIT.Schedule;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;

public class ScheduleController {
    public static ScheduleController controller;
    public ComboBox<String> gamesComboBox;
    public ComboBox<String> currentGameComboBox;
    public Pane matchInfoPane;
    public ComboBox<String> game1team1ComboBox;
    public ComboBox<String> game1team2ComboBox;

    @FXML
    public void initialize() throws IOException {
        controller = this;
        gamesComboBox.getItems().addAll(
                "2", "3", "4"
        );
    }

    public void gamesComboBoxAction(ActionEvent actionEvent) {
        if (gamesComboBox.getValue() != null) {
            currentGameComboBox.getItems().clear();
            for (int i = 1; i <= Integer.parseInt(gamesComboBox.getValue()); i++) {
                currentGameComboBox.getItems().add("" + i);
            }
            currentGameComboBox.disableProperty().setValue(false);
        } else {
            currentGameComboBox.disableProperty().setValue(true);
        }
    }

    public void setImageButtonClicked(MouseEvent mouseEvent) {
        Schedule.setScheduleImage();
    }
}
