/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author acer
 */
public class databaseConn {
    String dburl = "jdbc:mysql://localhost:3306/ecomm";
    String userName = "root";
    String password = "root123";
    
    private Statement getStatement(){
        
        Connection conn;
        try {
            conn = DriverManager.getConnection(dburl,userName,password);
            return conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(databaseConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ResultSet getQueryTable(String query){
        Statement stmt = getStatement();
        ResultSet rs;
        try {
            rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(databaseConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insertUpdate(String query){
        Statement stmt = getStatement();
        ResultSet rs;
        try {
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(databaseConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static void main(String args[]){
        databaseConn dbconn = new databaseConn(); 
        ResultSet rs = dbconn.getQueryTable("select * from products");
        if(rs!=null){
            System.out.print("Database is connected!");
        }
    }
           
}
