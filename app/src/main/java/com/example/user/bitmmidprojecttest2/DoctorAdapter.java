package com.example.user.bitmmidprojecttest2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorAdapter  extends ArrayAdapter<Doctor> {
    private ArrayList<Doctor> doctorsList;
    private Context context;

    public DoctorAdapter(@NonNull Context context, ArrayList <Doctor> doctorsList) {
        super(context,R.layout.model_doctor,doctorsList);
        this.doctorsList = doctorsList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.model_doctor,null);
        TextView id = convertView.findViewById(R.id.idTv);
        TextView name = convertView.findViewById(R.id.nameTvId);
        TextView details = convertView.findViewById(R.id.detailsTvId);
        TextView appointment = convertView.findViewById(R.id.appointmentTvId);
        TextView phone = convertView.findViewById(R.id.phoneTvId);
        TextView email = convertView.findViewById(R.id.emailTvId);
        Doctor doctor = doctorsList.get(position);


        //id.setText(doctor.getId());
        name.setText(doctor.getName());
        details.setText(doctor.getDetails());
        appointment.setText(doctor.getAppointment());
        phone.setText(doctor.getPhone());
        email.setText(doctor.getEmail());
        return convertView;
    }
}
