package it.roombooking.booking.service;

import it.roombooking.booking.model.Stanza;
import it.roombooking.booking.repository.StanzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StanzaDAO {
    @Autowired
    StanzaRepo stanzaRepo;

    /* Save Stanza */
    public Stanza save(Stanza room){
        return stanzaRepo.save(room);
    }

    /* search Room */
    //ALL ROOMS
    public List<Stanza> getAllRoom(){
        return stanzaRepo.findAll();
    }
    //ROOM by ID
    public Stanza getById(Long rID){
        return stanzaRepo.getOne(rID);
    }

    /* DELETE room */
    public void deleteRoom(Stanza room){
        stanzaRepo.delete(room);
        return;
    }
}
