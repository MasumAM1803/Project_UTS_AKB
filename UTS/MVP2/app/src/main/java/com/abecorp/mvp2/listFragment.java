package com.abecorp.mvp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abecorp.mvp2.model.User;
import com.abecorp.mvp2.presenter.MainPresenter;
import com.abecorp.mvp2.presenter.MainPresenterImpl;
import com.abecorp.mvp2.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class listFragment extends AppCompatActivity implements MainView {

    private RecyclerView recyclerView;
    private Button buttonAdd;
    private MainRecyclerAdapter adapter;
    private List<User> userList = new ArrayList<>();
    private AppCompatDialog dialog;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list);
        presenter = new MainPresenterImpl(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MainRecyclerAdapter(userList);
        adapter.setOnCallbackListener(new MainRecyclerAdapter.OnCallbackListener() {
            @Override
            public void onClick(User user) {
                showDialogDetail(user);
            }
        });

        recyclerView.setAdapter(adapter);

        buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogInput();
            }
        });

        presenter.load();
    }

    @Override
    public void onLoad(List<User> users) {
        userList.clear();
        userList.addAll(users);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onSave() {
        Toast.makeText(this, "Berhasil disimpan!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    @Override
    public void onDelete() {
        Toast.makeText(this, "Berhasil dihapus!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    @Override
    public void onUpdate() {
        Toast.makeText(this, "Berhasil diperbarui!", Toast.LENGTH_SHORT).show();
        presenter.load();
    }

    public void showDialogInput() {
        dialog = new AppCompatDialog(this);
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("");

        final EditText editTextNim = dialog.findViewById(R.id.edittext_nim);
        final EditText editTextNama = dialog.findViewById(R.id.edittext_nama);
        final EditText editTextKelas = dialog.findViewById(R.id.edittext_kelas);
        final EditText editTextNoHp = dialog.findViewById(R.id.edittext_telepon);
        final EditText editTextEmail = dialog.findViewById(R.id.edittext_email);
        final EditText editTextSosmed = dialog.findViewById(R.id.edittext_sosmed);

        Button buttonSave = dialog.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setNim(editTextNim.getText().toString());
                user.setNama(editTextNama.getText().toString());
                user.setKelas(editTextKelas.getText().toString());
                user.setNoHp(editTextNoHp.getText().toString());
                user.setEmail(editTextEmail.getText().toString());
                user.setSosmed(editTextSosmed.getText().toString());

                presenter.save(user);
                dialog.dismiss();
            }
        });

        Button buttonCancel = dialog.findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void showDialogDetail(final User user) {
        dialog = new AppCompatDialog(this);
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("");

        final EditText editTextNim = dialog.findViewById(R.id.edittext_nim);
        final EditText editTextNama = dialog.findViewById(R.id.edittext_nama);
        final EditText editTextKelas = dialog.findViewById(R.id.edittext_kelas);
        final EditText editTextNoHp = dialog.findViewById(R.id.edittext_telepon);
        final EditText editTextEmail = dialog.findViewById(R.id.edittext_email);
        final EditText editTextSosmed = dialog.findViewById(R.id.edittext_sosmed);

        editTextNim.setText(user.getNim());
        editTextNama.setText(user.getNama());
        editTextKelas.setText(user.getKelas());
        editTextNoHp.setText(user.getNoHp());
        editTextEmail.setText(user.getEmail());
        editTextSosmed.setText(user.getSosmed());

        Button buttonUpdate = dialog.findViewById(R.id.button_save);
        buttonUpdate.setText("Update");
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setNim(editTextNim.getText().toString());
                user.setNama(editTextNama.getText().toString());
                user.setKelas(editTextKelas.getText().toString());
                user.setNoHp(editTextNoHp.getText().toString());
                user.setEmail(editTextEmail.getText().toString());
                user.setSosmed(editTextSosmed.getText().toString());

                presenter.update(user);
                dialog.dismiss();
            }
        });

        Button buttonDelete = dialog.findViewById(R.id.button_cancel);
        buttonDelete.setText("Delete");
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.delete(user);
                dialog.dismiss();
            }
        });

        if (!dialog.isShowing()) {
            dialog.show();
        }
    }
}