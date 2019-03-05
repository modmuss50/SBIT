package SBIT;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Controller {

    public ListView<String> listView;
    public AnchorPane scenePane;

    public HashMap<String,Parent> parentHashMap = new HashMap<>();

    @FXML
    public void initialize() throws IOException {
	    getResourceFiles("scenes").stream()
                .map(s -> s.replace(".fxml", ""))
	            .peek(s -> listView.getItems().add(s))
                .forEach(file -> {
                    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                    URL url = classloader.getResource("scenes/" + file);
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(url);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    parentHashMap.put(file.replace(".fxml", ""),root);
                });

    }

    //This is a method that handles geting a list of resources either from a dir, or a jar file.
	private List<String> getResourceFiles(String path) throws IOException {
		List<String> filenames = new ArrayList<>();
		File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

		if(jarFile.isFile()) {
			JarFile jar = new JarFile(jarFile);
			Enumeration<JarEntry> entries = jar.entries();
			while(entries.hasMoreElements()) {
				String name = entries.nextElement().getName();
				if (name.startsWith(path + "/")) {
					String fileName = name.replace(path + "/", "");
					if(!fileName.isEmpty()){
						filenames.add(fileName);
					}
				}
			}
			jar.close();
		} else {
			URL url = Controller.class.getResource("/" + path);
			if (url != null) {
				try {
					File apps = new File(url.toURI());
					for (File app : apps.listFiles()) {
						filenames.add(app.getName());
					}
				} catch (URISyntaxException ex) {
					throw new RuntimeException(ex);
				}
			}
		}
		return filenames;
	}

    public void listViewClicked(MouseEvent mouseEvent) throws IOException {
        String selected = (String) listView.getSelectionModel().getSelectedItem();
        if (selected == null || selected.isEmpty()) {
            return;
        }
        Parent root = parentHashMap.get(selected);
        scenePane.getChildren().clear();
        scenePane.getChildren().add(root);

    }
}
