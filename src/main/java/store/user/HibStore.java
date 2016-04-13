package store.user;

import model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HibernateUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 11.03.16
 * Time: 1:28
 * To change this template use File | Settings | File Templates.
 */

public class HibStore implements UserStorage {


    @Override
    public Collection<User> getAllValues() {
        final Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from User").list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public int add(final User user) {
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

    @Override
    public void deleteAll() {
        String sql = "DELETE from userss";
        final Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            List<User> results = session.createQuery("from User").list();
            for ( User i : results){
                session.delete(i);
            }
        } finally {
            tx.commit();
            session.close();
        }
    }

    public void delete(User user){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public void edit(User user) {
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getById(int userid) {
        User user = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from User where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", userid);
            user = (User) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.flush();
            session.close();
        }
        return user;
    }

    @Override
    public Collection<User> getAllValuesById(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

}




