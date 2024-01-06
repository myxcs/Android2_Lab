package com.example.android2_lab1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android2_lab1.database.DbHelper;
import com.example.android2_lab1.model.UserModel;

public class UserDAO {

    private DbHelper dbHelper;

    private SQLiteDatabase database;

    public UserDAO(Context mContext) {
        dbHelper = new DbHelper(mContext);
        database = dbHelper.getWritableDatabase();//cấp quyền dữ liệu
    }

    //thêm
    public long insertUser(UserModel userModel) {
        ContentValues contentValues = new ContentValues();//khuôn đuẹng dữ liệu
        contentValues.put("name", userModel.getName());
        contentValues.put("address", userModel.getAddress());
        contentValues.put("phone", userModel.getPhone());
       return database.insert("userdb", null, contentValues);
    }
}
