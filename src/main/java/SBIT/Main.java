package SBIT;

import SBIT.Timer.SBITTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    public static void main(String[] args) throws IOException {
        SBITTimer.setup();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL url = classloader.getResource("gui.fxml");
        Parent root = FXMLLoader.load(url);

        primaryStage.setTitle("SBIT");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
        primaryStage.setResizable(true);

        primaryStage.setOnCloseRequest(event -> {
            SBITTimer.hidden = true;
            SBITTimer.ticker();
            System.exit(0);
        });
    }
}
