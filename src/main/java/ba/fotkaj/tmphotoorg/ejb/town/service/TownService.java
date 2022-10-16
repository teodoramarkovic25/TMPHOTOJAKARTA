package ba.fotkaj.tmphotoorg.ejb.town.service;


import ba.fotkaj.tmphotoorg.ejb.service.AbstractService;
import ba.fotkaj.tmphotoorg.ejb.town.entity.Town;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Local
@Stateless
public class TownService extends AbstractService<Town> {

    @PersistenceContext(unitName = "tmphotoPU")
    private EntityManager entityManager;

    public TownService() {
        super(Town.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return null;
    }
}
