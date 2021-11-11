package main.java.inputHandling;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Interface check if filepath is correct
 */
public interface FileChecker {
    static boolean isFileExist(Path filepath) {
        return Files.exists(filepath);
    }
}
