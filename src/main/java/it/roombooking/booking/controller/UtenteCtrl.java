package it.roombooking.booking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.roombooking.booking.service.UtenteDAO;
import it.roombooking.booking.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class UtenteCtrl {

    @Autowired
    UtenteDAO utenteDAO;
    @Autowired
    ObjectMapper mapper;

    /* SAVE Utente */
    @PostMapping("/utente")
    public Utente createUtente(@Valid @RequestBody Utente ut){
        return utenteDAO.save(ut);
    }

    /* GET All Utente */
    @GetMapping("/utente")
    public List<Utente> getAllUtente(){
        return utenteDAO.findAll();
    }

    /* GET One Utente*/
    @GetMapping("/utente/{id}")
    public  Utente getUtenteById(@PathVariable(value = "id") Long utId) {
        return utenteDAO.findOne(utId);
    }

    /* Update Utente */
    @PutMapping(value = "/utente/{id}")
    public ResponseEntity<Utente> updateUtente(@PathVariable(value = "id") Long utId,@Valid @RequestBody Utente utDetails){
        Utente ut= utenteDAO.findOne(utId);

        if(ut == null){
            return ResponseEntity.notFound().build();
        }
        System.out.println(ut.getName());
        ut.setEmail(utDetails.getEmail());
        ut.setName(utDetails.getName());
        ut.setPassword(utDetails.getPassword());
        Utente updateUt=utenteDAO.save(ut);

        return  ResponseEntity.ok().body(updateUt);
    }


    @DeleteMapping("/utente/{id}")
    public ResponseEntity<Utente> deleteUtente(@PathVariable(value="id") Long utId){
        Utente ut=utenteDAO.findOne(utId);
        if(ut == null){
            return ResponseEntity.notFound().build();
        }
        utenteDAO.Delete(ut);
        return ResponseEntity.ok().build();
    }
}
