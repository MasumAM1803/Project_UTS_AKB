package com.abecorp.mvp2.presenter;

import com.abecorp.mvp2.model.User;
import com.abecorp.mvp2.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;
    private List<User> users = new ArrayList<>();
    private int no = 4;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        init();
    }

    private void init() {
        User user = new User();
        user.setId(1);
        user.setNim("10113452");
        user.setNama("Kristiawan Adi");
        user.setKelas("IF7");
        user.setNoHp("085330684114");
        user.setEmail("KristiAdi@gmail.com");
        user.setSosmed("AKritis");
        users.add(user);

        User user1 = new User();
        user1.setId(2);
        user1.setNim("10113456");
        user1.setNama("Bimo Joko");
        user1.setKelas("IF1");
        user1.setNoHp("085474748888");
        user1.setEmail("BimoJo@gmail.com");
        user1.setSosmed("JokBimo");
        users.add(user1);

        User user2 = new User();
        user2.setId(3);
        user2.setNim("10113478");
        user2.setNama("Dirga");
        user2.setKelas("IF9");
        user2.setNoHp("085332423043");
        user2.setEmail("Dirgaja1@gmaiil.com");
        user2.setSosmed("Didirga");
        users.add(user2);
    }

    @Override
    public void save(User user) {
        no++;
        user.setId(no);
        users.add(user);

        mainView.onSave();
    }

    @Override
    public void update(User user) {
        for (User model : users){
            if (model.getId() == user.getId()){
                model.setNim(user.getNim());
                model.setNama(user.getNama());
                model.setKelas(user.getKelas());
                model.setNoHp(user.getNoHp());
                model.setEmail(user.getEmail());
                model.setSosmed(user.getSosmed());

                break;
            }
        }

        mainView.onUpdate();
    }

    @Override
    public void delete(User user) {
        users.remove(user);

        mainView.onDelete();
    }

    @Override
    public void load() {
        mainView.onLoad(users);
    }
}