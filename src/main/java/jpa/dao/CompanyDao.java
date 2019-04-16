package jpa.dao;

import jpa.entity.Companies;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class CompanyDao {
    private EntityManager entityManager;

    public CompanyDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean insertCompany(Companies company) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(company);
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return false;
        }
    }

    public boolean updateCompany(Companies company) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(company);
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return false;
        }
    }

    public Companies readCompany(Long id) {
        try {
            entityManager.getTransaction().begin();
            Companies company = entityManager.find(Companies.class, id);
            entityManager.getTransaction().commit();
            return company;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return null;
        }
    }

    public boolean deleteCompany(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Companies.class, id));
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return false;
        }
    }
}
