package com.mycompany.schoolsystem;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author delan
 */
public class Students {
    private String name;
    private String surname;
    private double mark;
    private LocalDate dateOfBirth;
    
    public Students(String name, String surname, double mark, LocalDate dob){
        this.name = name;
        this.surname = surname;
        this.mark = mark;
        this.dateOfBirth = dob;
    }
    
    //Method to check pass/fail
    public boolean isPass(){
        return mark >= 50;
    }
    
    public double getMark() {
        return mark;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge (){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }
    
    @Override
    public String toString() {
        return name + " " + surname + " | Mark: " + mark; 
    }  
}

// Subclass for Polymorphism
class MatricLearner extends Students {
    public MatricLearner(String name, String surname, double mark, LocalDate dob) {
        super(name, surname, mark, dob);
    }

    @Override
    public boolean isPass() {
        return getMark() >= 40; // Overridden rule
    }
}
