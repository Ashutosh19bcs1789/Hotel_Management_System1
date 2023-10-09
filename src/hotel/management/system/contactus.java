/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class contactus extends JFrame implements ActionListener{
    JButton submit,back;
    JTextField tffirst,tflast,tfemail,tfdesc;
    contactus(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel header=new JLabel("Contact Us");
        header.setBounds(275,25,200,40);
        header.setFont(new Font("cursive",Font.BOLD,25));
        add(header);
        
        
        JLabel name=new JLabel("Name");
        name.setBounds(30,70,80,30);
        name.setFont(new Font("cursive",Font.BOLD,13));
        add(name);
        
        tffirst=new JTextField();
        tffirst.setBounds(30,100,140,25);
        add(tffirst);
        
        tflast=new JTextField();
        tflast.setBounds(180,100,140,25);
        add(tflast);
        
        
        JLabel first=new JLabel("First");
        first.setBounds(30,115,80,30);
        first.setFont(new Font("railway",Font.PLAIN,11));
        add(first);
        
        JLabel last=new JLabel("Last");
        last.setBounds(180,115,80,30);
        last.setFont(new Font("railway",Font.PLAIN,11));
        add(last);
        
        JLabel email=new JLabel("Email");
        email.setBounds(30,145,80,30);
        email.setFont(new Font("cursive",Font.BOLD,13));
        add(email);
        
        tfemail=new JTextField();
        tfemail.setBounds(30,175,290,25);
        add(tfemail);
        
        
        JLabel emailabel=new JLabel("Please provide us a valid email address.");
        emailabel.setBounds(30,190,380,30);
        emailabel.setFont(new Font("railway",Font.PLAIN,11));
        add(emailabel);
        
        JLabel desc=new JLabel("Your Inquiry");
        desc.setBounds(30,220,80,30);
        desc.setFont(new Font("cursive",Font.BOLD,13));
        add(desc);
        
        tfdesc=new JTextField();
        tfdesc.setBounds(30,250,620,35);
        add(tfdesc);
        
        JLabel desclabel=new JLabel("Please, provide your inquiry or feedback.");
        desclabel.setBounds(30,275,380,30);
        desclabel.setFont(new Font("railway",Font.PLAIN,11));
        add(desclabel);
        
        submit=new JButton("Submit");
        submit.setBounds(255,330,80,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("Back");
        back.setBounds(365,330,80,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setBounds(280,150,700,450);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){ 
        
        if(ae.getSource()==submit){
        String firstname=tffirst.getText();
        String lastname=tflast.getText();
        String email=tfemail.getText();
        String inquiry=tfdesc.getText();
            
        try{
            conn c=new conn();
            c.s.executeUpdate("Insert into contactus values('"+firstname+"','"+lastname+"','"+email+"','"+inquiry+"')");
            JOptionPane.showMessageDialog(null,"Successfully Submitted");
            setVisible(false);
            new Dashboard();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        }else{try{
            setVisible(false);
            new Dashboard();
            
        }catch(Exception e){
            e.printStackTrace();
        }
                }
    }
    public static void main(String[] args){
        new contactus();
        
    }
}
