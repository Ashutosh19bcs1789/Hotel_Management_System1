/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class practise extends JFrame {
    practise(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
       
        
        
        JLabel header=new JLabel("Ashutosh kumar");
        header.setForeground(Color.red);
        header.setFont(new Font("railway",Font.BOLD,20));
        header.setBounds(50,30,200,30);
        add(header);
        setBounds(200,150,600,500);
        setVisible(true);
        
      
        Choice c=new Choice();
        c.setBounds(30,200,100,30);
        add(c);
        
        try{
            conn conn=new conn();
            ResultSet rs=conn.s.executeQuery("select * from addroom ");
            while(rs.next()){
                c.add(rs.getString("roomnumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        while(true){
            try{
                header.setVisible(false);
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                header.setVisible(true);
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    public static void main(String[] args){
        new practise();
    }
}
