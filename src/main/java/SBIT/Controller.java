package SBIT;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.List;


public class Controller {

    public ListView listView;
    public AnchorPane scenePane;

    @FXML
    public void initialize() throws IOException {
        List<String> files = IOUtils.readLines(Controller.class.getClassLoader().getResourceAsStream("scenes/"), Charsets.UTF_8);
        files.stream()
                .map(s -> s.replace(".fxml", ""))
                .forEach(s -> listView.getItems().add(s));
    }

    public void listViewClicked(MouseEvent mouseEvent) throws IOException {
        String selected = (String) listView.getSelectionModel().getSelectedItem();
        if (selected == null || selected.isEmpty()) {
            return;
        }
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("scenes/" + selected + ".fxml");
        Parent root = FXMLLoader.load(url);
        scenePane.getChildren().clear();
        scenePane.getChildren().add(root);

    }
}
