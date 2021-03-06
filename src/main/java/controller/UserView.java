package controller;


import store.Storage;
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
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class UserView extends HttpServlet {

       private Storage dao = new UserStore();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setAttribute("users",dao.getAllValues());
         request.getRequestDispatcher("/views/UserViewJsp.jsp").forward(request, response);
    }
}
