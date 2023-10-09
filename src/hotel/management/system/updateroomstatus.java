/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updateroomstatus extends JFrame implements ActionListener{

Choice ccustomer;
    JTextField tfpending,tfroom,tfavailable,tfstatus, tfpaid;
    JButton check,update,back;
updateroomstatus(){
    
        getContentPane().setBackground(new Color(242,219,212));
        setLayout(null);
        
        JLabel text=new JLabel("Update Room Status");
        text.setBounds(90,25,200,30);
        text.setFont(new Font(" Monospaced",Font.BOLD,18));
        add(text);
        
        JLabel jlid=new JLabel("Customer Id");
        jlid.setBounds(30, 80, 100, 30);
        add(jlid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(145,85,170,25);
        ccustomer.setForeground(Color.BLACK);
        ccustomer.setBackground(new Color(165,247,187));
        add(ccustomer);
        
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addcustomer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JLabel jlroom=new JLabel("Room number");
        jlroom.setBounds(30, 120, 100, 30);
        add(jlroom);
        
        tfroom=new JTextField();
        tfroom.setBounds(145,125,170,25);
        tfroom.setBackground(new Color(165,247,187));
        add(tfroom);
        
        
        
        JLabel jlavailable=new JLabel("Availability");
        jlavailable.setBounds(30, 160, 100, 30);
        add(jlavailable);
        
        tfavailable=new JTextField();
        tfavailable.setBounds(145,165,170,25);
        tfavailable.setBackground(new Color(165,247,187));
        add(tfavailable);
        
        
        JLabel jlstatus=new JLabel("Cleaning Status");
        jlstatus.setBounds(30, 200, 100, 30);
        add(jlstatus);
        
        tfstatus=new JTextField();
        tfstatus.setBounds(145,205,170,25);
        tfstatus.setBackground(new Color(165,247,187));
        add(tfstatus);
        
        
      
        JLabel lbupdate=new JLabel("TO UPDATE ROOM STATUS PLEASE CLICK ON 'Update' ");
        lbupdate.setBounds(15,295,  580, 30);
        lbupdate.setForeground(Color.BLUE);
        lbupdate.setFont(new Font("Monospaced",Font.BOLD,12));
        add(lbupdate);
        
        JLabel lbcheckout=new JLabel("TO CHECK DETAILS OF ROOM PLEASE CLICK ON 'check' ");
        lbcheckout.setBounds(15,320,  580, 30);
        lbcheckout.setForeground(Color.BLUE);
        lbcheckout.setFont(new Font("Monospaced",Font.BOLD,12));
        add(lbcheckout);
        
        check =new JButton("Check");
        check.setBounds(0, 360, 266, 28);
        check.setForeground(Color.BLACK);
        check.setBackground(new Color(249,255,205));
        check.addActionListener(this);
        add(check);
      
        
        update =new JButton("Update");
        update.setBounds(266, 360, 266, 28);
        update.setForeground(Color.BLACK);
        update.setBackground(new Color(249,255,205));
        update.addActionListener(this);
        add(update);
        
        
        back =new JButton("Back");
        back.setBounds(532, 360, 266, 28);
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(249,255,205));
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 350, Image.SCALE_DEFAULT);
        
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(360,60,430,275);
        add(image);
        
        
        
        setBounds(300,150,800,450);
        setVisible(true);
}   

public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==check){
       
        String id=ccustomer.getSelectedItem();
        String str="Select * from addcustomer where Number='"+id+"'";
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                tfroom.setText(rs.getString(("room")));
            }
        ResultSet rs2=c.s.executeQuery("Select * from addroom where Room_Number='"+tfroom.getText()+"'");
        while(rs2.next()){
            tfavailable.setText(rs2.getString("Availability"));
            tfstatus.setText(rs2.getString("Cleaning_Status"));
        }
        }   catch(Exception e){
            e.printStackTrace();
            
        }} else if(ae.getSource()==update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String available=tfavailable.getText();
            String status=tfstatus.getText();
            try{
                conn c=new conn();
               c.s.executeUpdate("update addroom set Availability='"+available+"', Cleaning_Status='"+status+"' where Room_Number='"+room+"'");
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
            setVisible(false);
            new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }
public static void main(String[] args){
    new updateroomstatus();
}
}
