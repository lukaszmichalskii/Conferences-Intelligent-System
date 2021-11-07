package main.java.inputHandling;

import java.nio.file.Files;
import java.nio.file.Path;

public interface FileChecker {
    static boolean isFileExist(Path filepath) {
        return Files.exists(filepath);
    }
}
