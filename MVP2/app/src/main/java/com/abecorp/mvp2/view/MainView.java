package com.abecorp.mvp2.view;

import com.abecorp.mvp2.model.User;

import java.util.List;

public interface MainView {

    void onLoad(List<User> users);


    void onSave();

    void onDelete();

    void onUpdate();
}