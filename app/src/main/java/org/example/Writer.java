package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Writer {
    private String fileName;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    Writer() {}
    String getFileName() {
        return fileName;
    }
    boolean openFile(String fileName) {
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch(Exception e) {
            System.err.println(e);
            return false;
        }
        this.fileName = fileName;
        return true;
    }
    boolean print(String str) {
        try {
            bufferedWriter.write(str);
        } catch(Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
    boolean println(String str) {
        return print(str + '\n');
    }
    boolean close() {
        try {
            bufferedWriter.close();
        } catch(Exception e) {
            System.err.println(e);
            return false;
        }
        return true;
    }
}
