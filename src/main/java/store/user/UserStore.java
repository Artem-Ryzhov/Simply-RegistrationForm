package store.user;

import model.User;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 10.03.16
 * Time: 20:07
 * To change this template use File | Settings | File Templates.
 */


public class UserStore implements UserStorage {

    UserStorage dao = new HibStore();

    @Override
    public Collection<User> getAllValues() {
        return dao.getAllValues();
    }

    @Override
    public int add(User user) {
        dao.add(user);
        return user.getUserid();
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    public void edit( User user) {
        dao.edit(user);
    }

    @Override
    public User getById(int userid) {
        return dao.getById(userid);
    }

    @Override
    public Collection<User> getAllValuesById(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
