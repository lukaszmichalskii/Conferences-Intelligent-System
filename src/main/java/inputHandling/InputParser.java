package main.java.inputHandling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class InputParser {

    private final FileParseStrategy fileParser;

    public InputParser(FileParseStrategy fileParser) {
        this.fileParser = fileParser;
    }

    public List<String> parseFile(Path filepath){
        return null;
    }
}
