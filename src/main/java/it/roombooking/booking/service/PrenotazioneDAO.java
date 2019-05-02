package it.roombooking.booking.service;

import it.roombooking.booking.model.Prenotazione;
import it.roombooking.booking.repository.PrenotazioneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneDAO {

    @Autowired
    PrenotazioneRepo prenotazioneRepo;

    /* Save prenotazione */

    public Prenotazione save(Prenotazione pt){
        return prenotazioneRepo.save(pt);
    }

    /* Search prenotazione */

    public List<Prenotazione> findAll(){
        return prenotazioneRepo.findAll();
    }

    /* Get prenotazione by Id */

    public Prenotazione findOne(Long pt){
        return prenotazioneRepo.getOne(pt);
    }

    /* Delete prenotazione */

    public void Delete(Prenotazione pt){
        prenotazioneRepo.delete(pt);
        return;
    }
}
