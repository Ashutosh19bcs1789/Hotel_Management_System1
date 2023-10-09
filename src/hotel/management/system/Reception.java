/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton jbnewcustomer,jbdepartment,jbcheckout, jballemployee,jbroomstatus,jbLogout,jbserchrooms,jbmanagerInfo,jbPickup,jbcustomerInfo,jbUpdate;
    JButton jbrooms;
    Reception(){
        super("Reception");
        setLayout(null);
        getContentPane().setBackground(new Color(240,231,247));
        
        jbnewcustomer=new JButton("New Customer Form");
        jbnewcustomer.setBounds(60,25,160,25);
        jbnewcustomer.setBackground(new Color(249,255,205));
        jbnewcustomer.setForeground(Color.BLACK);
        jbnewcustomer.addActionListener(this);
        add(jbnewcustomer);
        
        jbrooms=new JButton("Rooms");
        jbrooms.setBounds(60,65,160,25);
        jbrooms.setBackground(new Color(249,255,205));
        jbrooms.addActionListener(this);

        jbrooms.setForeground(Color.BLACK);
        add(jbrooms);
        
        
        jbdepartment=new JButton("Department");
       jbdepartment.setBounds(60,105,160,25);
        jbdepartment.setBackground(new Color(249,255,205));
        jbdepartment.setForeground(Color.BLACK);
        jbdepartment.addActionListener(this);
        add(jbdepartment);
        
       jballemployee=new JButton("All Employees");
       jballemployee.setBounds(60,145,160,25);
        jballemployee.setBackground(new Color(249,255,205));
        jballemployee.setForeground(Color.BLACK);
        jballemployee.addActionListener(this);

        add(jballemployee);
        
        
        jbcustomerInfo=new JButton("Customer Info.");
        jbcustomerInfo.setBounds(60,185,160,25);
        jbcustomerInfo.setBackground(new Color(249,255,205));
        jbcustomerInfo.setForeground(Color.BLACK);       
        jbcustomerInfo.addActionListener(this);
        add(jbcustomerInfo);
        
        jbmanagerInfo=new JButton("Manager Info.");
        jbmanagerInfo.setBounds(60,225,160,25);
        jbmanagerInfo.setBackground(new Color(249,255,205));
        jbmanagerInfo.setForeground(Color.BLACK);
        jbmanagerInfo.addActionListener(this);
        add(jbmanagerInfo);
        
        
        jbcheckout=new JButton("Checkout");
        jbcheckout.setBounds(60,265,160,25);
        jbcheckout.setBackground(new Color(249,255,205));
        jbcheckout.setForeground(Color.BLACK);
        jbcheckout.addActionListener(this);
        add(jbcheckout);
        
       jbUpdate=new JButton("Update  Status");
       jbUpdate.setBounds(60,305,160,25);
       jbUpdate.setBackground(new Color(249,255,205));
       jbUpdate.setForeground(Color.BLACK);
       jbUpdate.addActionListener(this);
        add(jbUpdate);
        
        jbroomstatus=new JButton("Update Room Status");
        jbroomstatus.setBounds(60,345,160,25);
        jbroomstatus.setBackground(new Color(249,255,205));
        jbroomstatus.setForeground(Color.BLACK);
        jbroomstatus.addActionListener(this);
        add(jbroomstatus);
         
        jbPickup =new JButton("Pickup Services");
        jbPickup.setBounds(60,385,160,25);
        jbPickup.setBackground(new Color(249,255,205));
        jbPickup.setForeground(Color.BLACK);
        jbPickup.addActionListener(this);
        add(jbPickup);
        
        jbserchrooms=new JButton("Search Rooms");
        jbserchrooms.setBounds(60,425,160,25);
        jbserchrooms.setBackground(new Color(249,255,205));
        jbserchrooms.setForeground(Color.BLACK);
        jbserchrooms.addActionListener(this);
        add(jbserchrooms);    
        
        jbLogout=new JButton("Logout");
        jbLogout.setBounds(60,465,160,25);
        jbLogout.setBackground(new Color(249,255,205));
        jbLogout.setForeground(Color.BLACK);
        jbLogout.addActionListener(this);
        add(jbLogout);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 465, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(255,25,500,465);
        add(image);
      
        setBounds(240,110,800,560);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jbnewcustomer){
        setVisible(false);
        new Addcustomerform();
    }
        else if(ae.getSource()==jbrooms){
            setVisible(false);
            new room();
        }
        else if(ae.getSource()==jbdepartment){
            setVisible(false);
            new department();
        }
        else if(ae.getSource()==jballemployee){
            setVisible(false);
            new allemployee();
        }
        else if(ae.getSource()==jbmanagerInfo){
            setVisible(false);
            new managerinfo();
        }
        else if(ae.getSource()==jbcustomerInfo){
            setVisible(false);
            new customerinfo();
        }
        else if(ae.getSource()==jbserchrooms){
            setVisible(false);
            new Searchforroom();
        }
         else if(ae.getSource()==jbUpdate){
            setVisible(false);
            new updatecheck();
        }else if(ae.getSource()==jbroomstatus){
            setVisible(false);
            new updateroomstatus();
        }else if(ae.getSource()==jbPickup){
            setVisible(false);
            new pickup();
        }else if(ae.getSource()==jbcheckout){
            setVisible(false);
            new checkout();
        }else if(ae.getSource()==jbLogout){
            setVisible(false);
            new Dashboard();
    }}
public static void main(String[] args){
    new Reception();
}    
}
