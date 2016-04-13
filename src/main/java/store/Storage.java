package store;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 01.04.16
 * Time: 19:14
 * To change this template use File | Settings | File Templates.
 */
public interface Storage <T> {

    public Collection<T> getAllValues();
    public int add(T user);
    public void deleteAll();
    void delete(T user);
    void edit(T user);
    T getById(int userid);
    Collection<T> getAllValuesById(int id);
}
