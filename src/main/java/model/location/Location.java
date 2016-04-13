package model.location;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 13.04.16
 * Time: 1:16
 * To change this template use File | Settings | File Templates.
 */
public interface Location {
    public int getId();
    public String getName();
    public int getCountry_id();

    public void setId(int id);
    public void setName(String name);
}
