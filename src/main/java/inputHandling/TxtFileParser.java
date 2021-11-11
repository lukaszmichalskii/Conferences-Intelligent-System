package main.java.inputHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Implementation of FileParseStrategy, class responsible for parse .txt files
 */
public class TxtFileParser implements FileParseStrategy {
    @Override
    public List<String> parseFile(Path filepath) throws IOException {
        return Files.readAllLines(filepath);
    }
}
