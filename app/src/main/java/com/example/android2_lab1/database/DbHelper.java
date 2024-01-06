package com.example.android2_lab1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.android2_lab1.dao.UserDAO;

public class DbHelper extends SQLiteOpenHelper {

    public static final String NAME_DB = "user.db";
    public static final int VERSION_DB = 1;
    public DbHelper(@Nullable Context context) {

        super(context, NAME_DB, null, VERSION_DB);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //hàm này chỉ chạy khi chưa có cơ sở dự liệu// sex chạy đầu tiên, dùng để tạo bảng
        String createTableUser = "CREATE TABLE userdb (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT NOT NULL," +
                " address TEXT NOT NULL, " +
                "phone TEXT NOT NULL);";
        sqLiteDatabase.execSQL(createTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //sẽ chạy khi version thay đổi
        //nơi này thay đổi database
    }

}
