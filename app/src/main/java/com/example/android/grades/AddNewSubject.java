package com.example.android.grades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*activity where user type title of new subject and click "ok" or "cancel*/
public class AddNewSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_subject);
        /* find textView where user type new title*/
        final TextView newName = findViewById(R.id.enter_name_view);
        /* find decline button*/

        /* button to return canceled*/
        TextView declineButton = findViewById(R.id.decline_enter_button);
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewSubject.this, MainActivity.class);
                setResult(AddNewSubject.RESULT_CANCELED, intent);
                finish();
            }
        });

        /* button to return accepted and new name*/
        TextView acceptButton = findViewById(R.id.accept_enter_button);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* check that new title is not empty*/
                if (newName.getText().toString().length() == 0){
                    /* make message with instructions to user*/
                    Toast.makeText(AddNewSubject.this, "Enter name", Toast.LENGTH_LONG).show();
                }
                else{
                    /* return accept and new name */
                    Intent intent = new Intent(AddNewSubject.this, MainActivity.class);
                    intent.putExtra("New subject", newName.getText().toString());
                    setResult(AddNewSubject.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}
