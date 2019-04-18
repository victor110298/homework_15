package jpa.dao;

import jpa.entity.Customer;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class CustomerDao implements CustomerDaoI {
    private EntityManager entityManager;

    public CustomerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean insert(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        entityManager.getTransaction().begin();
        entityManager.merge(customer);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public Customer read(Long id) {
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        return customer;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Customer.class, id));
        entityManager.getTransaction().commit();
        return true;
    }
}
