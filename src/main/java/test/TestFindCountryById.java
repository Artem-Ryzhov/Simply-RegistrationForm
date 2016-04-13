package test;

import model.location.Country;
import store.Storage;
import store.country.CountryStorage;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 24.03.16
 * Time: 21:15
 * To change this template use File | Settings | File Templates.
 */
public class TestFindCountryById {

    public static void main(String args []){
        Storage storage = new CountryStorage();
        Country country  = (Country) storage.getById(2);
        System.out.println(country.toString());

    }
}
