package controller;

import model.location.Location;
import store.Storage;
import store.city.CityStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 24.03.16
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */
public class AddCity extends HttpServlet {
    private Storage store = new CityStorage();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html:charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Location> cities = (ArrayList<Location>) store.getAllValuesById(id);

        PrintWriter out = response.getWriter();
        response.getWriter().write("City : <select name = 'cit'>" );
        for (int i = 0; i < cities.size(); i++){
            response.getWriter().write("<option value = '"+ cities.get(i).getId() +"'  >" + cities.get(i).getName() + "</option>");
        }
         response.getWriter().write("</select>");
    }

}
