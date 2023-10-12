package org.eagle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileLineAppender {
    private Path path;

    public FileLineAppender(String target) {
        this.path = Path.of(target);
    }

    void appendLineToFile(String line){
        line = line + System.lineSeparator();

        try{
            Files.write(path,line.getBytes(),StandardOpenOption.APPEND);
            System.out.println("Writing to file: " + line);
        }catch (NoSuchFileException e){
            try{
                Files.createFile(path);
                System.out.println("Created file");
                Files.write(path,line.getBytes(),StandardOpenOption.APPEND);
                System.out.println("Writing to file");
            }catch (IOException ex){
                throw new RuntimeException(ex);
            }
        }catch (IOException e){
            System.err.println("Error writing to file " + e);
        }
    }
}
