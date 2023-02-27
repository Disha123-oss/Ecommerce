/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import java.sql.*;
import javafx.collections.FXCollections;

/**
 *
 * @author acer
 */
public class Product {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;
    
    public int getId(){
        return id.get();
    }
    public String getName(){
        return name.get();
    }
    public double getPrice(){
        return price.get();
    }
    
    Product(int id, String name, double price){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }
    
    public static ObservableList<Product> getAllProducts(){
        String allProductList = "select * from products";
        return getProducts(allProductList);
    }
    public static ObservableList<Product> getProducts(String query){
        databaseConn db = new databaseConn();
        ResultSet rs = db.getQueryTable(query);
        ObservableList<Product> result = FXCollections.observableArrayList();
        try{
            if(rs!=null){
                while(rs.next()){
                    result.add(new Product(
                            rs.getInt("pid"),
                            rs.getString("name"),
                            rs.getDouble("price")
                    ));
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
}
