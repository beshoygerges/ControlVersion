/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BOSHA
 */
public class Check extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        ServletConfig config = getServletConfig();
        
        String country = config.getInitParameter("country");
        String user = req.getParameter("username");
        String password = req.getParameter("password");
        User p = new User(user, password);
        req.getSession().setAttribute("user", p);
        resp.getWriter().print("<p>welcome " + user + " from " + country + "</p>");
        resp.getWriter().print("<br><a href='second'>click</a>");

    }

}
