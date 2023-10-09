/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author ashut
 */
public class Login extends JFrame implements ActionListener{
   //q ki ye text field constrcutor k andr locally defined h to usko globlay krna pdega
    JTextField usertext;
    JPasswordField passtext;
    JButton login,cancel;
    Login(){
        super("Login");
        // getcontentpane means we should pick the frame using this.
        getContentPane().setBackground(Color.WHITE);
         setLayout(null); //we make our own layout so we sholud set label as null
       
        
        JLabel user =new JLabel("Username");
        user.setBounds(35,30,100,30);
        add(user);
        
        //in java if user enter in any text field like in html then we use predefined class JTextField heere
         usertext=new JTextField(); 
        usertext.setBounds(110,30,160,27);
        add(usertext);
        
        JLabel password =new JLabel("Password");
        password.setBounds(35,70,100,30);
        add(password);
        
        passtext=new JPasswordField(); 
        passtext.setBounds(110,70,160,27);
        add(passtext);
        
        login=new JButton("Login");
        login.setBounds(30, 120, 110, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(160, 120, 110, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        //to scale or to crop image we use this.
        Image i2=i1.getImage().getScaledInstance(190, 200, Image.SCALE_DEFAULT);
        //here we make another obj i2 and call i1 through fxn called get scaled...
        // but we cant directly call i2 in jlabel so we need to covert back it into icon form
        //imageicon is a class in java that is used to set image on layout
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(315,20,100,140);
        add(image);
        
        
       setBounds(400,250,475,225);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
    //yaha p is fxn k andr dono text feild psswd ur user name niklna h ur database k sth match krwana h
    if(ae.getSource()==login){
        //here with this value we need to hit  in database mtlb hm chck kreg ki ye credential database m hai ya nh
    //to ye extrnl chiz h database me to excseption bh aye g   
    try{
        conn c=new conn();
        String user1=usertext.getText();
        String pass1=passtext.getText();
        String query="select * from login where username='"+user1+"' and password='"+pass1+"'";//yaha [r user ur pass variable h
        ResultSet rs=c.s.executeQuery(query); //conn class k obj c ke sth s ko chalaya
        if (rs.next()){  //next function ss chck kr rh h data value mila hai ya nhi
            setVisible(false);
            new Dashboard();
        }else{
            JOptionPane.showMessageDialog(null,"Invalid username and password");
            setVisible(false);
            new Login();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    }else if(ae.getSource()==cancel){
        setVisible(false);
    }
    }
    public static void main(String[] args){
        new Login();
    }
    }
