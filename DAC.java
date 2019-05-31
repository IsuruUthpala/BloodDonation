/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Isuru
 */
public class DAC {
    Connection con ;
    public Connection getConnection(){
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/blood";
    String username="root";
    String password="";
    try{
        Class.forName(driver);
        con=DriverManager.getConnection(url,username, password);
        
    
    }
    catch(Exception e){}
    
    return con;
    }
    
}
