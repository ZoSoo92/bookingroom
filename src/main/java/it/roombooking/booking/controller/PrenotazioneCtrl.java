package it.roombooking.booking.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.roombooking.booking.model.Prenotazione;
import it.roombooking.booking.model.Utente;
import it.roombooking.booking.service.PrenotazioneDAO;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.xml.crypto.Data;

@RestController
@RequestMapping("/api")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PrenotazioneCtrl implements Serializable {
    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    /* GET All Utente */
    @GetMapping("/booking")
    public List<Prenotazione> getAllBooking(){
        List<Prenotazione> pt=prenotazioneDAO.findAll();
        return pt;
    }
    /*
    public ResponseEntity<List<Prenotazione>> getAllBooking(){
        List<Prenotazione> pt=prenotazioneDAO.findAll();
        return new ResponseEntity<List<Prenotazione>>(pt, HttpStatus.OK);
    }*/
    /* GET Utente BY ID*/
    //JSON FORMATTATO CON HashMap
    @GetMapping("/booking/{id}")
    public Map<String, String> getUtenteById(@PathVariable(value = "id") Long pdId) {

        Prenotazione pt = prenotazioneDAO.findOne(pdId);
        String pattern = "MM/dd/yyyy HH:mm:ss";

        DateFormat df = new SimpleDateFormat(pattern);
        HashMap<String, String> map = new HashMap<>();
        map.put("data", df.format(pt.getData()));
        map.put("stanza", pt.getStanza().getNome());
        map.put("utente", pt.getUtente().getName());
        pt.getUtente().getId_User();
        return map;
    }
    //JSON NON FORMATTATO
    @GetMapping("/booking1/{id}")
    public Prenotazione getUtenteById1(@PathVariable(value = "id") Long pdId) {

        Prenotazione pt = prenotazioneDAO.findOne(pdId);

        return pt;
    }

    @GetMapping("/test/{id}")
    public ResponseEntity<Prenotazione> getUtenteById2(@PathVariable(value = "id") Long ptId) {
        Prenotazione pt = prenotazioneDAO.findOne(ptId);
        return new ResponseEntity<Prenotazione>(pt,HttpStatus.OK);

    }

}
