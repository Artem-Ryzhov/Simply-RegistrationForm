package controller;

import model.User;
import model.location.Location;
import store.Storage;
import store.city.CityStorage;
import store.country.CountryStorage;
import store.user.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 10.03.16
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 */
public class AddUser extends HttpServlet {
    private Storage dao = new UserStore();
    private Storage cdao = new CountryStorage();
    private Storage countryCity = new CityStorage();
    private User user = null;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        int c = Integer.parseInt(request.getParameter("id"));
        Location country = (Location) cdao.getById(c);
        int cit = Integer.parseInt(request.getParameter("cit"));
        Location city  = (Location) countryCity.getById(cit);
        user = new User(name,lastname,email,country.getName(),city.getName());
        dao.add(user);
        response.sendRedirect(String.format("%s%s", request.getContextPath(),"/userview"));
    }
}







