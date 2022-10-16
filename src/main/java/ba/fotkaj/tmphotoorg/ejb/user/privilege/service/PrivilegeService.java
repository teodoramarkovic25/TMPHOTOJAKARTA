package ba.fotkaj.tmphotoorg.ejb.user.privilege.service;

import ba.fotkaj.tmphotoorg.ejb.service.AbstractService;
import ba.fotkaj.tmphotoorg.ejb.user.privilege.entity.Privilege;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Local
@Stateless
public class PrivilegeService extends AbstractService<Privilege> {

    @PersistenceContext(unitName = "tmphotoPU")
    private EntityManager entityManager;

    public PrivilegeService() {
        super(Privilege.class);
    }


    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
