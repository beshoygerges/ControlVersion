

package servlets;

import beans.CartCheckOut;
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


public class search extends HttpServlet {

  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
      	PrintWriter out = response.getWriter();
        Database db = new Database();
        ArrayList<Product> Products;
        String key = request.getParameter("KeySearch");
        String category = request.getParameter("Category");
        try {
            Products = db.search(key,category);
        } catch (SQLException ex) {
            Logger.getLogger(search.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   
}