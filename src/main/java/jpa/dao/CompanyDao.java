package jpa.dao;

import jpa.entity.Company;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class CompanyDao implements CompanyDaoI{
    private EntityManager entityManager;

    public CompanyDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean insert(Company company) {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
            return true;
    }

    @Override
    public boolean update(Company company) {
            entityManager.getTransaction().begin();
            entityManager.merge(company);
            entityManager.getTransaction().commit();
            return true;
    }

    @Override
    public Company read(Long id) {
            entityManager.getTransaction().begin();
            Company company = entityManager.find(Company.class, id);
            entityManager.getTransaction().commit();
            return company;
    }

    public boolean delete(Long id) {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Company.class, id));
            entityManager.getTransaction().commit();
            return true;
        }
    }
