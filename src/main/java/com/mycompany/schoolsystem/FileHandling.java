/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.schoolsystem;

/**
 *
 * @author delan
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileHandling {
    
    // Writing to File using GUI for notifications
    public static void writeToFile(Students[] learners) {
        try {
            FileWriter writer = new FileWriter("learners.txt");

            for (Students l : learners) {
                if (l != null) {
                    writer.write(l.toString() + "\n");
                }
            }

            writer.close();
            // Success Message
            JOptionPane.showMessageDialog(null, "Data saved to learners.txt successfully!");
            
        } catch (IOException e) {
            // Error Message
            JOptionPane.showMessageDialog(null, "Error writing to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Reading from File and displaying in a single pop-up
    public static void readFromFile() {
        try {
            File file = new File("learners.txt");
            
            if (!file.exists()) {
                JOptionPane.showMessageDialog(null, "No saved data found (File does not exist).");
                return;
            }

            Scanner reader = new Scanner(file);
            
            // We use a StringBuilder to combine all lines into one big message
            StringBuilder dataToDisplay = new StringBuilder("--- Data Read From File ---\n\n");
            
            while (reader.hasNextLine()) {
                dataToDisplay.append(reader.nextLine()).append("\n");
            }

            reader.close();

            // Display the combined string in one scrollable/resizable dialog
            JOptionPane.showMessageDialog(null, dataToDisplay.toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
