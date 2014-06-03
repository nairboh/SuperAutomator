/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatedsequence.fileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author brianho
 */
public class ReadFile {

    private Scanner scheduleFile;
    private ArrayList<Line> lines;
    
    public ReadFile() {
        lines = new ArrayList();
        try {
            scheduleFile = new Scanner(new File("/Users/brianho/Music/schedule.txt")).useDelimiter("\\s*@\\s*"); // path of file to store scheduled information
            createLineObject();
        } catch (FileNotFoundException e) {
            System.out.println("[ERROR] Could not find file.");
        }
    }
    
    private void createLineObject() {
        while(scheduleFile.hasNext()) {
            int id = scheduleFile.nextInt();
            String name = scheduleFile.next();
            String path = scheduleFile.next();
            int startTime = scheduleFile.nextInt();
            String date = scheduleFile.next();
            lines.add(new Line(id, name, path, startTime, date));
        }
        scheduleFile.close();
    }
    
    public ArrayList<Line> getData() {
        return lines;
    }
}
