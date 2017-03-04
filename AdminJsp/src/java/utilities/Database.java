/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import beans.CartCheckOut;
import beans.Category;
import beans.Product;
import beans.Voucher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
public class Database {

    private Connection con;
     Connection c;
    PreparedStatement ps;
    Statement st;
    ResultSet rs,rs1;


    public Database() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root", "iti");
             
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"1").log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()+"2").log(Level.SEVERE, null, ex);
        }
    }// end constuctor 

    public void addProuduct(String name,String desc, int price, String img) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO product(p_name,p_desc,price,p_image) VALUES (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setInt(3, price);
            ps.setString(4, img);
           ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"3").log(Level.SEVERE, null, ex);
        }
        

    }

  public void addCategory(String name, String desc) {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO category(cat_name,cat_desc) VALUES (?,?)");
            ps.setString(1, name);
            ps.setString(2, desc);
              ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"3").log(Level.SEVERE, null, ex);
        }
        
    }
  public void addQunatity(String id, String qunt) {
        try {
            int qunt1=Integer.parseInt(qunt);
            int Id=Integer.parseInt(id);
            PreparedStatement ps = con.prepareStatement("UPDATE product SET quantity = ? where p_id = ? ");
            ps.setInt(1, qunt1);
            ps.setInt(2, Id);            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"3").log(Level.SEVERE, null, ex);
        }
    }

  public ResultSet ShowAllUser()
    {
        try {
            PreparedStatement ps = con.prepareStatement("Select * from user");
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public ResultSet ShowAllProduct()
    {
        try {
            PreparedStatement ps = con.prepareStatement("Select * from product");
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
  public ResultSet ShowAllCategory()
    {
        try {
            PreparedStatement ps = con.prepareStatement("Select * from category");
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    public void deleteProduct(int id) {
        try {       
            PreparedStatement ps = con.prepareStatement("DELETE FROM  product where p_id = ? ");
            ps.setInt(1, id);            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteUser(int id) {
        try {       
            PreparedStatement ps = con.prepareStatement("DELETE FROM  user where u_id = ? ");
            ps.setInt(1, id);            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public void deleteCategory(int id) {
        try {       
            PreparedStatement ps = con.prepareStatement("DELETE FROM  category where cat_id = ? ");
            ps.setInt(1, id);            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public ResultSet GetProductById(int id)
    {
        try {
            PreparedStatement ps = con.prepareStatement("Select * from product where p_id=?");
            ps.setInt(1, id);
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
  public ResultSet getCategoryById(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("Select * from category where cat_id=?");
            ps.setInt(1, id);
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
public ResultSet getUserById(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("Select * from user where u_id=?");
            ps.setInt(1, id);
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
public ResultSet getHistoryByUserId(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT history.p_id,history.u_id, history.unit_price, history.quantity ,product.p_id, product.p_name FROM history,product WHERE history.p_id = product.p_id and history.u_id=?");
            ps.setInt(1, id);
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

public ResultSet getcartByUserId(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("SELECT cart.u_id, cart.quantity, cart.p_id,product.p_id, product.p_name FROM cart,product WHERE cart.p_id=product.p_id and cart.u_id=?");
            ps.setInt(1, id);
           ResultSet rs = ps.executeQuery() ;
           return rs;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void updateCategory(int id, String name, String desc) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE `category` SET `cat_name`=?,`cat_desc`=? WHERE cat_id=?");
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setInt(3, id);
            
              ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"3").log(Level.SEVERE, null, ex);
        }
        
    }
    
      public void updateProduct(int id, String name, String desc,int price,int cat) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE `product` SET`p_name`=?,`p_desc`=?,`price`=?,`cat_id`=? WHERE  `p_id`=?");
            ps.setString(1, name);
            ps.setString(2, desc);
            ps.setInt(3, price);
            ps.setInt(4, cat);
            ps.setInt(5, id);
            
              ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"3").log(Level.SEVERE, null, ex);
        }
        
    }
       public void updateUser(int id, String name, String email,String address,String mobile) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE `user` SET `username`=?,`email`=?,`address`=?,`mobile`=?WHERE `u_id`=?");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, mobile);
            ps.setInt(5, id);
            
              ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()+"3").log(Level.SEVERE, null, ex);
        }
        
    }
       public ResultSet userProfile (int id)
       {
           return null;
       }
           public int addProduct2Cart(int user_id,int product_id) throws SQLException
    {
        int newquantity;
        ps=c.prepareStatement("Select quantity from product where product_id=?"); 
        ps.setInt(1,product_id);
        rs1 = ps.executeQuery();
        if(rs1.getInt(1)<1)
        {
            return 0;
        }
        else
        {    
        ps=c.prepareStatement("Select quantity from cart where user_id = ? and product_id=?"); 
        ps.setInt(1,user_id);
        ps.setInt(2,product_id);
        rs = ps.executeQuery();  
        if(rs.next())//product already in cart
            {
                newquantity = rs.getInt(1)+1;
                 ps=c.prepareStatement("UPDATE cart set quantity = ? where user_id = ? and product_id=?");
                 ps.setInt(1,newquantity);
                 ps.setInt(2,user_id);
                 ps.setInt(3,product_id);
                 ps.executeUpdate();
            }
        else//product doesn't exist
            {
                ps=c.prepareStatement("INSERT into cart VALUES(?,?,1)");
                 ps.setInt(2,user_id);
                 ps.setInt(3,product_id);
                 ps.executeUpdate();
            }
        return 1;
        }
    }
    
    
    
    public CartCheckOut getItemsPrice(int user_id) throws SQLException
    {
       int NoItems = 0;
       int TotalPrice = 0;
       CartCheckOut cart = new CartCheckOut();
       ps=c.prepareStatement("Select p.price,c.quantity from cart c,product p where c.user_id = ? and p.p_id = c.product_id ");
       ps.setInt(1, user_id);
       rs = ps.executeQuery();
       if(rs.next())
        {
            NoItems = NoItems + rs.getInt(2);
            TotalPrice = TotalPrice +(rs.getInt(1)*rs.getInt(2));
        }
       cart.setNoProducts(NoItems);
       cart.setPrice(TotalPrice);
       return(cart);
    }
    public void AddVouchers(int num,String value)
    {
        for(int i=0;i < num;i++)
            {
                Long number;
                    Random r = new Random();
                    long start = 1111111111111111L;
                    long end = 9999999999999999L;
                    number = (start+((long)(r.nextDouble()*(end-start))));
            try {                
                ps = c.prepareStatement("INSERT INTO `voucher`(`serial`, `value`) VALUES (?,?)");
                 ps.setLong(1,number);
                ps.setString(2,value);
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
                           }
    }
    public void addVouchers(long Number,long Value) 
    {
        try {
            ArrayList<Long>Vouchers= new ArrayList();
            long number;
            st = c.createStatement();
            rs = st.executeQuery("select serial from voucher");
            while(rs.next())
            {
                Vouchers.add(rs.getLong(1));
            }
            for(int i=0;i < Number;i++)
            {
                do
                {
                    Random r = new Random();
                    long start = 1111111111111111L;
                    long end = 9999999999999999L;
                    number = start+((long)(r.nextDouble()*(end-start)));
                }while(Vouchers.contains(number));   
                Vouchers.add(number);
                ps = c.prepareStatement("insert into voucher VALUES(?,?)");
                ps.setLong(1,number);
                ps.setLong(2,Value);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int CheckCredit(int user_id) throws SQLException
    {
            int credit = 0;
            ps = c.prepareStatement("select credit from user where u_id=?");
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            credit = rs.getInt(1);
            return(credit);
    }
    
    public void CheckOut(int user_id,int cartTotalPrice) throws SQLException
    {
        int newCredit = 0;
        int price = 0;
        int userid = 0;
        int productid =0;
        int quantity = 0;
            ps = c.prepareStatement("select credit from user where u_id=?");
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            newCredit = rs.getInt(1) - cartTotalPrice;
            ps = c.prepareStatement("UPDATE user set credit =?  where u_id=?");
            ps.setInt(1,newCredit);
            ps.setInt(1,user_id);
            ps.executeUpdate();
            ps = c.prepareStatement("select p.price,c.* from c cart,p product where c.u_id=? and p.p_id = c.product_id");
            ps.setInt(1,user_id);
            rs = ps.executeQuery();
            while(rs.next())
                {
                     price = rs.getInt(1);
                     userid = rs.getInt(2);
                     productid = rs.getInt(3);
                     quantity = rs.getInt(4);
                     ps = c.prepareStatement("INSERT into history VALUES(null,?,null,?,?,?)");//remove history id
                     ps.setInt(1,userid);
                     ps.setInt(2,productid);
                     ps.setInt(3, price);
                     ps.setInt(4, quantity);
                     ps.executeUpdate();
                }
             ps = c.prepareStatement("delete from cart where u_id =?");
             ps.setInt(1,user_id);
             ps.executeUpdate();
    }
    
    public ArrayList getLatest9Products() throws SQLException
    {
        ArrayList Products = new ArrayList();
        HashMap<Integer,String> Category = new HashMap();
        Product product = new Product();
        ps = c.prepareStatement("select cat_id,cat_name from category");
        rs1 = ps.executeQuery();
        while(rs1.next())
        {
            Category.put(rs1.getInt(1),rs1.getString(2));
        }
        st = c.createStatement();
        rs = st.executeQuery("select * from product order by p_id Desc Limit 9");
        while(rs.next())
        {
            product.setP_id(rs.getInt(1));
            product.setP_name(rs.getString(2));
            product.setP_desc(rs.getString(3));
            product.setP_image(rs.getString(4));
            product.setQuantity(rs.getInt(5));
            product.setSold(rs.getInt(6));
            product.setPrice(rs.getInt(7));
            product.setCat_id(rs.getInt(8));
            product.setCat_name(Category.get(rs.getInt(8)));
            Products.add(product);
        }
         return(Products);    
    }
    
    public ArrayList<Category> getCat2Pro() throws SQLException
    {
        ArrayList<Category> Categories = new ArrayList();
        Category cat = new Category();
        ps = c.prepareStatement("select cat_name,cat_id from category");
        rs1 = ps.executeQuery();
        ps = c.prepareStatement("select count(*)from product where cat_id = ?");
        ps.setInt(1,rs1.getInt(2));
        rs = ps.executeQuery();
        while(rs.next())
        {
            cat.setName(rs.getString(1));
            cat.setNoProducts(rs.getInt(2));
            Categories.add(cat);
        }
        return(Categories);
    }
    
    public void enterVoucher(int user_id,long number)
    {
        try {
            ps = c.prepareStatement("select serial,value from voucher where serial = ?");
            ps.setLong(1,number);
            rs = ps.executeQuery();
            if(rs.next())
            {
               ps = c.prepareStatement("delete from voucher where serial =?");
               ps.setLong(1, number);
               ps = c.prepareStatement("select credit from user where u_id =?");
               ps.setInt(1, user_id);
               rs1 = ps.executeQuery();
               ps = c.prepareStatement("update user set credit =?  where u_id =?");
               int credit = rs.getInt(2)+rs1.getInt(1);
               ps.setInt(1, credit);
               ps.setInt(2, user_id);
               ps.executeUpdate();
            }
            else
            {
                //3and 5altak
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Voucher> getVouchers(int Value)
    {
        try {
            ArrayList<Voucher> vouchers = new ArrayList<Voucher>();
            Voucher unit = new Voucher();
            ps = c.prepareStatement("select serial from voucher where value =?");
            ps.setInt(1, Value);
            rs = ps.executeQuery();
            while(rs.next())
                {
                unit.setNumber(rs.getInt(1));
                unit.setValue(Value);
                vouchers.add(unit);
                }
        return (vouchers);     
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return null;
    }
    
    public ArrayList<Product> search(String key,String category) throws SQLException
    {
             int cat_id=0;
            ArrayList<Product> Products= new ArrayList();
            if(category.equals("All"))
            {
                HashMap<Integer,String> Category = new HashMap();
                ps = c.prepareStatement("select cat_id,cat_name from category");
                rs1 = ps.executeQuery();
                while(rs1.next())
                {
                    Category.put(rs1.getInt(1),rs1.getString(2));
                }
                ps = c.prepareStatement("select * from product");
                rs = ps.executeQuery();
                while(rs.next())
                    {
                    Product product = new Product();    
                    product.setP_id(rs.getInt(1));
                    product.setP_name(rs.getString(2));
                    product.setP_desc(rs.getString(3));
                    product.setP_image(rs.getString(4));
                    product.setQuantity(rs.getInt(5));
                    product.setSold(rs.getInt(6));
                    product.setPrice(rs.getInt(7));
                    product.setCat_id(rs.getInt(8));
                    product.setCat_name(Category.get(rs.getInt(8)));
                    Products.add(product);
                    }
                    return(Products);
            }
            else
            {
                ps = c.prepareStatement("select cat_id from category where cat_name=?");
                ps.setString(1, category);
                rs1 = ps.executeQuery();
                if(rs1.next())
                    cat_id = rs1.getInt(1);
                ps = c.prepareStatement("select * from product where cat_id =?");
                ps.setInt(1,cat_id);            
                rs = ps.executeQuery();
                while(rs.next())
                    {
                    Product product = new Product();    
                    product.setP_id(rs.getInt(1));
                    product.setP_name(rs.getString(2));
                    product.setP_desc(rs.getString(3));
                    product.setP_image(rs.getString(4));
                    product.setQuantity(rs.getInt(5));
                    product.setSold(rs.getInt(6));
                    product.setPrice(rs.getInt(7));
                    product.setCat_id(rs.getInt(8));
                    product.setCat_name(category);
                    Products.add(product);
                    }
                    return(Products);
            }
    }
    
}
