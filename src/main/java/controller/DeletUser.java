package controller;

import model.User;
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
 * Date: 28.03.16
 * Time: 1:20
 * To change this template use File | Settings | File Templates.
 */
public class DeletUser extends HttpServlet {
    private Storage store = new UserStore();
    private User user = null;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User) store.getById(Integer.valueOf(req.getParameter("id")));
        store.delete(user);
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/userview"));
    }

}
