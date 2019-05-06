package it.roombooking.booking.model;

import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Prenotazione implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    Date data= new Date();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_utente", referencedColumnName="id")
    private Utente utente;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_stanza" , referencedColumnName="id")
    private Stanza stanza;

    private Date dataI= new Date();
    private Date dataF= new Date();


    public Prenotazione(){}

    public Prenotazione(Long pId,Date data,Long uId,Long sId,Date dI,Date dF){
        this.id=pId;
        this.data=data;
        this.utente.setId_User(uId);
        this.stanza.setId_room(sId);
        this.dataI=dI;
        this.dataF=dF;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Stanza getStanza() {
        return stanza;
    }

    public void setStanza(Stanza stanza) {
        this.stanza = stanza;
    }

    public Date getDataI() {
        return dataI;
    }

    public void setDataI(Date dataI) {
        this.dataI = dataI;
    }

    public Date getDataF() {
        return dataF;
    }

    public void setDataF(Date dataF) {
        this.dataF = dataF;
    }
}
