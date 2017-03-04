

package servlets;

import beans.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Database;


public class Category2NoProducts extends HttpServlet {

  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Database db = new Database();
        ArrayList<Category> Categories = new ArrayList();
        try {
            Categories = db.getCat2Pro();
        } catch (SQLException ex) {
            Logger.getLogger(Category2NoProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}