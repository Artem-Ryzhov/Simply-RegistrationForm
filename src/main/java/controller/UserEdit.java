package controller;

import model.User;
import model.location.Location;
import store.Storage;
import store.city.CityStorage;
import store.country.CountryStorage;
import store.user.UserStore;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserEdit extends HttpServlet {
    private Storage store = new UserStore();
    private Storage cityCountry = new CityStorage();
    private Storage cdao = new CountryStorage();
    private User user = null;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) store.getById(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("users", user);
        List<Location> country = (List<Location>) cdao.getAllValues();
        req.setAttribute("country", country);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/EditUser.jsp");
        dispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        int id = Integer.parseInt(req.getParameter("id"));
        int cit = Integer.parseInt(req.getParameter("cit"));
        Location country = (Location) cdao.getById(id);
        Location city  = (Location) cityCountry.getById(cit);
        String cname = country.getName();
        user.setName(name);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setCountry(cname);
        user.setCity(city.getName());

        store.edit(user);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(),"/userview"));
    }

}
