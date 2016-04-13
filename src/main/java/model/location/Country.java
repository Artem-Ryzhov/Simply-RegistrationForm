package model.location;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 21.03.16
 * Time: 0:31
 * To change this template use File | Settings | File Templates.
 */
public class Country implements Location{
    private int id;
    private String county_name;

    public Country() {
    }

    public Country(int id, String county_name) {
        this.id = id;
        this.county_name = county_name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return county_name;
    }

    @Override
    public int getCountry_id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
      this.county_name = name;
    }



    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", county_name='" + county_name + '\'' +
                '}';
    }
}
