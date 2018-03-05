package com.example.android.grades;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper databaseHelper;
    private ListOfSubjects subjects = new ListOfSubjects();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /* declaration databaseHelper */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new MyDatabaseHelper(MainActivity.this, "subjectsDatabase", 1);

        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        /* declaration of cursor */
        Cursor cursor = database.query("main", null, null, null, null, null, null);


        if (cursor.moveToFirst()) {

            int nameColIndex = cursor.getColumnIndex("name");
            int gradeColIndex = cursor.getColumnIndex("grade");
            /* add to sublects list from database */
            do {
                Log.e("_____", "adding " + cursor.getString(nameColIndex));
                subjects.add(new SubjectItem(cursor.getString(nameColIndex), cursor.getInt(gradeColIndex)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        /* set adapter */
        SubjectAdapter Adapter = new SubjectAdapter(this, subjects.getList());
        ListView listView = findViewById(R.id.list_of_subjects);
        listView.setAdapter(Adapter);

        /* button whict call AddNew activity */
        ImageButton addButton = findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSubject();
            }
        });
    }

    /* add new subject */
    public void addSubject(){
        Intent addIntent = new Intent(MainActivity.this, AddNewSubject.class);
        startActivityForResult(addIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == MainActivity.RESULT_OK) {
                String name = data.getStringExtra("New subject");
                subjects.add(name);
            }
        }
    }

    /* sync with database when cloose app*/
    @Override
    public void onPause(){
        syncWithDatabase();
        super.onPause();
    }

    private void syncWithDatabase(){
        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        /* clear database */
        database.delete("main", null, null);

        /* fill database */
        int numberOfSubjects = subjects.getList().size();
        for (int i = 0; i < numberOfSubjects; i++){
            ContentValues syncSubject = new ContentValues();

            syncSubject.put("name", subjects.getList().get(i).getName());
            syncSubject.put("grade", subjects.getList().get(i).getIntegerCurrentGrade());
            Log.e("dsdsd", "inserting " + subjects.getList().get(i).getName());
            database.insert("main", null, syncSubject);
        }
    }

}
