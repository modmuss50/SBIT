package SBIT;

import javafx.scene.control.Alert;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Utilities {
    public static void writeToTxt(String filename, String content) {
        try {
            FileUtils.writeStringToFile(new File("Files/" + filename + ".txt"), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: Error 1", e);
        }
    }

    public static void replacePngFromFile(String inputFilepath, String outputFileName){
        try {
            FileUtils.copyFile(new File(inputFilepath), new File("Files/Images/" + outputFileName + ".png"));
        } catch (IOException e) {
            Utilities.showErrorBox(e.getMessage());
        }
    }

    public static void replacePngFromResource(String inputFilepath, String outputFileName){
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("images/" + inputFilepath);

        try {
            IOUtils.copy(inputStream, new FileOutputStream(new File("Files/Images/" + outputFileName + ".png")));
        } catch (IOException e) {
            Utilities.showErrorBox(e.getMessage());
        }
    }

    public static void showErrorBox(String errorMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("There was an error");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }
}
