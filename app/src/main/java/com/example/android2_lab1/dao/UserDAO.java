package com.example.android2_lab1.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android2_lab1.database.DbHelper;
import com.example.android2_lab1.model.UserModel;

import java.util.ArrayList;

public class UserDAO {

//    private DbHelper dbHelper;
//
//    private SQLiteDatabase database;
//
//    public UserDAO(Context mContext) {
//        dbHelper = new DbHelper(mContext);
//        database = dbHelper.getWritableDatabase();//cấp quyền dữ liệu
//    }
//
//    //thêm
//    public long insertUser(UserModel userModel) {
//        ContentValues contentValues = new ContentValues();//khuôn đuẹng dữ liệu
//        contentValues.put("id", userModel.getId());
//        contentValues.put("name", userModel.getName());
//        contentValues.put("address", userModel.getAddress());
//        contentValues.put("phone", userModel.getPhone());
//       return database.insert("userdb", null, contentValues);
//    }
//    public ArrayList<UserModel> getAllUser(){
//        ArrayList<UserModel> list = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT * FROM userdb", null);
//        if(cursor.getCount() > 0) {
//            cursor.moveToFirst();
//            do {
//               // UserModel userModel = new UserModel();
//               int id = cursor.getInt(0);
//               String name = cursor.getString(1);
//               String address = cursor.getString(2);
//               String phone = cursor.getString(3);
//               UserModel userModel = new UserModel(id, name, address, phone);
//               list.add(userModel);
//            } while (cursor.moveToNext());
//        }
//        return list;
//    }
//

}
