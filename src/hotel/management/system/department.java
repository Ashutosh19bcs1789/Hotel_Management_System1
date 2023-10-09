/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


 
public class department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    department(){
        super("Department");
        getContentPane().setBackground(new Color(240,231,247));
//        setLayout(null);
        
        
       
        
        
        
        table=new JTable();
        table.setBounds(0,60,500,300);
        
        try{
            conn c=new conn();
            String query="Select * from adddepartment";
            ResultSet rs=c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(table);
        add(sp);
        
        
        
        
        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("cursive",Font.BOLD,14));
        back.addActionListener(this);
        add(back,"South");
        
        
        setBounds(400,125,500,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new department();
    }
}
