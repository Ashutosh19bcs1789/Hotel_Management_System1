/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.sql.*;

public class conn {
    Connection c;  
    Statement s;
    conn(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","140600"); 
            s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
}
