package it.roombooking.booking.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stanza implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    public Stanza(){}
    public Stanza(Long id, String nome){
        this.id=id;
        this.nome=nome;
    }
    public Long getId_room() {
        return id;
    }

    public void setId_room(Long id_room) {
        this.id = id_room;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
