package servlets;
import utilities.Database;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class servletAddProduct extends HttpServlet {

    String name, description, image, fullName;
    int price;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(request);

            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();                       
                if (!item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String fileName = item.getName();
                    String contentType = item.getContentType();
                    long sizeInBytes = item.getSize();
                    String filePath = getServletContext().getRealPath("") + File.separator + "upload" + File.separator + "product" + File.separator;
                                        

                    InputStream uploadedStream = item.getInputStream();
                    FileItem fi = (FileItem) item;
                    fullName = System.currentTimeMillis() + fileName;
                    out.print(filePath);
                    File file = new File(filePath + fullName);
                    fi.write(file);
                    uploadedStream.close();

                } else {
                    out.println("in code");
                    String temp = item.getFieldName();
                    String tempValue = item.getString();
                    if (temp.equals("name")) {
                        name = tempValue;
                    }
                    if (temp.equals("description")) {
                        description = tempValue;
                    }
                    if (temp.equals("price")) {
                        price = Integer.parseInt(tempValue);
                    }
                    
                }
            }
            
        } catch (FileUploadException ex) {

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);

        } catch (Exception ex) {
            
        }
    Database db = new Database();
        
        db.addProuduct(name, description, price, fullName);    
    }
    
}