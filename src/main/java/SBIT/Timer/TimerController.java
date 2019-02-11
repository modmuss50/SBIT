package SBIT.Timer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class TimerController {

    public Text currentTime;
    public CheckBox checkboxHide;
    public TextField textboxTime;
    public Button button;

    public static TimerController controller;


    public void buttonClicked(MouseEvent mouseEvent) {
        String time = textboxTime.getText();
        int minutes = Integer.parseInt(time);
        int seconds = minutes * 60;
        SBITTimer.seconds = seconds + 1;
        checkboxHide.setSelected(false);
        SBITTimer.hidden = false;
    }

    @FXML
    public void initialize() {
        checkboxHide.setSelected(SBITTimer.hidden);
        controller = this;

    }

    public void checkboxClicked(MouseEvent mouseEvent) {
        SBITTimer.hidden = checkboxHide.isSelected();
        if (SBITTimer.hidden) {
            SBITTimer.ticker();
        }
    }
}
