

package servlets;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Database;


public class EnterVoucher extends HttpServlet {

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
      	PrintWriter out = response.getWriter();
        Database db = new Database();
        int user_id =Integer.parseInt(request.getParameter("ID"));
        long Number = Long.parseLong(request.getParameter("Number"));
        db.enterVoucher(user_id, Number);       
    }
}

   