package com.abecorp.dataku;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.abecorp.dataku.model.contactItem;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {




    Context mContext;
    List<contactItem> mData;
    Dialog myDialog;
    Button myButton;
    TextView myTextView;
    int position;

    private OnCallbackListener listener;

    public RecycleViewAdapter(Context mContext, List<contactItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v,w;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_contact,viewGroup,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        w =  LayoutInflater.from(mContext).inflate(R.layout.fragment_list,viewGroup,false);
        final MyViewHolder wHolder = new MyViewHolder(w);


        //Dialog
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_input);


        //Button
        final Button buttonCancel, buttonUpdate, buttonSave,buttonAddd;


        vHolder.item_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText dialog_nim = myDialog.findViewById(R.id.edittext_nim);
                EditText dialog_nama = myDialog.findViewById(R.id.edittext_nama);
                EditText dialog_kelas = myDialog.findViewById(R.id.edittext_kelas);
                EditText dialog_nohp = myDialog.findViewById(R.id.edittext_telepon);
                EditText dialog_email = myDialog.findViewById(R.id.edittext_email);
                EditText dialog_sosmed = myDialog.findViewById(R.id.edittext_sosmed);
                Button buttonUpdate = myDialog.findViewById(R.id.button_save);
                Button buttonDelete = myDialog.findViewById(R.id.button_cancel);
                Button buttonAddd = myDialog.findViewById(R.id.button_add);
                dialog_nim.setText(mData.get(vHolder.getAdapterPosition()).getFnim());
                dialog_nama.setText(mData.get(vHolder.getAdapterPosition()).getFnama());
                dialog_kelas.setText(mData.get(vHolder.getAdapterPosition()).getFkelas());
                dialog_nohp.setText(mData.get(vHolder.getAdapterPosition()).getFhp());
                dialog_email.setText(mData.get(vHolder.getAdapterPosition()).getFemail());
                dialog_sosmed.setText(mData.get(vHolder.getAdapterPosition()).getFsosmed());
                buttonDelete.setText("Delete");
                buttonUpdate.setText("Update");
                Toast.makeText(mContext, "Clicked" + String.valueOf(vHolder.getAdapterPosition()), Toast.LENGTH_SHORT).show();

                buttonDelete = myDialog.findViewById(R.id.button_cancel);
                buttonDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //position = 1;
                        Object mRecentlyDeletedItem = mData.get(position);
                        int mRecentlyDeletedItemPosition = position;
                        mData.remove(getItemId(position));
                        Toast.makeText(mContext, "Delete", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();

                    }
                });


                buttonUpdate = myDialog.findViewById(R.id.button_save);
                buttonUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext, "Save Berhasil", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                });
                myDialog.show();

            }
        });
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_nim.setText(mData.get(i).getFnim());
        myViewHolder.tv_nama.setText(mData.get(i).getFnama());
        myViewHolder.tv_kelas.setText(mData.get(i).getFkelas());
        myViewHolder.tv_hp.setText(mData.get(i).getFhp());
        myViewHolder.tv_email.setText(mData.get(i).getFemail());
        myViewHolder.tv_sosmed.setText(mData.get(i).getFsosmed());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LinearLayout item_contact, lst_fragment;
        private TextView tv_nim,tv_nama,tv_kelas, tv_hp, tv_email, tv_sosmed;

        public MyViewHolder(final View contactItem){
            super(contactItem);
            contactItem.setOnClickListener(this);

            item_contact = contactItem.findViewById(R.id.contact_item_id);
            tv_nim = contactItem.findViewById(R.id.nim_friend);
            tv_nama = contactItem.findViewById(R.id.name_friend);
            tv_kelas = contactItem.findViewById(R.id.class_friend);
            tv_hp = contactItem.findViewById(R.id.number_friend);
            tv_email = contactItem.findViewById(R.id.email_friend);
            tv_sosmed = contactItem.findViewById(R.id.sosmed_friend);




        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(mData.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {

        void onClick(contactItem ContactItem);
    }
}
