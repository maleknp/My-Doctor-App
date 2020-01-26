package com.example.mydoctor;

public class doctorCard {
    private String name;
    private String hospital;
    private String phone;
    private String city;
    private String place;

    private int imag;

    public doctorCard(String name, String hospital, String phone, String city, String place, int imag) {
        this.name = name;
        this.hospital = hospital;
        this.phone = phone;
        this.city = city;
        this.place = place;

        this.imag = imag;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getHospital() { return hospital; }
    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCity() { return city; }
    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() { return place; }
    public void setPlace(String place) {
        this.place = place;
    }

    public int getImag() { return imag;}
    public void setImag(int image) { this.imag = imag; }
}
