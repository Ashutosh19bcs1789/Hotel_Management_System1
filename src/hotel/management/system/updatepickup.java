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


public class updatepickup extends JFrame implements ActionListener{
    String roomno;
    String name1;
    String driver;
    JLabel datte, lbroom,totalbill,lbridestart,lbdistance,lbdriver;
    JButton bill,Ridecompleted,back;
    updatepickup(String roomnumber,String cname1,String drivern){
        
        super("Update PickUp Services");
        this.roomno=roomnumber;
        this.name1=cname1;
        this.driver=drivern;

        
        setLayout(null);
        getContentPane().setBackground(new Color(242,219,212));
        
        JLabel name=new JLabel("Name");
        name.setBounds(40,40,  100, 30);
        name.setFont(new Font("cursive",Font.BOLD,12));
        add(name);
        
        JLabel lbname=new JLabel(name1);
        lbname.setBounds(180,40,  100, 30);
        lbname.setFont(new Font("cursive",Font.PLAIN,12));
        add(lbname);
        
        
        JLabel room=new JLabel("Room Number");
        room.setBounds(40,75,  100, 30);
        room.setFont(new Font("cursive",Font.BOLD,12));
        add(room);
        
        lbroom=new JLabel(roomno);
        lbroom.setBounds(180,75,  100, 30);
        lbroom.setFont(new Font("cursive",Font.PLAIN,12));
        add(lbroom);
        
        JLabel drivername=new JLabel("Driver Name");
        drivername.setBounds(40,105,  100, 30);
        drivername.setFont(new Font("cursive",Font.BOLD,12));
        add(drivername);
        
        lbdriver=new JLabel(driver);
        lbdriver.setBounds(180,105,  100, 30);
        lbdriver.setFont(new Font("cursive",Font.PLAIN,12));
        add(lbdriver);
        
        
        JLabel ridestart=new JLabel("Ride Starts on");
        ridestart.setBounds(40,140,  100, 30);
        ridestart.setFont(new Font("cursive",Font.BOLD,12));
        add(ridestart);
                
        lbridestart=new JLabel();
        lbridestart.setBounds(180,140,  180, 30);
        lbridestart.setFont(new Font("cursive",Font.PLAIN,12));
        add(lbridestart);     
                
        JLabel rideend=new JLabel("Ride Ends on");
        rideend.setBounds(40,175,  100, 30);
        rideend.setFont(new Font("cursive",Font.BOLD,12));
        add(rideend);
        
        
        Date db=new Date();
        datte=new JLabel(""+db);
        datte.setBounds(180,175,  180, 30);
        datte.setFont(new Font("cursive",Font.PLAIN,12));
        add(datte);
        
        
        JLabel distancetravel=new JLabel("Distance Travelled");
        distancetravel.setBounds(40,210,  120, 30);
        distancetravel.setFont(new Font("cursive",Font.BOLD,12));
        add(distancetravel);
                
        lbdistance=new JLabel();
        lbdistance.setBounds(180,210,  180, 30);
        lbdistance.setFont(new Font("cursive",Font.PLAIN,12));
        add(lbdistance);     
        
        JLabel calculate=new JLabel("Total Bill");
        calculate.setBounds(40,245,  120, 30);
        calculate.setFont(new Font("cursive",Font.BOLD,12));
        add(calculate);
        
        totalbill=new JLabel();
        totalbill.setBounds(180,245,  180, 30);
        totalbill.setFont(new Font("cursive",Font.PLAIN,12));
        add(totalbill);
        
        
        
        
        bill=new JButton("CHECK");
        bill.setForeground(Color.BLACK);
        bill.setBackground(new Color(249,255,205));
        bill.addActionListener(this);
        bill.setBounds(360,245,90,23);
        add(bill);
        
        
        JLabel ridecom=new JLabel("IF YOU WANT TO UPDATE THIS RIDE AS FINISHED RIDE, THEN CLICK 'FINISHED RIDE'.");
        ridecom.setBounds(105,270,  580, 30);
        ridecom.setForeground(Color.BLUE);
        ridecom.setFont(new Font("Monospaced",Font.BOLD,10));
        add(ridecom);
        
        
        Ridecompleted=new JButton("FINISHED RIDE");
        Ridecompleted.setForeground(Color.BLACK);
        Ridecompleted.setBackground(new Color(249,255,205));
        Ridecompleted.addActionListener(this);
        Ridecompleted.setBounds(0,300,330,23);
        add(Ridecompleted);
        
        back=new JButton("BACK");
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(249,255,205));
        back.addActionListener(this);
        back.setBounds(330,300,330,23);
        add(back);
        setBounds(285,125,660,390);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bill){
            try{
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select * from bill where Room_Number='"+lbroom.getText()+"'");
                    while(rs.next()){
                        totalbill.setText(rs.getString("Total_Amount"));
                        lbridestart.setText(rs.getString("Booking_Date"));
                        lbdistance.setText(rs.getString("Distance"));
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
        }else if(ae.getSource()==Ridecompleted){
            try{
                conn c=new conn();
                String drivername=lbdriver.getText();
                String str;
                str = "update adddriver set Availability='Available' where  Name='"+drivername+"'";
                String str1="DELETE FROM bill WHERE Room_Number='"+roomno+"';";
                c.s.executeUpdate(str);
                c.s.executeUpdate(str1);
                JOptionPane.showMessageDialog(null,"Update Successful as Ride Completed");
                setVisible(false);
                new pickup();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new bookcar();
        }
    }
    public static void main(String[] agrs){
        new updatepickup("","","");
    }
}
