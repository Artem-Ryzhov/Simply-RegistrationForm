package test;

import model.location.City;
import org.hibernate.*;
import service.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 28.03.16
 * Time: 0:10
 * To change this template use File | Settings | File Templates.
 */
public class TestGetValuesFromCity {

    public static void main(String args[]){
        TestGetValuesFromCity test = new TestGetValuesFromCity();
        ArrayList<City> list = (ArrayList<City>) test.cityCollection();
        // for (int i = 0;  i < list.size(); i++){
        //   System.out.println(list.get(i).toString());
        //  }

        City city = test.getCitybyId(3);
        System.out.println(city.toString());
        System.out.println("==================");

        List<City> city2 = (List<City>) test.getAllCitysByCountryId(1);
         for (int i = 0;  i < city2.size(); i++){
             System.out.println(city2.get(i).toString());
         }

    }

    public Collection<City> cityCollection( ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<City> cities = new ArrayList<City>();
        try{
            tx = session.beginTransaction();
            String sql = "SELECT * FROM city";
            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity(City.class);
            cities = query.list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return  cities;
    }


    public City getCitybyId(int id) {
        ArrayList<City> list = new ArrayList<>();
        City city = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from City where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
            city = (City) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.flush();
            session.close();
        }
        return city;
    }

    public Collection<City> getAllCitysByCountryId(int id) {
        ArrayList<City> list = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from City where country_id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", id);
           list = (ArrayList<City>) query.list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.getTransaction().commit();
            session.flush();
            session.close();
        }
        return list;
    }







}
