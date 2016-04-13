package store.country;

import model.location.Country;
import model.location.Location;
import org.hibernate.*;
import service.HibernateUtil;
import store.ILocationStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 13.04.16
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */
public class CountryStorage implements ILocationStorage {


    public Collection<Location> getAllValues(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Location> countries = new ArrayList<>();
        try{
            tx = session.beginTransaction();
            String sql = "SELECT * FROM country";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(Country.class);
            countries = query.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return  countries;
    }


    public Location getById(int id) {
        Location country = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Country where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            country = (Location) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.flush();
            session.close();
        }
        return country;
    }

    @Override
    public Collection<Location> getAllValuesById(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    public int add(Location user) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Location user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void edit(Location user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


}
