public class JpaTest {


//    public static void main(String[] args) {
//        try {
//            createEmployee(1, "Ravi", null, "Textile");
////            createEmployee(1, "Ravi", "Raj", "Textile");
//            testEMPersistenceContext();
////            createEmployee(2, "Amit", "Raj", "IT");
////            createEmployee(3, "Nitish", "Kumar", "Marketing");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.exit(0);
//    }
//
//    private static void createEmployee(int id, String firstName,
//                                       String lastName, String dept) {
//
//        EntityManager em = JpaUtil.getInstance().getEntityManager();
//        try {
//            em.getTransaction().begin();
//            EmployeeEntity emp = new EmployeeEntity(id, firstName, lastName, dept);
//            emp.setCodePosti("12345-67890");
//            em.persist(emp);
//            em.getTransaction().commit();
//        } catch (ConstraintViolationException e) {
//            e.printStackTrace();
//            em.getTransaction().rollback();
//        }
//    }
//
//
//    private static void testEMPersistenceContext() {
//        EntityManager em1 = JpaUtil.getInstance().getNewEntityManager();
//        EmployeeEntity e1 = em1.find(EmployeeEntity.class, 1);
//        EmployeeEntity e2 = em1.find(EmployeeEntity.class, 1);
//
//        EntityManager em2 = JpaUtil.getInstance().getNewEntityManager();
//        EmployeeEntity e3 = em2.find(EmployeeEntity.class, 1);
//
//        System.out.println(e1 == e2 ? "e1 same as e2" : "e1 isnt same as e2");
//        System.out.println(e1 == e3 ? "e1 same as e3" : "e1 isnt same as e3");
//    }

}