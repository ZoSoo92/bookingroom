package it.roombooking.booking.controller;

import it.roombooking.booking.model.Prenotazione;
import it.roombooking.booking.service.PrenotazioneDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@RestController
@RequestMapping("/api")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PrenotazioneCtrl implements Serializable {
    @Autowired
    PrenotazioneDAO prenotazioneDAO;

    /* GET All Bookings */
    @GetMapping("/booking")
    public List<Prenotazione> getAllBooking(){
        List<Prenotazione> pt=prenotazioneDAO.findAll();
        return pt;
    }

    /* GET booking BY ID*/
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

    /* UPDATE book */
    @PutMapping("/booking/{id}")
    public ResponseEntity<Prenotazione> updateRoom(@PathVariable(value = "id") Long ptId, @Valid @RequestBody Prenotazione ptDetails){
        Prenotazione pt = prenotazioneDAO.findOne(ptId);
        if(pt==null){ResponseEntity.notFound().build();}
        pt.setData(ptDetails.getData());
        pt.setUtente(ptDetails.getUtente());
        pt.setStanza(ptDetails.getStanza());
        Prenotazione ptUp = prenotazioneDAO.save(pt);
        return ResponseEntity.ok().body(ptUp);
    }

    /* DELETE Book */
    @DeleteMapping("/booking/{id}")
    public ResponseEntity<Prenotazione> deleteBooking(@PathVariable(value="id")Long bookId){
        Prenotazione book=prenotazioneDAO.findOne(bookId);
        if(book == null){ return ResponseEntity.notFound().build();}
        prenotazioneDAO.Delete(book);
        return ResponseEntity.ok().build();
    }

}
