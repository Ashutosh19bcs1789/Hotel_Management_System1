/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class HotelManagementSystem extends JFrame implements ActionListener{
    //here we  need action event for clcicking purpose so we extends through implement ActionListener
    //this is an interface in java and also it come under java.awt.event packge so we need to import it.
    //and in this this is a concept of interface and in java everything that is interface-
    //when we add interface in any class then us class me jitne bh abstract method hai--
    //apko unko override krna hota h unko declare krna hota h isi cls me nh to cls ko abstract banaana pdta h
    //so add abstract clss hotelmangemtn k age
    
    
    HotelManagementSystem(){
    setSize(1200,580);
    setLocation(40,40); //location wrt screen
    setLayout(null);
    
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
   Image i2=i1.getImage().getScaledInstance(1210, 590, Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
    JLabel image= new JLabel(i3);
    // making our own layout for adding text nd all
    // by using set bound 
    // any thign like image cls text any one if we set setbound as eg in that then we should write image.setbound like that.
    image.setBounds(0,0,1200,580); // it take four arguemnt  x-axis, yaxis , width , hight.
    add(image);
    
    // main use of jlabel to to write upon the frame 
    JLabel text= new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(20,430,1000,90); ///jitna me hotel management system lkh ahua h n usi ka layout ye set kre g kitna bada rhe g ur kitna chota rhe g 
    text.setForeground(new Color(239,255,0)); //color is a package which is in awt package so import it
// but our text is by default hidden behind frame to show it we use add() function
    text.setFont(new Font("serif",Font.PLAIN,28));
// set font ke andr new font class ka object banaana htoa h
//set font will take three argument 1) type of font 2)font type 3)font size 
    image.add(text);
    
    
    JButton next = new JButton("Next");
    next.setBounds(1020, 460, 90, 35);
    next.setBackground(new Color(239,255,0));
    next.setForeground(Color.BLACK);
    //we need to set action listner here so that to open next layout of login
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.BOLD,19));
    image.add(next);
    
  
     setVisible(true);
     
     //making dipper in hotel management system
    // actual funtionality is label is showing and hidng infinite time
             
     while(true){
         text.setVisible(false);
        try{
            Thread.sleep(750);
    }catch(Exception e){
        e.printStackTrace();
    }
        text.setVisible(true);
        try{
            Thread.sleep(750);
    }catch(Exception e){
        e.printStackTrace();
    }
     }
    }
    public void actionPerformed(ActionEvent ae){ //we override the above error or interface actionlistener.
    //this is a concept of method overloading
    
    //but k click hone pe krna ky h jse next pr hoga to yaha hm btay g
    setVisible(false); //current framne ko close kr dega ur next open ho jay 
    new Login(); //login class k obj banay login hote hi constr call hoga sari coding constructor m h wo open kr dega
    }
    public static void main(String[] args) {
      new HotelManagementSystem();
    }
    
}
