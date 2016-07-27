package edu.strathmore.regapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME ="events.db";

    private static final String TABLE = "notes";
    private static final String COL_ID = "id";
    private static final String COL_TITLE = "event_name";
    private static final String COL_NOTE = "details";


    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE + "(" +COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COL_TITLE+" TEXT NOT NULL, " +COL_NOTE +" TEXT NOT NULL);";

        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP IF TABLE EXISTS "+ TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean saveNote(String title, String note){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_TITLE, title);
        values.put(COL_NOTE, note);

        long id = db.insert(TABLE, null, values);

        if (id > 0)
        {
            db.close();
            return true;
        }
        else{
            db.close();
            return false;
        }



    }


    public String[] getAllNotesTitles() {

        List<String> notesList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String SQL = "SELECT " + COL_TITLE + " FROM " + TABLE +";";
        Cursor cursor = db.rawQuery(SQL, null);

        if(cursor != null) {
            if (cursor.getCount() > 0) {

                String title = "", name = "";
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    title = cursor.getString(cursor.getColumnIndex(COL_TITLE));
                    notesList.add(title);
                    cursor.moveToNext();
                }
            }

            cursor.close();
        }

        db.close();
        return notesList.toArray(new String[notesList.size()]);
    }
}
