package test;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HibernateUtil;
import store.Storage;
import store.user.HibStore;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 25.03.16
 * Time: 20:16
 * To change this template use File | Settings | File Templates.
 */
public class TestUserrEdit {




    public static void main(String args []){
         Storage dao = new HibStore();
        TestUserrEdit test = new TestUserrEdit();
        User user =new User();
        user.setName("artem");
        user.setLastname("r");
        user.setEmail("erlgrei");
        user.setCountry("russia");

       int id =  test.addUser(user);

        User u = (User) dao.getById(id);
        u.setName("maks");
        dao.edit(u);


    }





    public int addUser(final User user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return user.getUserid();
    }


}
