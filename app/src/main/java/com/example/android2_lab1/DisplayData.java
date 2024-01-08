package com.example.android2_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.sqlite.SQLiteDatabaseKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.android2_lab1.adapter.UserAdapter;
import com.example.android2_lab1.dao.UserDAO;
import com.example.android2_lab1.database.DbHelper;
import com.example.android2_lab1.model.UserModel;

import java.util.ArrayList;

public class DisplayData extends AppCompatActivity {

//    DbHelper dbHelper;
//    SQLiteDatabase sqLiteDatabase;

    private  ArrayList<UserModel> listUser = new ArrayList<>();
    //ArrayList<UserModel> listUser;
    UserAdapter userAdapter;

//    UserModel userModel;
    RecyclerView recyclerView;

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);
        recyclerView = findViewById(R.id.view);
        userDAO = new UserDAO(DisplayData.this);
        listUser = userDAO.getAllUser();
//        dbHelper = new DbHelper(this);
       // listUser = displayData();
        userAdapter = new UserAdapter(DisplayData.this , listUser);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        LinearLayoutManager layoutManager = new LinearLayoutManager(DisplayData.this, RecyclerView.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);

}

//    private ArrayList<UserModel> displayData() {
//        sqLiteDatabase = dbHelper.getReadableDatabase();
//        ArrayList<UserModel> list = new ArrayList<>();
//        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userdb", null);
//        if (cursor.getCount() > 0) {
//            cursor.moveToFirst();
//            do {
//                UserModel userModel = new UserModel();
//
//                String name = cursor.getString(0);
//                String address = cursor.getString(1);
//                String phone = cursor.getString(2);
//                userModel.setName(name);
//                userModel.setAddress(address);
//                userModel.setPhone(phone);
//                list.add(userModel);
//            } while (cursor.moveToNext());
//        }
//        return listUser;
//    }
}