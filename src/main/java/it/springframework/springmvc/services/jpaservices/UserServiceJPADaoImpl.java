package it.springframework.springmvc.services.jpaservices;

import it.springframework.springmvc.entities.User;
import it.springframework.springmvc.services.UserService;
import it.springframework.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class UserServiceJPADaoImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(User.class, id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }
        User savedUser = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();
        return savedUser;
    }

    @Override
    public void delete(Integer id) {
        EntityManager entity = entityManagerFactory.createEntityManager();
        entity.getTransaction().begin();
        entity.remove(entity.find(User.class, id));
        entity.getTransaction().commit();
    }
}
