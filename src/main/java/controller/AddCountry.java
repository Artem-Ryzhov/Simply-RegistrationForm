package controller;

import model.location.Location;
import store.Storage;
import store.country.CountryStorage;
import store.user.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 20.03.16
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class AddCountry extends HttpServlet {
    private Storage dao = new UserStore();
    private Storage countryCity = new CountryStorage();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Location> country = (List<Location>) countryCity.getAllValues();
        request.setAttribute("country", country);
        request.getRequestDispatcher("/views/user.jsp").forward(request, response);
    }
}

