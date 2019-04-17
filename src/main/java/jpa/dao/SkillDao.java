package jpa.dao;

import jpa.entity.Skill;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;

@Log4j
public class SkillDao implements Contract<Skill> {
    private EntityManager entityManager;

    public SkillDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public boolean insert(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.persist(skill);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(Skill skill) {
        entityManager.getTransaction().begin();
        entityManager.merge(skill);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public Skill read(Long id) {
        entityManager.getTransaction().begin();
        Skill skill = entityManager.find(Skill.class, id);
        entityManager.getTransaction().commit();
        return skill;
    }

    @Override
    public boolean delete(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Skill.class, id));
        entityManager.getTransaction().commit();
        return true;
    }
}
