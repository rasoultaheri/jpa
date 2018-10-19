package ir.imrasta.jpatest;

import ir.imrasta.jpatest.domain.*;
import ir.imrasta.jpatest.utils.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class App {

    public static void main(String[] args) {
        try {
//            testEMPersistenceContext();
//            testValidations();
//            testCallBackMethods();
            runQuery();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        System.exit(0);
//        createEmployee("ali", "arbabi", "1234567890", Keshvar.IRAN, "1234567890");
    }

    private static void runQuery() {
        createKharidSamples();

        queryKharidSimple();
        queryKharidReverse();
        queryKharidGroupBy();
    }

    private static void queryKharidGroupBy() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery();
        Root<RizKharid> r = cq.from(RizKharid.class);
        Expression s = cb.sum(r.<Number>get("mablaghNahayee"));

        cq.multiselect(r.get("naam"), s);
        cq.where(r.get("naam").in("Mast", "Panir"));
        cq.groupBy(r.get("naam"));
        cq.having(cb.greaterThan(s, 29000));
        cq.orderBy(cb.asc(r.get("naam")));

        TypedQuery<List> q = em.createQuery(cq);
        for(Object c : q.getResultList()) {
            Object[] row = (Object[]) c;
            System.out.println(row[0] + " " + row[1]);
        }

    }

    private static void queryKharidReverse() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Kharid> cq = cb.createQuery(Kharid.class);
        Root<RizKharid> r = cq.from(RizKharid.class);
        Join<RizKharid, Kharid> k = r.join("kharid");
        cq.select(k).distinct(true)
        .where(
                cb.like(k.<String>get("sharh"), "Kharid %"),
                r.get("naam").in("Dough", "Shir")
        )
        .orderBy(cb.desc(k.get("sharh")));
        TypedQuery<Kharid> q = em.createQuery(cq);
        List<Kharid> kList = q.getResultList();

        for (Kharid current : kList) {
            System.out.println(current.toString());
        }
    }

    private static void queryKharidSimple() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Kharid> cq = cb.createQuery(Kharid.class);
        Root<Kharid> k = cq.from(Kharid.class);
        cq.select(k);
        cq.where(
                cb.like(k.<String>get("sharh"), "Kharid%"),
                cb.greaterThan(k.<Comparable>get("jamTakhfif"), 0)
        );
        TypedQuery<Kharid> q = em.createQuery(cq);
        List<Kharid> kList = q.getResultList();

        for (Kharid current : kList) {
            System.out.println(current.toString());
        }
    }


    private static void createKharidSamples() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        em.getTransaction().begin();

        Kharid kharid = new Kharid("Kharid 1");
        RizKharid riz1 = new RizKharid(kharid, "Panir", 2, 5000D, 5D);
        RizKharid riz2 = new RizKharid(kharid, "Mast", 1, 15000D, 0D);
        RizKharid riz3 = new RizKharid(kharid, "Kareh", 3, 5000D, 5D);
        kharid.getItems().add(riz1);
        kharid.getItems().add(riz2);
        kharid.getItems().add(riz3);

        Kharid kharid2 = new Kharid("Kharid 2");
        RizKharid riz21 = new RizKharid(kharid2, "Panir", 3, 5000D, 5D);
        RizKharid riz22 = new RizKharid(kharid2, "Shir", 2, 15000D, 0D);
        RizKharid riz23 = new RizKharid(kharid2, "Kareh", 3, 5000D, 5D);
        kharid2.getItems().add(riz21);
        kharid2.getItems().add(riz22);
        kharid2.getItems().add(riz23);

        Kharid kharid3 = new Kharid("Kharid 3");
        RizKharid riz31 = new RizKharid(kharid3, "Panir", 1, 5000D, 0D);
        RizKharid riz32 = new RizKharid(kharid3, "Mast", 1, 15000D, 0D);
        RizKharid riz33 = new RizKharid(kharid3, "Dough", 3, 5000D, 0D);
        kharid3.getItems().add(riz31);
        kharid3.getItems().add(riz32);
        kharid3.getItems().add(riz33);

        em.persist(kharid);
        em.persist(kharid2);
        em.persist(kharid3);
        em.getTransaction().commit();
    }


    private static Kharid testCallBackMethods() {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        em.getTransaction().begin();

        Kharid kharid = new Kharid("Kharid 1");
        RizKharid riz1 = new RizKharid(kharid, "Panir", 2, 5000D, 5D);
        RizKharid riz2 = new RizKharid(kharid, "Mast", 1, 15000D, 0D);
        RizKharid riz3 = new RizKharid(kharid, "Kareh", 3, 5000D, 5D);

        kharid.getItems().add(riz1);
        kharid.getItems().add(riz2);
        kharid.getItems().add(riz3);

        em.persist(kharid);
        em.getTransaction().commit();

        return kharid;
    }

    private static void testValidations() {
        Employee java = createEmployee("Javad", "Basirat", Keshvar.IRAN, "1234567890", "123456", null);
    }

    private static void testEMPersistenceContext() {
        Employee ali = createEmployee("ali", "arbabi", Keshvar.IRAN, "1234567890", "1234567890", "Tehran");

        EntityManager em1 = JpaUtil.getInstance().getNewEntityManager();
        Employee e1 = em1.find(Employee.class, ali.getId());
        Employee e2 = em1.find(Employee.class, ali.getId());

        EntityManager em2 = JpaUtil.getInstance().getNewEntityManager();
        Employee e3 = em2.find(Employee.class, ali.getId());

        System.out.println(e1 == e2 ? "e1 same as e2" : "e1 isnt same as e2");
        System.out.println(e1 == e3 ? "e1 same as e3" : "e1 isnt same as e3");

    }


    private static Employee createEmployee(String firstName,
                                           String lastName, Keshvar melliat, String codeMelli, String codePosti, String address) {
        EntityManager em = JpaUtil.getInstance().getEntityManager();
        em.getTransaction().begin();
        Employee emp = new Employee(firstName, lastName, melliat, codeMelli);
        Location loc = new Location(address, codePosti);
        emp.setLocation(loc);
        em.persist(emp);
        em.getTransaction().commit();
        return emp;
    }


}
