package ir.imrasta.jpatest.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static JpaUtil instance;
    private EntityManagerFactory emf ;
    private EntityManager em;

    private JpaUtil() {
    }
    private EntityManagerFactory getEmf() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("MainPU");
        }

        return emf;
    }


    public static JpaUtil getInstance() {
        if (instance == null) {
            instance = new JpaUtil();
        }

        return instance;
    }

    public EntityManager getEntityManager() {
        if (em == null)
            em = getEmf().createEntityManager();

        return em;
    }

    public EntityManager getNewEntityManager() {
        return getEmf().createEntityManager();
    }

}
