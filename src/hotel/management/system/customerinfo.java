/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;

public class customerinfo extends JFrame implements ActionListener {
    JTable table;
    JButton back,print;
    customerinfo(){
        super("Customer`s Detail");
        setLayout(null);
        getContentPane().setBackground(new Color(240,231,247));
        setExtendedState(MAXIMIZED_BOTH);
        
           
      
        table =new JTable();
        try{
            conn c=new conn();
            String str="Select * from addcustomer ";
            ResultSet rs=c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,0,1300,600);
        add(sp);
        
        
        print =new JButton("Print");
        print.setBounds(0,610,638,30);
        print.setForeground(Color.BLACK);
        print.setBackground(new Color(249,255,205));
        print.addActionListener(this);
        add(print);
        
       
        back =new JButton("Back");
        back.setBounds(638,610,644,30);
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(249,255,205));
        back.addActionListener(this);
        add(back);
//        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }else{
            try {
                table.print();
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new customerinfo();
    }
}
