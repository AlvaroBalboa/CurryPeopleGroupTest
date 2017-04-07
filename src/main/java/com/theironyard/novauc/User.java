package com.theironyard.novauc;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String dateofbirth;

    @Column(nullable = false)
    String placeofbirth;

    @Column(nullable = false)
    String enlistmentdate;

    @Column(nullable = false)
    String eaos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPlaceofbirth() {
        return placeofbirth;
    }

    public void setPlaceofbirth(String placeofbirth) {
        this.placeofbirth = placeofbirth;
    }

    public String getEnlistmentdate() {
        return enlistmentdate;
    }

    public void setEnlistmentdate(String enlistmentdate) {
        this.enlistmentdate = enlistmentdate;
    }

    public String getEaos() {
        return eaos;
    }

    public void setEaos(String eaos) {
        this.eaos = eaos;
    }

    public User(String username, String dateofbirth, String placeofbirth, String enlistmentdate, String eaos) {

        this.username = username;
        this.dateofbirth = dateofbirth;
        this.placeofbirth = placeofbirth;
        this.enlistmentdate = enlistmentdate;
        this.eaos = eaos;
    }

    public User() {

    }

}