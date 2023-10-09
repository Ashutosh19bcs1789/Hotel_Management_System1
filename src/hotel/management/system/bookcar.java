/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class bookcar extends JFrame implements ActionListener {
    
    
    JButton submit,update,back;
    JTextField tfdistance,tfpick ,tfdrop;
    JLabel datte,tfdriver,customername;
    Choice choice,croomnumber;
    bookcar(){
        super("Rent a Car ");
        setLayout(null);
        getContentPane().setBackground(new Color(240,231,247));
        
        
        JLabel carmodel=new JLabel("Car Model");
        carmodel.setBounds(40,40,  100, 30);
        carmodel.setFont(new Font("cursive",Font.BOLD,12));
        add(carmodel);
        
        
        choice=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from adddriver where Availability='Available'");
            while(rs.next()){
                choice.add(rs.getString("Car_Model"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        choice.setBounds(150, 45, 150, 30);
        add(choice);
        
        
        JLabel Roomno=new JLabel("Customer`s Room_No.");
        Roomno.setBounds(340,40,  150, 30);
        Roomno.setFont(new Font("cursive",Font.BOLD,12));
        add(Roomno);
        
        croomnumber=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addcustomer ");
            while(rs.next()){
                croomnumber.add(rs.getString("Room"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        croomnumber.setBounds(510, 45, 150, 30);
        add(croomnumber);
        
        JLabel drivername=new JLabel("Driver Name");
        drivername.setBounds(40,115,  100, 30);
        drivername.setFont(new Font("cursive",Font.BOLD,12));
        add(drivername);
        
        
        tfdriver=new JLabel();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from adddriver where Car_Model='"+choice.getSelectedItem()+"'");
            while(rs.next()){
                            tfdriver.setText(rs.getString("Name"));
                            }
           }catch(Exception e){
                    e.printStackTrace();
           }
        tfdriver.setBounds(150,120,  150, 22);
        tfdriver.setFont(new Font("cursive",Font.PLAIN,12));
        add(tfdriver);
    
        choice.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("Select * from adddriver where Car_Model='"+choice.getSelectedItem()+"'");
                    while(rs.next()){
                        tfdriver.setText(rs.getString("Name"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        
        JLabel name=new JLabel("Name");
        name.setBounds(40,75,  100, 30);
        name.setFont(new Font("cursive",Font.BOLD,12));
        add(name);
        
        customername=new JLabel();  
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("Select * from addcustomer where Room='"+croomnumber.getSelectedItem()+"'");
            while(rs.next()){
                customername.setText(rs.getString("Name"));
                }
           }catch(Exception e){
                e.printStackTrace();
                }
        
        croomnumber.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("Select * from addcustomer where Room='"+croomnumber.getSelectedItem()+"'");
                    while(rs.next()){
                        customername.setText(rs.getString("Name"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
     
        customername.setBounds(150,75,  100, 30);
        customername.setFont(new Font("cursive",Font.PLAIN,12));
        add(customername);
        
        
        JLabel from=new JLabel("------- FROM -------");
        from.setBounds(320,140,  150, 30);
        from.setFont(new Font("cursive",Font.PLAIN,10));
        add(from);
        
        
        
        JLabel pickup=new JLabel("Pick-up Add.");
        pickup.setBounds(40,155,  100, 30);
        pickup.setFont(new Font("cursive",Font.BOLD,12));
        add(pickup);
        
        tfpick=new JTextField();
        tfpick.setBounds(150,160,  150, 22);
        add(tfpick);
        
        
        
        JLabel to=new JLabel("---------- TO ---------");
        to.setBounds(320,180,  150, 30);
        to.setFont(new Font("cursive",Font.PLAIN,10));
        add(to);
        
        
        JLabel drop=new JLabel("Drop Add.");
        drop.setBounds(40,195,  100, 30);
        drop.setFont(new Font("cursive",Font.BOLD,12));
        add(drop);
        
        tfdrop=new JTextField();
        tfdrop.setBounds(150,200,  150, 22);
        add(tfdrop);
        
        
        JLabel distance=new JLabel("Distance");
        distance.setBounds(40,235,  100, 30);
        distance.setFont(new Font("cursive",Font.BOLD,12));
        add(distance);
        
        tfdistance=new JTextField();
        tfdistance.setBounds(150,240,  150, 22);
        add(tfdistance);
        
        JLabel distance2=new JLabel("(in Km)");
        distance2.setBounds(315,237,  100, 30);
        distance2.setFont(new Font("cursive",Font.PLAIN,10));
        add(distance2);
        
        
        JLabel booktime=new JLabel("Booking Time");
        booktime.setBounds(40,275,  100, 30);
        booktime.setFont(new Font("cursive",Font.BOLD,12));
        add(booktime);
        
        
        Date db=new Date();
        datte=new JLabel(""+db);
        datte.setBounds(150,275,  180, 30);
        datte.setFont(new Font("cursive",Font.PLAIN,12));
        add(datte);
        
        submit=new JButton("Submit");
        submit.setForeground(Color.BLACK);
        submit.setBackground(new Color(249,255,205));
        submit.addActionListener(this);
        submit.setBounds(0,345,233,28);
        add(submit);
        
        update=new JButton("Update");
        update.setForeground(Color.BLACK);
        update.setBackground(new Color(249,255,205));
        update.addActionListener(this);
        update.setBounds(233,345,233,28);
        add(update);
        
        
        back=new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(249,255,205));
        back.addActionListener(this);
        back.setBounds(466,345,233,28);
        add(back);
        
        
        setBounds(285,125,700,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
          
            String carmodel=choice.getSelectedItem();
            String name=customername.getText();
            String customer_room=croomnumber.getSelectedItem();
            String pickuploc=tfpick.getText();
            String droploc=tfdrop.getText();
            String drivername=tfdriver.getText();
            String date=datte.getText();
            String distance=tfdistance.getText();
               if(pickuploc.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Pickup Location");
                return;
            }else if(droploc.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter drop Location");
                return;

            }else if(distance.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter Distance To Travel");
                return;

            }
               
               
            int totalbill=0;
            int dis_travel=Integer.parseInt(distance);
            String str="Select * from taxirent ";
            
         
            try{
                conn c=new conn();
                ResultSet rs=c.s.executeQuery(str);
                while(rs.next()){
                    totalbill+=dis_travel*(Integer.parseInt(rs.getString("per_km"))+Integer.parseInt(rs.getString("gov_tax")));
                    
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            String str2="insert into bill values('"+name+"','"+customer_room+"','"+pickuploc+"','"+droploc+"','"+drivername+"','"+carmodel+"','"+date+"','"+distance+"','"+totalbill+"')";
            String str3="Update adddriver set Availability='Occupied' where Car_Model='"+choice.getSelectedItem()+"'";
            try{
                conn c=new conn();
                c.s.executeUpdate(str2);
                c.s.executeUpdate(str3);
                JOptionPane.showMessageDialog(null,"PickUp Booked Successfully, Have a Safe Journey");
            }catch(Exception e){
                e.printStackTrace();
            }}
            else if(ae.getSource()==update){
                String roomnumber=croomnumber.getSelectedItem();
                String name1=customername.getText();
                String drivern=tfdriver.getText();
                
                setVisible(false);
                new updatepickup(roomnumber,name1,drivern);
                }
            else{
                setVisible(false);
                new Reception();
            }
        
    }
    public static void main(String[] args){
       new bookcar();
    }
}
