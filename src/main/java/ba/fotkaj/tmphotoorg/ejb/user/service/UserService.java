package ba.fotkaj.tmphotoorg.ejb.user.service;

import ba.fotkaj.tmphotoorg.controller.register.RegisterModel;
import ba.fotkaj.tmphotoorg.ejb.service.AbstractService;
import ba.fotkaj.tmphotoorg.ejb.town.entity.Town;
import ba.fotkaj.tmphotoorg.ejb.town.service.TownService;
import ba.fotkaj.tmphotoorg.ejb.user.entity.User;
import ba.fotkaj.tmphotoorg.ejb.user.privilege.entity.Privilege;
import ba.fotkaj.tmphotoorg.ejb.user.privilege.service.PrivilegeService;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.util.List;
import java.util.logging.Logger;

import static ba.fotkaj.tmphotoorg.ejb.user.privilege.entity.Privilege.CLIENT_PRIVILEGE_ID;

@Local
@Stateless
public class UserService extends AbstractService<User> {

    @PersistenceContext(unitName = "tmphotoPU")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @Inject
    private TownService townService;

    @Inject
    private PrivilegeService privilegeService;


    public UserService() {
        super(User.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && pbkdf2PasswordHash.verify(password.toCharArray(), user.getPassword())) {
            return user;

        }
        return null;

    }

    public User findByUsername(String username) {
        Query query = getEntityManager().createNamedQuery("User.findByUsername");
        query.setParameter("username", username);

        try {
            return (User) query.getSingleResult();

        } catch (NonUniqueResultException | NoResultException e) {
            Logger.getLogger(getClass().getName()).info("Not exist user or not unique" + e.getMessage());
            return null;

        }
    }

    public User register(RegisterModel registerModel) {
        User user = new User();
        user.setName(registerModel.getName());
        user.setSurname(registerModel.getSurname());
        user.setUsername(registerModel.getUsername());
        String hashedPass = pbkdf2PasswordHash.generate(registerModel.getPlainPassword().toCharArray());
        user.setPassword(hashedPass);
        Town town = townService.find(registerModel.getTownId());
        user.setTown(town);
        Privilege clientPrivilege = privilegeService.find(CLIENT_PRIVILEGE_ID);
        user.setPrivilege(clientPrivilege);
        user.setEmail(registerModel.getEmail());
        create(user);
        return user;
    }
}
