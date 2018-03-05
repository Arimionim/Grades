package com.example.android.grades;

import android.util.Log;

import java.util.ArrayList;

/* list of subjects */
public class ListOfSubjects {
    private ArrayList<SubjectItem> list = new ArrayList<>();

    /* constructor */
    public void ListOfSubjects(String[] inputSubjects){
        for (String inputSubject : inputSubjects) {
            list.add(new SubjectItem(inputSubject, "F"));
        }
    }

    /* return requested Subject by index */
    public SubjectItem get(int index){
        if (index < list.size()){
            return list.get(index);
        }
        else{
            return new SubjectItem("error", "error");
        }
    }

    /* add new subject by String name */
    void add(String name){
        list.add(new SubjectItem(name, "F"));
    }

    /* add new subject by exemplar of SubjectItem */
    void add(SubjectItem subject){
        list.add(subject);
    }

    /* return full list of subjects */
    ArrayList<SubjectItem> getList(){
        return list;
    }
}
