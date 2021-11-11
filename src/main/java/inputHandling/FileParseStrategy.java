package main.java.inputHandling;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Interface determine the way of parsing files.
 * For now only .txt but if we need extension to .csv files we only need to implement such parser
 */
public interface FileParseStrategy {
    List<String> parseFile(Path filepath) throws IOException;

}
