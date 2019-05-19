package com.abecorp.mvp2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abecorp.mvp2.model.User;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private List<User> users;
    private OnCallbackListener listener;

    public MainRecyclerAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.textViewNim.setText(user.getNim());
        holder.textViewNama.setText(user.getNama());
        holder.textViewKelas.setText(user.getKelas());
        holder.textViewNoHp.setText(user.getNoHp());
        holder.textViewEmail.setText(user.getEmail());
        holder.textViewSosmed.setText(user.getSosmed());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewNim, textViewNama, textViewKelas, textViewNoHp, textViewEmail, textViewSosmed;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewNim = itemView.findViewById(R.id.nim);
            textViewNama = itemView.findViewById(R.id.nama);
            textViewKelas = itemView.findViewById(R.id.kelas);
            textViewNoHp = itemView.findViewById(R.id.NoHp);
            textViewEmail = itemView.findViewById(R.id.email);
            textViewSosmed = itemView.findViewById(R.id.sosmed);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(users.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(User user);
    }
}