package com.example.user.bitmmidprojecttest2;

public class Doctor {
    private String name;
    private String details;
    private String appointment;
    private String phone;
    private String email;
    private int id;

    public Doctor(String name, String details, String appointment, String phone, String email) {
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.phone = phone;
        this.email = email;

    }

    public Doctor(int id, String name, String details, String appointment, String phone, String email) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
