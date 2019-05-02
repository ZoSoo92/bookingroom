package it.roombooking.booking.service;

import it.roombooking.booking.model.Prenotazione;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;


@Repository
public class CustomPrenotazione {

    @PersistenceContext
    EntityManager em;

    public String getEntity() {

        /*
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Prenotazione.class);
        //Root<Prenotazione> prenotazione = cq.from(Prenotazione.class);
        TypedQuery<Prenotazione> result = em.createQuery(cq);
        return result.getResultList();*/
        em.createNativeQuery("INSERT INTO Stanza ('id','nome') VALUES (?,?);").executeUpdate();
        return "Ok";
    }

}
