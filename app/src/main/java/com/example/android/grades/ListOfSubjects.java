package com.example.android.grades;

import java.util.ArrayList;

/* list of subjects */
public class  ListOfSubjects {
    private ArrayList<SubjectItem> list = new ArrayList<>();

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
        list.add(new SubjectItem(name, 0));
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
