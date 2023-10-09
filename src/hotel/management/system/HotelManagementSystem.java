/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
    setSize(1200,580);
    setLocation(40,40);
    setLayout(null);
    
   ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
   Image i2=i1.getImage().getScaledInstance(1210, 590, Image.SCALE_DEFAULT);
   ImageIcon i3=new ImageIcon(i2);
    JLabel image= new JLabel(i3);
    image.setBounds(0,0,1200,580); 
    add(image);
    
    JLabel text= new JLabel("HOTEL MANAGEMENT SYSTEM");
    text.setBounds(20,430,1000,90); 
    text.setForeground(new Color(239,255,0)); 
    text.setFont(new Font("serif",Font.PLAIN,28));
    image.add(text);
    
    
    JButton next = new JButton("Next");
    next.setBounds(1020, 460, 90, 35);
    next.setBackground(new Color(239,255,0));
    next.setForeground(Color.BLACK);
    next.addActionListener(this);
    next.setFont(new Font("serif",Font.BOLD,19));
    image.add(next);
    
     setVisible(true);
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
    public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new Login(); 
    }
    public static void main(String[] args) {
      new HotelManagementSystem();
    }
    
}
