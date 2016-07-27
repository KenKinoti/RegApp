package edu.strathmore.regapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EventsList extends AppCompatActivity {

    private ListView eventsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            eventsListView = (ListView) findViewById(R.id.events_list);

        // Get list of notes
        DBHelper dBhelper = new DBHelper(EventsList.this);
        String[] notesList = dBhelper.getAllNotesTitles();

        if (notesList.length > 0) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notesList);
            eventsListView.setAdapter(adapter);
        }

    }
}
