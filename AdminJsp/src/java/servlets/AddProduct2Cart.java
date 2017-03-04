

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
import beans.CartCheckOut;


public class AddProduct2Cart extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
      	PrintWriter out = response.getWriter();
        Database db = new Database();
        CartCheckOut detail;
        Integer product_id = Integer.parseInt(request.getParameter("Product_ID"));
        Integer user_id = Integer.parseInt(request.getParameter("ID"));
            try {
                int state = db.addProduct2Cart(user_id, product_id);
                if(state == 0)
                {
                    out.print("0:0");
                }
                else
                {
                    detail = db.getItemsPrice(user_id);
                    //out.print(detail.getPrice():detail.getPrice());
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AddProduct2Cart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }             
        
    }

    
