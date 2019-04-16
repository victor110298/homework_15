package jpa.dao;

import jpa.entity.Developers;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class DeveloperDao {
    private EntityManager entityManager;

    public DeveloperDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean insertDeveloper(Developers developers) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(developers);
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

    public boolean updateDeveloper(Developers developers) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(developers);
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

    public Developers readDeveloper(Long id) {
        try {
            entityManager.getTransaction().begin();
            Developers developer = entityManager.find(Developers.class, id);
            entityManager.getTransaction().commit();
            return developer;
        } catch (RuntimeException e) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            log.error(e.getMessage());
            return null;
        }
    }

    public boolean deleteDeveloper(Long id) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.find(Developers.class, id));
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
