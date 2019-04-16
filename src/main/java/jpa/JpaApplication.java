package jpa;
import jpa.dao.DeveloperDao;
import jpa.entity.Developers;
import jpa.util.HibernateUtil;

import javax.persistence.EntityManager;

public class JpaApplication {
    public static void main(String[] args) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Developers developers = new Developers();
        developers.setName("Fed");
        developers.setAge(34);
        developers.setSex("male");

        DeveloperDao developerDao = new DeveloperDao(entityManager);
        developerDao.insertDeveloper(developers);
        HibernateUtil.close();

    }
}
