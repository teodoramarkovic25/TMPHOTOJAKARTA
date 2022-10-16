package ba.fotkaj.tmphotoorg.ejb.photoshoot.resrevation;

import ba.fotkaj.tmphotoorg.controller.login.UserSession;
import ba.fotkaj.tmphotoorg.ejb.photoshoot.entity.Reservation;
import ba.fotkaj.tmphotoorg.ejb.service.AbstractService;
import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Local
@Stateless

public class ReservationService extends AbstractService<Reservation> {

    @PersistenceContext(unitName = "tmphotoPU")
    private EntityManager entityManager;

    public ReservationService() {
        super(Reservation.class);
    }


    public List<Reservation> findByUserCreator(User userCreator) {
        Query query = getEntityManager().createNamedQuery("Reservation.findByUserCreator");
        query.setParameter("userCreator", userCreator);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return Collections.emptyList();

        }

    }


    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
