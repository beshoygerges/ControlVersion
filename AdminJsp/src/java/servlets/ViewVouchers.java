

package servlets;

import beans.Voucher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilities.Database;


public class ViewVouchers extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Value;
        ArrayList<Voucher> vouchers;
        Database db = new Database();
        Value = Integer.parseInt(request.getParameter("Value"));
         vouchers = db.getVouchers(Value);
        
    }

   
}