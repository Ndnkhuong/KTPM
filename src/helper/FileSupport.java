/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dinh Thong
 */
public class FileSupport {
    private String filePath;
    private ArrayList<String> dataFile;
    
    public FileSupport(String filePath) {
        this.filePath = filePath;
        dataFile = new ArrayList<String>();
    }
    
    public ArrayList<String> ReadFile() {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            while ((line = br.readLine()) != null) {
                dataFile.add(line);
            }
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
        return dataFile;
    }
    
    public void WriteFile(ArrayList<String> dataInput) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath, false));
            for (String line: dataInput) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
