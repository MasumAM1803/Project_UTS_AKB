package com.abecorp.mvp2.presenter;

import com.abecorp.mvp2.model.User;

public interface MainPresenter {


    void save(User user);

    void update(User user);

    void delete(User user);

    void load();
}