package main.java.inputHandling;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileParseStrategy {
    List<String> parseFile(Path filepath) throws IOException;

}
