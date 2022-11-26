/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Juan
 */
public class Conexion {
    Connection con;
    String URL = "jdbc:mysql://localhost:3306/dbecommerce"; 
    String user = "root";
    String pass = "";
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL,user,pass);
        } catch (Exception e){    
        }
        return con;
    }
}
