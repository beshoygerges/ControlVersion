/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.DataBaseHandler;
import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Samir
 */
@WebServlet(name = "Register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    DataBaseHandler dataBaseHandler;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        this.dataBaseHandler = DataBaseHandler.getinstance();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("emial");
        String password = request.getParameter("password");
        String DateOfBirth = request.getParameter("DateOfBirth");
         LocalDate localDate = LocalDate.parse(DateOfBirth);
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String creditCardExpireDate = request.getParameter("creditCardExpireDate");
        User newUser = new User(email, null, gender, firstName, lastName, localDate, password, mobile, address, "user");
//        out.println(firstName);
//        out.println(lastName);
//        out.println(email);
//        out.println(password);
//        out.println(DateOfBirth);
//        out.println(gender);
//        out.println(address);
//        out.println(mobile);
//        out.println(creditCardNumber);

        dataBaseHandler.signup(newUser);
        
    }
}
