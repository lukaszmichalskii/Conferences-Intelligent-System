package main.java.inputHandling;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Class responsible for parse file
 */
public class InputParser {

    private final FileParseStrategy fileParser;

    public InputParser(FileParseStrategy fileParser) {
        this.fileParser = fileParser;
    }

    public List<String> parseFile(Path filepath){
        try {
            if (Files.notExists(filepath)) {
                throw new Exception("File does not exist");
            }
            if (FileChecker.isFileExist(filepath)) {
                return this.fileParser.parseFile(filepath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
