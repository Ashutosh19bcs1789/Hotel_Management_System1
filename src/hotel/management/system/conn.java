/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.sql.*;

public class conn {
    //here we made jdbc conncetivity so it has five steps:-
    //STEP 1)register the driver
    //it shows error because jab hum jdbc conn krte h tbhi ek mysql jar file ki need hoti h to hm usko liberrary m add krway
    //use bd ye mysql jo h wo ek external entitity h to expection ane k bhut jada chance h
    // is ly class.forName- ye class hoti h java m ur usko hm try catch me dalte h to exception hat jay g
    
    
    //STEP 2) creating a connection java.sql package me hota h usko import krwa lo
    //uske bd connection string banana padta h { c=DriverManager.getConnection("");}
   //step3) creating statemnt
    //step4)executing mysql queries isko execute krne k ly database bana pdega g uske andr table banani pdegi
    Connection c;  //ye jo h connection package 
    Statement s;
    conn(){
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             c=DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","140600"); //divermanager ka obj ur get conn ek fun h jo url h wo conn string kahlata h jo mysql ki url hoti h
            //localhost is our local host and 3306 is our port number.
            s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
}
