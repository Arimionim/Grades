package com.example.android.grades;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectAdapter extends ArrayAdapter<SubjectItem> {

    SubjectAdapter(Activity context, ArrayList<SubjectItem> subjects) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, subjects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.subject_item, parent, false);
        }

        /* activate delete button */
        final SubjectItem currentSubject = getItem(position);
        ImageButton deleteButton = listItemView.findViewById(R.id.delete_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(currentSubject);
            }
        });


        assert currentSubject != null;

        /* activate Text view for name of subject */
        TextView nameView = listItemView.findViewById(R.id.name_view);
        nameView.setText(currentSubject.getName());

        /* activate button for change grade */
        Button gradeView = listItemView.findViewById(R.id.grade_view);
        gradeView.setText(currentSubject.getCurrentGrade());
        //Set background color depends on grade
        gradeView.setBackgroundColor(currentSubject.getColor());

        //Set onClickListener to process presses
        gradeView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                //change grade of current subject
                currentSubject.changeGrade();
                notifyDataSetChanged();
            }
        });

        return listItemView;
    }
}
