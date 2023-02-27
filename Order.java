/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;

/**
 *
 * @author acer
 */
public class Order {
    public static boolean placeOrder(Customer customer, Product product){
        try{
            String placeOrder = "insert into orders(customer_id, product_id, status) values(" + customer.getId() + "," + product.getId() + ",'Ordered')";
            databaseConn dbconn = new databaseConn();
            return dbconn.insertUpdate(placeOrder);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
