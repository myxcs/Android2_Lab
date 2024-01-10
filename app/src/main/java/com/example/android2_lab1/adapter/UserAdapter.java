package com.example.android2_lab1.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android2_lab1.R;
import com.example.android2_lab1.dao.UserDAO;
import com.example.android2_lab1.model.UserModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<UserModel> listUser;

    private UserDAO userDAO;

    private SQLiteDatabase database;

    private Context context;


    public UserAdapter(Context context, ArrayList<UserModel> listUser) {
        this.context = context;
        this.listUser = listUser;
    }
    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {

        UserModel userModel = listUser.get(position);

        holder.name.setText(userModel.getName());
        holder.address.setText(userModel.getAddress());
        holder.phone.setText(userModel.getPhone());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name, address, phone;
        private Button update, delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            phone = itemView.findViewById(R.id.phone);

            update = itemView.findViewById(R.id.update);
            delete = itemView.findViewById(R.id.delete);

            update.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //tao dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    AlertDialog dialog = builder.create();
                    View view = LayoutInflater.from(context).inflate(R.layout.layout_edit, null);
                    dialog.setView(view);

                    //khai bao cac doi tuong trong dialog
                    TextView edit_name = view.findViewById(R.id.edit_user_name);
                    TextView edit_address = view.findViewById(R.id.edit_user_address);
                    TextView edit_phone = view.findViewById(R.id.edit_user_phone);

                    Button btn_update = view.findViewById(R.id.update);
                    Button btn_cancel = view.findViewById(R.id.cancel);

                    //set text
                    edit_name.setText(listUser.get(getAdapterPosition()).getName());
                    edit_address.setText(listUser.get(getAdapterPosition()).getAddress());
                    edit_phone.setText(listUser.get(getAdapterPosition()).getPhone());

                    //xu li su kien cac nut
                   btn_update.setOnClickListener(new View.OnClickListener() {

                       @Override
                       public void onClick(View v) {
                           //lay du lieu
                           UserModel userModel = new UserModel();
                           userModel.setId(listUser.get(getAdapterPosition()).getId());
                           userModel.setName(edit_name.getText().toString());
                           userModel.setAddress(edit_address.getText().toString());
                           userModel.setPhone(edit_phone.getText().toString());

                           //update
                           userDAO = new UserDAO(context);
                           userDAO.updateUser(userModel);
                           listUser.set(getAdapterPosition(), userModel);
                           notifyItemChanged(getAdapterPosition());
                           dialog.dismiss();
                       }
                   });
                    btn_cancel.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Delete");
                    builder.setMessage("Are you sure?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            userDAO = new UserDAO(context);
                            userDAO.deleteUser(listUser.get(getAdapterPosition()).getId());
                            listUser.remove(getAdapterPosition());
                            notifyItemRemoved(getAdapterPosition());
                            notifyItemRangeChanged(getAdapterPosition(), listUser.size());
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
               builder.show();
                }
            });
        }
    }
}
