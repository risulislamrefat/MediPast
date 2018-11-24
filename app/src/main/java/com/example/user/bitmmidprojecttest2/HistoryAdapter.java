package com.example.user.bitmmidprojecttest2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private Context context;
    private List<History> imageList;
    private LinearLayout linearLayout;
    private DBManagerImage dbManagerImage;


    public HistoryAdapter(Context context, List <History> imageList) {
        this.context = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater =LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.model_doctor_two,null);
        return  new HistoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder historyViewHolder, int i) {

        History currentHistory = imageList.get(i);
        historyViewHolder.name.setText(currentHistory.getName());
        historyViewHolder.details.setText(currentHistory.getDetails());
        historyViewHolder.appointment.setText(currentHistory.getAppointment());
        historyViewHolder.phone.setText(currentHistory.getPhone());
        historyViewHolder.email.setText(currentHistory.getEmail());
        historyViewHolder.imageView.setImageBitmap(decodeImage(currentHistory.getImage()));

    }


    @Override
    public int getItemCount() {
        return imageList.size();
    }


    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        TextView name,details,appointment,phone,email;
        ImageView imageView;
        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameTvId);
            details = itemView.findViewById(R.id.detailsTvId);
            appointment = itemView.findViewById(R.id.appointmentTvId);
            phone = itemView.findViewById(R.id.phoneTvId);
            email = itemView.findViewById(R.id.emailTvId);
            imageView = itemView.findViewById(R.id.imageIvId);
        }
    }

    public static Bitmap decodeImage(String input) {

        byte[] decodebyte = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
    }
}
