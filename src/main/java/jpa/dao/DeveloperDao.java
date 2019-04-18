package jpa.dao;

import jpa.entity.Developer;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class DeveloperDao implements DeveloperDaoI {
    private EntityManager entityManager;

    public DeveloperDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean insert(Developer developer) {
        entityManager.getTransaction().begin();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Developer developer) {
        entityManager.getTransaction().begin();
        entityManager.merge(developer);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public Developer read(Long id) {
        entityManager.getTransaction().begin();
        Developer developer = entityManager.find(Developer.class, id);
        entityManager.getTransaction().commit();
        return developer;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Developer.class, id));
        entityManager.getTransaction().commit();
        return true;
    }
}
