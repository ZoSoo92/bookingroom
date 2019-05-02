package it.roombooking.booking.repository;

import it.roombooking.booking.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrenotazioneRepo extends JpaRepository<Prenotazione,Long> {
}
