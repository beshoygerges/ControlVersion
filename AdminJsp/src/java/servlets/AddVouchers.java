

package servlets;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Database;


public class AddVouchers extends HttpServlet {
    @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          Database db = new Database();  
          int Number;
          Number = Integer.parseInt(request.getParameter("Number"));
          String Value = request.getParameter("Value");
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
              
              out.print(Number);
          out.print(Value);
          db.AddVouchers(Number, Value);
                  
    	
    	
  }
     
    
}