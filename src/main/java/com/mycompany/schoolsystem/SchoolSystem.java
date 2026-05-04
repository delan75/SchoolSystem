package com.mycompany.schoolsystem;

import java.time.LocalDate;
import javax.swing.JOptionPane; // Required for pop-up windows

public class SchoolSystem {

    public static void main(String[] args) {

        // 1. Get Number of Students
        String sizeInput = JOptionPane.showInputDialog("How many students would you like to enter?");
        if (sizeInput == null) return; // Handle cancel
        int size = Integer.parseInt(sizeInput);

        Students[] learners = new Students[size];

        // 2. Data Entry Loop
        for (int i = 0; i < learners.length; i++) {
            String name = JOptionPane.showInputDialog("Student " + (i + 1) + " Name:");
            String surname = JOptionPane.showInputDialog("Student " + (i + 1) + " Surname:");
            double mark = Double.parseDouble(JOptionPane.showInputDialog("Mark for " + name + ":"));
            int year = Integer.parseInt(JOptionPane.showInputDialog("Birth Year (YYYY):"));
            
            learners[i] = new Students(name, surname, mark, LocalDate.of(year, 1, 1));
        }

        // 3. File Handling: Write and Read
        FileHandling.writeToFile(learners);
        FileHandling.readFromFile();

        // 4. Calculate Average
        double sum = 0;
        for (Students l : learners) {
            sum += l.getMark();
        }
        double average = sum / learners.length;
        JOptionPane.showMessageDialog(null, "Class Average: " + average + "%");

        // 5. Sorting
        sortLearnersByMark(learners);

        // 6. Dynamic Search
        String searchName = JOptionPane.showInputDialog("Enter a name to search for:");
        findLearnerByName(learners, searchName);
        
        // 7. Polymorphism Demonstration
        Students l2 = new MatricLearner("Sipho", "Dlamini", 45, LocalDate.of(2006, 5, 10));
        String polyResult = "Name: " + l2.getName() + "\n" +
                            "Mark: " + l2.getMark() + "%\n" +
                            "Status: " + (l2.isPass() ? "PASSED (Matric Rule)" : "FAILED");
        
        JOptionPane.showMessageDialog(null, polyResult, "Polymorphism Test", JOptionPane.INFORMATION_MESSAGE);
    }

    // Search Method
    public static void findLearnerByName(Students[] learners, String name) {
        boolean found = false;
        for (Students l : learners) {
            if (l != null && l.getName().equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null, "Result: Found -> " + l.toString());
                found = true;
                break;
            }
        }
        if (!found) JOptionPane.showMessageDialog(null, "Learner '" + name + "' Not Found");
    }

    // Sort Method
    public static void sortLearnersByMark(Students[] learners) {
        for (int i = 0; i < learners.length - 1; i++) {
            for (int j = 0; j < learners.length - 1 - i; j++) {
                if (learners[j].getMark() > learners[j + 1].getMark()) {
                    Students temp = learners[j];
                    learners[j] = learners[j + 1];
                    learners[j + 1] = temp;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder("--- Sorted Learners (Lowest to Highest) ---\n");
        for (Students l : learners) {
            sb.append(l.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}