package com.the_last_castle.backend.DTO;

import java.util.UUID;

public class PersonaDTO {
    private UUID id;
    private String peopleName;
    private String surnames;
    private String carnet;
    private String phone;
    private String address;

    public PersonaDTO(String peopleName, String surnames, String carnet, String phone, String address) {
        this.peopleName = peopleName;
        this.surnames = surnames;
        this.carnet = carnet;
        this.phone = phone;
        this.address = address;
    }

    public PersonaDTO(UUID id, String peopleName, String surnames, String carnet, String phone, String address) {
        this.id = id;
        this.peopleName = peopleName;
        this.surnames = surnames;
        this.carnet = carnet;
        this.phone = phone;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonaDTO [id=" + id + ", peopleName=" + peopleName + ", surnames=" + surnames + ", carnet=" + carnet
                + ", phone=" + phone + ", address=" + address + "]";
    }
}
