/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class updatecheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField tfpending,tfroom,tfname,tfcheckin, tfpaid;
    JButton check,update,back;
    updatecheck(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("Update Status");
        text.setBounds(120,25,150,30);
        text.setFont(new Font(" railway",Font.BOLD,18));
        add(text);
        
        JLabel jlid=new JLabel("Customer Id");
        jlid.setBounds(30, 80, 100, 30);
        add(jlid);
        
        ccustomer=new Choice();
        ccustomer.setBounds(145,85,170,25);
        ccustomer.setForeground(Color.BLACK);
        ccustomer.setBackground(Color.WHITE);
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
        add(tfroom);
        
        
        
        JLabel jlname=new JLabel("Name");
        jlname.setBounds(30, 160, 100, 30);
        add(jlname);
        
        tfname=new JTextField();
        tfname.setBounds(145,165,170,25);
        add(tfname);
        
        
        JLabel jlcheckin=new JLabel("Check In Time");
        jlcheckin.setBounds(30, 200, 100, 30);
        add(jlcheckin);
        
        tfcheckin=new JTextField();
        tfcheckin.setBounds(145,205,170,25);
        add(tfcheckin);
        
        
        JLabel jlPaid=new JLabel("Amount Paid");
        jlPaid.setBounds(30, 240, 100, 30);
        add(jlPaid);
        
        tfpaid=new JTextField();
        tfpaid.setBounds(145,245,170,25);
        add(tfpaid);
        
        JLabel jlPending=new JLabel("Pending Amount");
        jlPending.setBounds(30, 280, 100, 30);
        add(jlPending);
        
        tfpending=new JTextField();
        tfpending.setBounds(145,285,170,25);
        add(tfpending);
        
        
        check =new JButton("Check");
        check.setBounds(30, 400, 80, 25);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.addActionListener(this);
        add(check);
      
        
        update =new JButton("Update");
        update.setBounds(130, 400, 80, 25);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);
        
        
        back =new JButton("Back");
        back.setBounds(230, 400, 80, 25);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/nine.jpg"));
        Image i2=i1.getImage().getScaledInstance(300, 225, Image.SCALE_DEFAULT);
        
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,50,300,275);
        add(image);
        
        
        
        setBounds(300,150,700,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            try{
                conn c=new conn();
                String id=ccustomer.getSelectedItem();
                String str="Select * from addcustomer where Number='"+id+"'";
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                    tfroom.setText(rs.getString("Room"));
                    tfname.setText(rs.getString("Name"));
                    tfcheckin.setText(rs.getString("Check_In_Time"));
                    tfpaid.setText(rs.getString("Deposit"));
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
//naya ek ur query chalay g available ur status k k ly
              try{
                 conn c=new conn();
                ResultSet rs2=c.s.executeQuery("Select * from addroom where Room_Number='"+tfroom.getText()+"'");
              
                while(rs2.next()){
               String price=rs2.getString("price");
               int amountpaid=Integer.parseInt(price)-Integer.parseInt(tfpaid.getText());
               tfpending.setText(""+amountpaid); //""ka matlb h ki hm int ko string me convert kr dy
                }}catch(Exception e){
                   e.printStackTrace();
                   }
        }else if(ae.getSource()==update){
            String number=ccustomer.getSelectedItem();
            String room=tfroom.getText();
            String name=tfname.getText();
            String checkin=tfcheckin.getText();
            String deposit=tfpaid.getText();
            try{
                conn c=new conn();
               c.s.executeUpdate("update addcustomer set Room='"+room+"', Name='"+name+"',Check_In_Time='"+checkin+"',Deposit='"+deposit+"'where Number='"+number+"'");
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
        new updatecheck();
    }
}
