package com.example.android2_lab1.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context) {
        super(context, "todo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE todo (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, date TEXT, type TEXT)";
        db.execSQL(sql);

        String data = "INSERT INTO todo(title, content, date, type) VALUES('title', 'content', 'date', 'type')";
        db.execSQL(data);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS todo");
            onCreate(db);
        }
    }
}
