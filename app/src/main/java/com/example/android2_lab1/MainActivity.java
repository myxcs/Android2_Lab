package com.example.android2_lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android2_lab1.dao.UserDAO;
import com.example.android2_lab1.model.UserModel;


public class MainActivity extends AppCompatActivity {

    private Button add, update, delete, show;

    private EditText id, name, address, phone;

    private UserDAO userDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //buttons
        add = findViewById(R.id.add);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);
        show = findViewById(R.id.show);

        //editTexts
        id = findViewById(R.id.user_id);
        name = findViewById(R.id.user_name);
        address = findViewById(R.id.user_address);
        phone = findViewById(R.id.user_phone);

        //user
        userDAO = new UserDAO(MainActivity.this);

        //button click
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //thêm dữ liệu
                String UserId = id.getText().toString();
                String UserName = name.getText().toString();
                String UserAddress = address.getText().toString();
                String UserPhone = phone.getText().toString();

                UserModel userModel = new UserModel(Integer.parseInt(UserId), UserName, UserAddress, UserPhone);
                if(userDAO.insertUser(userModel) > 0) {
                    Toast.makeText(MainActivity.this, "Thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Thêm dữ liệu thất bại", Toast.LENGTH_SHORT).show();
                }
//                userDAO.insertUser(new UserModel(Integer.parseInt(id.getText().toString()),
//                        name.getText().toString(), address.getText().toString(), phone.getText().toString()));
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}