package it.springframework.springmvc.services.customer.dao;

import it.springframework.springmvc.domain.Customer;
import it.springframework.springmvc.domain.Product;
import it.springframework.springmvc.services.customer.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceJpaImpl implements CustomerService {
    private EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("from Customer ", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.find(Customer.class, id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
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
