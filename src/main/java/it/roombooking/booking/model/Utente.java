package it.roombooking.booking.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Utente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;
    private String email;
    private String password;

    public Utente(){}

    public Utente(Long id, String name, String email, String password){
        this.id=id;
        this.Name=name;
        this.email=email;
        this.password=password;
    }

    public Long getId_User() {
        return id;
    }

    public void setId_User(Long id_User) {
        id = id_User;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
