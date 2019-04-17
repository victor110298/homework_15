package jpa;
import jpa.dao.DeveloperDao;
import jpa.entity.Developer;
import jpa.util.HibernateUtil;

import javax.persistence.EntityManager;

public class JpaApplication {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Developer developer = new Developer();
        developer.setName("Fed");
        developer.setAge(34);
        developer.setSex("male");

        DeveloperDao developerDao = new DeveloperDao(entityManager);
        developerDao.insertDeveloper(developer);
        HibernateUtil.close();

    }
}
