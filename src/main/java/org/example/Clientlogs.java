package org.example;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Clientlogs {
    private List<String[]> log = new ArrayList<>();



    public void log(int productNum, int amount) {
        log.add(new String[] {"" + productNum,"" + amount});

    }
    public void exportAsCSV(File txtFile){
        if (!txtFile.exists()){
            log.add(0,new String[]{"productNum, amount"});
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(txtFile,true))){
            writer.writeAll(log);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
