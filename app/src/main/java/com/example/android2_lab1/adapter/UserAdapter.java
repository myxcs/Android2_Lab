package com.example.android2_lab1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2_lab1.R;
import com.example.android2_lab1.dao.UserDAO;
import com.example.android2_lab1.model.UserModel;

import java.util.ArrayList;

public class UserAdapter
        //extends RecyclerView.Adapter<UserAdapter.ViewHolder>
{
//
//    private Context context;
//    private ArrayList<UserModel> listUser;
//    UserDAO userDAO;
//
//    public UserAdapter(Context context, ArrayList<UserModel> listUser) {
//        this.context = context;
//        this.listUser = listUser;
//        userDAO = new UserDAO(context);
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        //cập nhật dữ liệu lên cho từng view layout item_user
////        UserModel userModel = listUser.get(position);
////        holder.id.setText(String.valueOf(userModel.getId()));
////        holder.name.setText(userModel.getName());
////        holder.address.setText(userModel.getAddress());
////        holder.phone.setText(userModel.getPhone());
//        holder.id.setText(String.valueOf(listUser.get(position).getId()));
//        holder.name.setText(listUser.get(position).getName());
//        holder.address.setText(listUser.get(position).getAddress());
//        holder.phone.setText(listUser.get(position).getPhone());
//
//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        if (listUser != null) {
//            return listUser.size();
//        }
//        return 0;
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        //chứa toàn bộ view thuộc layout item_user
//
//        private TextView id, name, address, phone;
//        private Button update, delete;
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            id = itemView.findViewById(R.id.user_id);
//            name = itemView.findViewById(R.id.user_name);
//            address = itemView.findViewById(R.id.user_address);
//            phone = itemView.findViewById(R.id.user_phone);
//
//            update = itemView.findViewById(R.id.update);
//            delete = itemView.findViewById(R.id.delete);
//        }
//    }
}
