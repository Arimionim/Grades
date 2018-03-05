package com.example.android.grades;

import android.graphics.Color;

public class SubjectItem {
    private int currentGrade = 0;
    private String name;
    static private String[] allGrades = {"F", "E", "D", "C", "B", "A"};
    private String[] allColors = {"#F44336", "#FF9800", "#FFC107", "#FFEB3B", "#CDDC39", "#4CAF50"};

    /* constructor with two Strings */
    SubjectItem(String nameInput, String gradeInput){
        for (int i = 0; i < allGrades.length; i++){
            if (gradeInput == allGrades[i]){
                currentGrade = i;
            }
        }
        name = nameInput;
    }

    /* constructor with String nameInput and int grade*/
    SubjectItem(String nameInput, int gradeInput){
        this(nameInput, allGrades[gradeInput]);
    }

    /* change grade to next */
    void changeGrade(){
        currentGrade = (currentGrade + 1) % allGrades.length;
    }

    /* return name of subject */
    public String getName(){
        return name;
    }

    /* return name of current grade */
    String getCurrentGrade(){
        return allGrades[currentGrade];
    }

    /* return current grade in numbeer */
    int getIntegerCurrentGrade(){
        return currentGrade;
    }

    /* return color of grade */
    int getColor(){
        return Color.parseColor(allColors[currentGrade]);
    }
}
