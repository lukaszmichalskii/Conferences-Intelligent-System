package main.java.inputHandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TxtFileParser implements FileParseStrategy {
    @Override
    public List<String> parseFile(Path filepath) throws IOException {
        return Files.readAllLines(filepath);
    }
}
