package org.eagle;

public class Main {
    public static void main(String[] args) {
        FileLineAppender appender = new FileLineAppender("text_file2.txt");
        appender.appendLineToFile("My first line");
        appender.appendLineToFile("My second line");
    }
}