/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import dto.Product;
import dto.User;
import java.util.ArrayList;

/**
 *
 * @author Dina Ashraf
 */
public interface DataBaseHandlerInterface
{
    public boolean checkEmailExistance(String email);
    public boolean signup(User user);
    public User login(String email, String password);
    public ArrayList<Product> searchProducts(String category, String productName, double productPrice);
    public ArrayList<Product> getAllproducts();
    public boolean editUserDetials(User user);
    public double getUserBalance(String email);
    public boolean updateUserBalance(User user, double addedBalance);
    public boolean createOrder(String email, ArrayList<Product> products);
    //inside the class that implements that interface
    //private boolean addProductsToOrder(int orderID, ArrayList<Product> products);
    public boolean checkProductNameExistance(String productName);
    //we delete or update the order status which status == 0
    //in destruction of session event save shopping cart(order) if items!=0
    public boolean updateOrderStatus(String email, int status);
    public boolean DeleteOrder(String email);
    public Product getProduct(int productID);
    public ArrayList<Product> getDiscountedProducts();
    public boolean CheckCreditCardNumberExistance(int number);
}
