package SBIT;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Utilities {
    public static void writeToFile(String filename,String content){
        try {
            FileUtils.writeStringToFile(new File( "Files/" + filename + ".txt"), content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: Error 1", e);
        }
    }
}
