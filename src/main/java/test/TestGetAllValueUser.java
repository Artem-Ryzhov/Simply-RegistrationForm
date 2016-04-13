package test;

import model.User;
import store.Storage;
import store.user.HibStore;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 24.03.16
 * Time: 22:01
 * To change this template use File | Settings | File Templates.
 */
public class TestGetAllValueUser {

    public static void main(String args []){
        Storage dao = new HibStore();
        User user = new User();
        user.setName("artem");
        user.setLastname("d");
        user.setEmail("sdsd");
        user.setCountry("russia");
        dao.add(user);
        ArrayList<User> list = (ArrayList<User>) dao.getAllValues();
        for (int i = 0; i < list.size(); i++){
            User user2 = list.get(i);
            System.out.println("id " + user2.getUserid() + " Country name  " + user2.getCountry() + " lastname " + user2.getLastname() );
        }

    }

}
