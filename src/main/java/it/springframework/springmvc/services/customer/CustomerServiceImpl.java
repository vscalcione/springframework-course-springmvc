package it.springframework.springmvc.services.customer;

import it.springframework.springmvc.domain.Customer;
import it.springframework.springmvc.domain.DomainObject;
import it.springframework.springmvc.services.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll(){
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id){
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObj){
        return (Customer) super.saveOrUpdate(domainObj);
    }

    @Override
    public void delete(Integer id){
        super.delete(id);
    }

}
