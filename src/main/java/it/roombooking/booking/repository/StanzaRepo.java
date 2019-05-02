package it.roombooking.booking.repository;

import it.roombooking.booking.model.Stanza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StanzaRepo extends JpaRepository<Stanza,Long> {
}
