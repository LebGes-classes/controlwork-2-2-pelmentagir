package org.example.io;

import java.io.*;
import java.util.ArrayList;

public class TXTParser {
    public static ArrayList<String> parser(String filePath){
        ArrayList<String> data = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./"+filePath));
            String line;
            while((line = reader.readLine()) != null){
                data.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
