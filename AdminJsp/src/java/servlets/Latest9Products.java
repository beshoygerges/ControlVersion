
package servlets;

import beans.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Database;


public class Latest9Products extends HttpServlet {

   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Database db = new Database();
        ArrayList<Product> products;
        try {
            products = db.getLatest9Products();
        } catch (SQLException ex) {
            Logger.getLogger(Latest9Products.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}