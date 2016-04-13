package store.city;

import model.location.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.HibernateUtil;
import store.ILocationStorage;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 13.04.16
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */
public class CityStorage implements ILocationStorage {


    public Location getById(int id) {
          ArrayList<Location> list = new ArrayList<>();
          Location city = null;
          Transaction trns = null;
          Session session = HibernateUtil.getSessionFactory().openSession();
          try {
              trns = session.beginTransaction();
              String queryString = "from City where id = :id";
              Query query = session.createQuery(queryString);
              query.setInteger("id", id);
              city = (Location) query.uniqueResult();
          } catch (RuntimeException e) {
              e.printStackTrace();
          } finally {
              session.getTransaction().commit();
              session.flush();
              session.close();
          }
          return city;
      }


    public Collection<Location> getAllValuesById(int id) {
          ArrayList<Location> list = new ArrayList<>();
          Transaction trns = null;
          Session session = HibernateUtil.getSessionFactory().openSession();
          try {
              trns = session.beginTransaction();
              String queryString = "from City where country_id = :id";
              Query query = session.createQuery(queryString);
              query.setInteger("id", id);
              list = (ArrayList<Location>) query.list();
          } catch (RuntimeException e) {
              e.printStackTrace();
          } finally {
              session.getTransaction().commit();
              session.flush();
              session.close();
          }
          return list;
      }



    @Override
    public Collection<Location> getAllValues() {
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
