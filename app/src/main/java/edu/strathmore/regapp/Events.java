package edu.strathmore.regapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Events extends AppCompatActivity {

    EditText edtTitle, edtNote;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edtTitle = (EditText) findViewById(R.id.edt_title);
        edtNote = (EditText) findViewById(R.id.edt_note);
        save = (Button) findViewById(R.id.btn_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save note
                String title = edtTitle.getText().toString().trim();
                String note = edtNote.getText().toString().trim();

                DBHelper dBhelper = new DBHelper(Events.this);
                if (dBhelper.saveNote(title, note)) {
                    Log.w("SAVED ==>", "SUCCESS");
                    Intent intent = new Intent(Events.this, EventsList.class);
                    startActivity(intent);
                }


            }
        });


    }
}
