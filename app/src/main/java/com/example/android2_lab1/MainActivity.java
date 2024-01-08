package com.example.android2_lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android2_lab1.adapter.UserAdapter;
import com.example.android2_lab1.dao.UserDAO;
import com.example.android2_lab1.database.DbHelper;
import com.example.android2_lab1.model.UserModel;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button add, show;

    private EditText name, address, phone;

//    private ArrayList<UserModel> listUser = new ArrayList<>();
//    private ArrayList<String> list = new ArrayList<>();
//
//    private UserAdapter userAdapter;
//
//    private UserModel userModel;
//
////    private RecyclerView recyclerView;
//
//    private UserDAO userDAO;
    DbHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    //Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buttons
        add = findViewById(R.id.add);
        show = findViewById(R.id.show);

        //editTexts
        name = findViewById(R.id.user_name);
        address = findViewById(R.id.user_address);
        phone = findViewById(R.id.user_phone);

        dbHelper = new DbHelper(this);

//        //user
//        userDAO = new UserDAO(MainActivity.this);
//        UserDAO userDAO = new UserDAO(context);
//        listUser = userDAO.getAllUser();
//
//        //recyclerView
//        recyclerView = findViewById(R.id.list_user);
//
//        //cắm máy tính vào máy chiếu
//        userAdapter = new UserAdapter(this, listUser);
//
//        //button click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thêm dữ liệu
//                String UserId = id.getText().toString();
//                String UserName = name.getText().toString();
//                String UserAddress = address.getText().toString();
//                String UserPhone = phone.getText().toString();
//
//                UserModel userModel = new UserModel(Integer.parseInt(UserId), UserName, UserAddress, UserPhone);
//                if(userDAO.insertUser(userModel) > 0) {
//                    Toast.makeText(MainActivity.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Thêm dữ liệu thất bại", Toast.LENGTH_SHORT).show();
//                }
//                userDAO.insertUser(new UserModel(Integer.parseInt(id.getText().toString()),
//                        name.getText().toString(), address.getText().toString(), phone.getText().toString()));


                sqLiteDatabase = dbHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", name.getText().toString());
                contentValues.put("address", address.getText().toString());
                contentValues.put("phone", phone.getText().toString());

                Long result = sqLiteDatabase.insert("userdb", null, contentValues);

                if (result!=null) {
                    Toast.makeText(MainActivity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                    cleardata();
                } else {
                    Toast.makeText(MainActivity.this, "Them that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
//
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, DisplayData.class);
                startActivity(intent);

            }
        });
    }

    private void cleardata() {
        name.setText("");
        address.setText("");
        phone.setText("");
    }

}
