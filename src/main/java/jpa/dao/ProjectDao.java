package jpa.dao;

import jpa.entity.Project;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class ProjectDao implements ProjectDaoI {
    private EntityManager entityManager;

    public ProjectDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean insert(Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Project project) {
        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public Project read(Long id) {
        entityManager.getTransaction().begin();
        Project project = entityManager.find(Project.class, id);
        entityManager.getTransaction().commit();
        return project;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Project.class, id));
        entityManager.getTransaction().commit();
        return true;
    }
}
