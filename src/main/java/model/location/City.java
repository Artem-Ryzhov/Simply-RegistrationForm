package model.location;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 21.03.16
 * Time: 0:32
 * To change this template use File | Settings | File Templates.
 */
public class City implements Location {
    private int id;
    private String city_name;
    private int country_id;

    public int getCountry_id() {
        return country_id;
    }

    public City() {

    }

    public City(int id, String city_name,int country_id ) {
        this.id = id;
        this.city_name = city_name;
        this.country_id = country_id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return city_name;
    }



    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.city_name = name;
    }



    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city_name='" + city_name + '\'' +
                ", country_id=" + country_id +
                '}';
    }
}
