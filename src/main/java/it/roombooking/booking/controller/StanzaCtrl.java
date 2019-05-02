package it.roombooking.booking.controller;

import it.roombooking.booking.model.Stanza;
import it.roombooking.booking.service.StanzaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StanzaCtrl {
    @Autowired
    StanzaDAO stanzaDAO;

    /* SAVE Room */
    @PostMapping("/room")
    public Stanza createRoom(@Valid @RequestBody Stanza room){
        return stanzaDAO.save(room);
    }

    /* GET ALL ROOM */
    @GetMapping("/room")
    public List<Stanza> getAllRoom(){
        return stanzaDAO.getAllRoom();
    }

    /* GET ROOM by ID */
    @GetMapping("/room/{id}")
    public Stanza getByID(@PathVariable(value = "id") Long roomId){
        return stanzaDAO.getById(roomId);
    }

    /* UPDATE Room  */
    @PutMapping("/room/{id}")
    public ResponseEntity<Stanza> UpdateRoom(@PathVariable(value="id") Long roomId,@Valid @RequestBody Stanza RoomDtl){
        Stanza room=stanzaDAO.getById(roomId);
        if(room == null){ return ResponseEntity.notFound().build();}
        room.setNome(RoomDtl.getNome());
        Stanza roomUp=stanzaDAO.save(room);
        return ResponseEntity.ok().body(roomUp);
    }

    /* DELETE Room */
    @DeleteMapping("/room/{id}")
    public ResponseEntity<Stanza> deleteUtente(@PathVariable(value="id") Long roomId){
        Stanza room = stanzaDAO.getById(roomId);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        stanzaDAO.deleteRoom(room);
        return ResponseEntity.ok().build();
    }
}
