package store.user;

import model.User;
import store.Storage;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 10.03.16
 * Time: 3:13
 * To change this template use File | Settings | File Templates.
 */

public interface UserStorage extends Storage<User> {
    public Collection<User> getAllValues();
    public int add(User user);
    public void deleteAll();
    void delete(User user);
    void edit(User user);
    User getById(int userid);

}
