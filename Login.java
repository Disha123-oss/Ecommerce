/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecommerce;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;

/**
 *
 * @author acer
 */
public class Login {
    private static byte[] getSha(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(input.getBytes(StandardCharsets.UTF_8));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static String getEncryptedPassword(String password){
        try{
            BigInteger num = new BigInteger(1,getSha(password));
            StringBuilder hexString = new StringBuilder(num.toString(16));
            return hexString.toString();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public static Customer customerLogin(String userEmail, String password){
        String query = "select * from customer where email = '"+userEmail+"' and password = '"+password+"' ";
        databaseConn dbconn = new databaseConn();
        try{
            ResultSet rs = dbconn.getQueryTable(query);
            if(rs!=null && rs.next()){
                return new Customer(
                        rs.getInt("cid"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        System.out.println(customerLogin("swagatadutta424@gmail.com","swag123"));
        System.out.println(getEncryptedPassword("swag123"));
    }
}
