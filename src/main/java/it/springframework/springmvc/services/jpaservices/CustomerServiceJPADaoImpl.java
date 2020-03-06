package it.springframework.springmvc.services.jpaservices;

import it.springframework.springmvc.entities.Customer;
import it.springframework.springmvc.services.CustomerService;
import it.springframework.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceJPADaoImpl extends AbstractJpaDaoService implements CustomerService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService){
        this.encryptionService = encryptionService;
    }

    @Override
    public List<Customer> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if (domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject.getUser().setEncryptedPassword(encryptionService.encryptString(domainObject.getUser().getPassword()));
        }
        Customer savedCustomer = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();
        return savedCustomer;
    }

    @Override
    public void delete(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Customer.class, id));
        entityManager.getTransaction().commit();
    }
}
