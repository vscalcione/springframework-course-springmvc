package it.springframework.springmvc.services.jpaservices;

import it.springframework.springmvc.entities.Product;
import it.springframework.springmvc.services.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJPADaoImpl extends AbstractJpaDaoService implements ProductService {

    @Override
    public List<Product> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Product savedProduct = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();
        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class, id));
        entityManager.getTransaction().commit();
    }
}
