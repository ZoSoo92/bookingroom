package it.roombooking.booking.service;

import it.roombooking.booking.model.Utente;
import it.roombooking.booking.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteDAO {

    @Autowired
    UtenteRepo utenteRepo;

    /* Save Utente */

    public Utente save(Utente ut){
        return utenteRepo.save(ut);
    }

    /* Search Utente */

    public List<Utente> findAll(){
        return utenteRepo.findAll();
    }

    /* Get Utente by Id */

    public Utente findOne(Long utId){
        return utenteRepo.getOne(utId);

    }

    /* Delete Utente */

    public void Delete(Utente ut){
        utenteRepo.delete(ut);
        return;
    }
}
