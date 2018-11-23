package com.example.user.bitmmidprojecttest2;

public class History {
    private int id;
    private String name;
    private String details;
    private String appointment;
    private String phone;
    private String email;
    private String image;


    public History(int id, String name, String details, String appointment, String phone, String email, String image) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public History(String name, String details, String appointment, String phone, String email, String image) {
        this.name = name;
        this.details = details;
        this.appointment = appointment;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
