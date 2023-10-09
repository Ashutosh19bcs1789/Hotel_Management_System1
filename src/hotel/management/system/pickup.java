/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class pickup extends JFrame implements ActionListener{
    Choice choice;
    JTable table;
    JButton check,back,book;
    pickup(){
        super("Pickup Service");
        setLayout(null);
        getContentPane().setBackground(new Color(242,219,212));
        
        JLabel header=new JLabel("Pick Up Servcie");
        header.setFont(new Font("Monospaced",Font.BOLD,18));
        header.setBounds(310,5,200,35);
        add(header);
        
         
         
        JLabel jltypeofcar=new JLabel("Type Of Car:");
        jltypeofcar.setBounds(35,45,80,30);;
        add(jltypeofcar);
         
        choice =new Choice();
        choice.setBounds(125,50,160,28);
        choice.setFont(new Font("Cursive",Font.BOLD,12));
        choice.setBackground(new Color(249,255,205));
        add(choice);
       
        
       
        try{
        conn c=new conn();
        ResultSet rs=c.s.executeQuery("Select * from adddriver");
        while(rs.next()){
        choice.add(rs.getString("Car_Model"));
        }          
        }catch(Exception e){
            e.printStackTrace();
        }
      
        table=new JTable();
        add(table);
      
        JCheckBox cbavailability=new JCheckBox("Show Only Available cars");
        cbavailability.setBounds(550,45,180,28);
        cbavailability.setBackground(new Color(242,219,212));
        add(cbavailability);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select *from adddriver ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
      
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,95,790,270);
        add(sp);
        
        
        book =new JButton("Book car");
        book.setBounds(266,375,266,28);
        book.setForeground(Color.BLACK);
        book.setBackground(new Color(165,247,187));
        book.addActionListener(this);
        add(book);
        
        
        check =new JButton("Check");
        check.setBounds(0,375,266,28);
        check.setForeground(Color.BLACK);
        check.setBackground(new Color(165,247,187));
        check.addActionListener(this);
        add(check);
        
        
        back =new JButton("Back");
        back.setBounds(532,375,266,28);
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(165,247,187));
        back.addActionListener(this);
        add(back);
        
        
        
      setBounds(245,145,800,450);
      setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            try{
              conn c=new conn();
              String str="select * from adddriver where Car_Model='"+choice.getSelectedItem()+"' and Availability='Available'";          
              ResultSet rs=c.s.executeQuery(str);
              table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==book){
            setVisible(false);
            new bookcar();
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new pickup();
        
    }
}
