package com.example.android2_lab1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.android2_lab1.dao.UserDAO;

public class DbHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "user.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "userdb";


//    private static final String ID = "id";
//    private static final String NAME = "name";
//    private static final String ADDRESS = "address";
//    private static final String PHONE = "phone";
    public DbHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //hàm này chỉ chạy khi chưa có cơ sở dự liệu// sex chạy đầu tiên, dùng để tạo bảng
        String createTableUser = "CREATE TABLE TABLE_USER (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "address TEXT NOT NULL, " +
                "phone TEXT NOT NULL);";
        db.execSQL(createTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        //sẽ chạy khi version thay đổi
        //nơi này thay đổi database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

}
