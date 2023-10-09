
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class checkout extends JFrame implements ActionListener{
    Choice ccustomer;
    JLabel jlcheckin,jlRoomnumber,jlcheckout,jlname1;
    JButton back,checkout;
    checkout(){
        setLayout(null);
        getContentPane().setBackground(new Color(242,219,212));
        
         JLabel header=new JLabel("Checkout");
         header.setFont(new Font("Monospaced",Font.BOLD,18));
         header.setBounds(300,15,150,35);
         add(header);
        
        
         JLabel jlid=new JLabel("Customer Id");
         jlid.setBounds(30,50,100,30);
         add(jlid);
         
         ccustomer=new Choice();
         ccustomer.setBounds(150,55,160,25);
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
         

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
         Image i2=i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT );
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(320,57,17,17);
         add(image);


         JLabel jlRoom=new JLabel("Room Number");
         jlRoom.setBounds(30,80,100,30);
         add(jlRoom);
         
         jlRoomnumber=new JLabel("");
         jlRoomnumber.setBounds(150,80,100,25);
         jlRoomnumber.setFont(new Font("tohima",Font.PLAIN,12));
         add(jlRoomnumber);
         
         
         JLabel jlname=new JLabel("Name");
         jlname.setBounds(30,110,100,30);
         add(jlname);
         
         jlname1=new JLabel("");
         jlname1.setBounds(150,110,100,25);
         jlname1.setFont(new Font("tohima",Font.PLAIN,12));
         add(jlname1);
         
         
         JLabel jlcheckintime=new JLabel("Check In Time");
         jlcheckintime.setBounds(30,140,100,30);
         add(jlcheckintime);
         
         
         jlcheckin=new JLabel("");
         jlcheckin.setBounds(150,140,200,25);
         jlcheckin.setFont(new Font("tohima",Font.PLAIN,12));

         add(jlcheckin);
         
         try{
                     conn c=new conn();
                     ResultSet rs=c.s.executeQuery("Select * from addcustomer where Number='"+ccustomer.getSelectedItem()+"'");
                     while(rs.next()){
                        jlRoomnumber.setText(rs.getString("Room"));
                        jlname1.setText(rs.getString("Name"));
                        jlcheckin.setText(rs.getString("Check_In_Time"));
                    }
                     }catch(Exception e){
                         e.printStackTrace();
                     }
    
    
          ccustomer.addItemListener(new ItemListener(){
             public void itemStateChanged(ItemEvent ie){
                 try{
                     conn c=new conn();
                     ResultSet rs=c.s.executeQuery("Select * from addcustomer where Number='"+ccustomer.getSelectedItem()+"'");
                     while(rs.next()){
                        jlRoomnumber.setText(rs.getString("Room"));
                        jlname1.setText(rs.getString("Name"));
                        jlcheckin.setText(rs.getString("Check_In_Time"));
                    }
                     }catch(Exception e){
                         e.printStackTrace();
                     }}
         });
         
   
         JLabel jlcheckouttime=new JLabel("Check Out Time");
         jlcheckouttime.setBounds(30,170,100,30);
         add(jlcheckouttime);
         
         
         Date date=new Date();
         jlcheckout=new JLabel(""+ date);
         jlcheckout.setFont(new Font("tohima",Font.PLAIN,12));
         jlcheckout.setBounds(150,175,200,25);
         add(jlcheckout);
         
        JLabel lbcheckout=new JLabel("FOR CHECKOUT PLEASE CLICK ON 'Checkout' ");
        lbcheckout.setBounds(50,265,  580, 30);
        lbcheckout.setForeground(Color.BLUE);
        lbcheckout.setFont(new Font("Monospaced",Font.BOLD,12));
        add(lbcheckout);
         
        checkout =new JButton("Checkout");
        checkout.setBounds(60, 300, 100, 25);
        checkout.setForeground(Color.BLACK);
        checkout.setBackground(new Color(165,247,187));
        checkout.addActionListener(this);
        add(checkout);
        
        
        back =new JButton("Back");
        back.setBounds(200, 300, 100, 25);
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(165,247,187));
        back.addActionListener(this);
        add(back);
              
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
         Image i5=i4.getImage().getScaledInstance(280, 250,Image.SCALE_DEFAULT );
         ImageIcon i6=new ImageIcon(i5);
         JLabel image1=new JLabel(i6);
         image1.setBounds(330,60,350,250);
         add(image1);
         
        
        setBounds(300,195,700,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==checkout){
            String query1="Delete from addcustomer where Number='"+ccustomer.getSelectedItem()+"'";
            String query2="Update addroom set Availability='Available' where Room_Number='"+jlRoomnumber.getText()+"'";
           try{
               conn c=new conn();
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null, "Checkout Successfully");
               setVisible(false);
               new Reception();
           } catch(Exception e){
               e.printStackTrace();
           }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new checkout();
    }
}
