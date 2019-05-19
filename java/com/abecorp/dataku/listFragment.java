package com.abecorp.dataku;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.abecorp.dataku.model.contactItem;

import java.util.ArrayList;
import java.util.List;

public class listFragment extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<contactItem> lstContact;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        v = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = v.findViewById(R.id.recycler_view);
        RecycleViewAdapter recycleAdapter = new RecycleViewAdapter(getContext(), lstContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleAdapter);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstContact = new ArrayList<>();
        lstContact.add(new contactItem("10113466", "Agung Husein", "IF9", "081664372981", "husagung@gmail.com", "Huseagung"));
        lstContact.add(new contactItem("10113462", "Neng Chacha", "IF2", "089777612345", "cachaneng@gmail.com", "cachaneng"));
        lstContact.add(new contactItem("10113464", "Ujang Salim", "IF1", "087899653476", "salimunjang@gmail.com", "salimunjang"));
        lstContact.add(new contactItem("10113490", "Shiddiq ilham", "IF3", "082213456780", "shiddiqHam@gmail.com", "shiddiqHam"));
        lstContact.add(new contactItem("10113445", "Yanti Santika", "IF3", "0821245689023", "yansantika@gmail.com", "yansantika"));
        lstContact.add(new contactItem("10113234", "Nisa Aprilia", "IF7", "088823045682", "nisaprilia@gmail.com", "nisaprilia"));
        lstContact.add(new contactItem("10113478", "Asep Surasep", "IF8", "081346789234", "surAsep3@gmail.com", "surAsep3"));

    }
}