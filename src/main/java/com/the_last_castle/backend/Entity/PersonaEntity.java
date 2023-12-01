package com.the_last_castle.backend.Entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Use_person")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_person", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "people_name", unique = true, nullable = false, length = 250)
    private String peopleName;

    @Column(name = "surnames", nullable = false, length = 250)
    private String surnames;

    @Column(name = "carnet", nullable = false, length = 250)
    private String carnet;

    @Column(name = "phone", nullable = false, length = 250)
    private String phone;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    public PersonaEntity() {
    }

    public PersonaEntity(UUID id, String peopleName, String surnames, String carnet, String phone, String address) {
        this.id = id;
        this.peopleName = peopleName;
        this.surnames = surnames;
        this.carnet = carnet;
        this.phone = phone;
        this.address = address;
    }

    public PersonaEntity(String peopleName, String surnames, String carnet, String phone, String address) {
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
        return "PersonaEntity [id=" + id + ", peopleName=" + peopleName + ", surnames=" + surnames + ", carnet="
                + carnet + ", phone=" + phone + ", address=" + address + "]";
    }

}
