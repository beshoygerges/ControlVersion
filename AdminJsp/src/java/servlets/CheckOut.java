

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Database;


public class CheckOut extends HttpServlet {

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
      	PrintWriter out = response.getWriter();
        Database db = new Database();
        int credit = 0;
        Integer user_id = Integer.parseInt(request.getParameter("ID"));
        Integer cartTotalPrice = Integer.parseInt(request.getParameter("total"));
        try {
            credit = db.CheckCredit(user_id);
            if(credit < cartTotalPrice)//credit is small
            {
                
            }
            else//ok
            {
                db.CheckOut(user_id,cartTotalPrice);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}