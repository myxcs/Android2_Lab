package com.example.android2_lab1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android2_lab1.adapter.UserAdapter;
import com.example.android2_lab1.dao.UserDAO;
import com.example.android2_lab1.model.UserModel;

import java.util.ArrayList;

public class DisplayFragment extends Fragment {

    private ArrayList<UserModel> listUser = new ArrayList<>();
    UserAdapter userAdapter;

    RecyclerView recyclerView;

    ImageView btnBack;

    private UserDAO userDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        recyclerView = view.findViewById(R.id.view_fragment);
        btnBack = view.findViewById(R.id.img_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        userDAO = new UserDAO(getActivity());
        listUser = userDAO.getAllUser();
        userAdapter = new UserAdapter(getActivity(), listUser);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }
}