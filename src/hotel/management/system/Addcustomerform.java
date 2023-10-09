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



public class Addcustomerform extends JFrame implements ActionListener{
    JRadioButton rbmale,rbfemale;
    JLabel jlgender,jlcheckintime;
    Choice croom;
    JButton add,back;
    JTextField tfname,tfidnumber,tfcountry,tfdeposit;
    JComboBox cbid;
    Addcustomerform(){
        super("New Customer");
        setLayout(null);
        getContentPane().setBackground(new Color(240,231,247));
        
        JLabel jltext=new JLabel("New Customer Form");
        jltext.setFont(new Font("Serrif",Font.BOLD,20));
        jltext.setBounds(270, 20, 300, 35);
        add(jltext);
        
        
        
        JLabel jlname=new JLabel("Name");
        jlname.setFont(new Font("Serrif",Font.BOLD,14));
        jlname.setBounds(60, 70, 150, 30);
        add(jlname);
        
        
        tfname=new JTextField();
        tfname.setBounds(150, 75, 168, 25);
        tfname.setBackground(new Color(249,255,205));
        add(tfname);
        
        
          JLabel jlid=new JLabel("ID Proof");
        jlid.setFont(new Font("Serrif",Font.BOLD,14));
        jlid.setBounds(60, 110, 150, 30);
        add(jlid);
        
        String option[]={"Aadhar Card","Pan Card", "Voter Id","Driving License","Passport","Ration Card"};
        cbid=new JComboBox(option);
        cbid.setBounds(150,115,168,25);
        cbid.setBackground(new Color(249,255,205));
        add(cbid);
        
        
         JLabel jlidnumber=new JLabel("Id Number");
        jlidnumber.setFont(new Font("Serrif",Font.BOLD,14));
        jlidnumber.setBounds(60, 150, 150, 30);
        add(jlidnumber);
        
        
        tfidnumber=new JTextField();
        tfidnumber.setBounds(150, 155, 168, 25);
        tfidnumber.setBackground(new Color(249,255,205));
        add(tfidnumber);
        
        jlgender=new JLabel("Gender");
        jlgender.setFont(new Font("serrif",Font.BOLD,14));
        jlgender.setBounds(60,190,200,30);
        add(jlgender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setFont(new Font("serrif",Font.BOLD,14));
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(150, 195, 60, 30);
        rbmale.setBackground(new Color(240,231,247));
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setFont(new Font("serrif",Font.BOLD,14));
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setBounds(240, 195, 100, 30);
        rbfemale.setBackground(new Color(240,231,247));
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel jlcountry=new JLabel("Country");
        jlcountry.setFont(new Font("Serrif",Font.BOLD,14));
        jlcountry.setBounds(60, 230, 150, 30);
        add(jlcountry);
        
        
        tfcountry=new JTextField();
        tfcountry.setBounds(150, 235, 168, 25);
        tfcountry.setBackground(new Color(249,255,205));
        add(tfcountry);
        
        
         JLabel jlroomno=new JLabel("Room No.");
        jlroomno.setFont(new Font("Serrif",Font.BOLD,14));
        jlroomno.setBounds(60, 270, 80, 30);
        add(jlroomno);
        
        croom=new Choice();  
        try{
          conn c=new conn();
          String str="Select * from addroom where Availability='Available'";
          ResultSet rs=c.s.executeQuery(str);
          while(rs.next()){
              croom.add(rs.getString("Room_Number"));
          }
         
        }catch(Exception e){
            e.printStackTrace();
        }
        croom.setBounds(150, 275, 168, 25);
        croom.setBackground(new Color(249,255,205));
        add(croom);
        
                
        
        JLabel jlcheckin=new JLabel("Check IN ");
        jlcheckin.setFont(new Font("Serrif",Font.BOLD,14));
        jlcheckin.setBounds(60, 310, 80, 30);
        add(jlcheckin);
                
        Date jdate=new Date();
        jlcheckintime=new JLabel(""+ jdate);
        jlcheckintime.setFont(new Font("Serrif",Font.BOLD,12));
        jlcheckintime.setBounds(150, 315, 190, 25);
        add(jlcheckintime);
        
        JLabel jlDeposit=new JLabel("Deposit");
        jlDeposit.setFont(new Font("Serrif",Font.BOLD,14));
        jlDeposit.setBounds(60, 340, 150, 30);
        add(jlDeposit);
        
        tfdeposit=new JTextField();
        tfdeposit.setBounds(150, 345, 168, 25);
        tfdeposit.setBackground(new Color(249,255,205));
        add(tfdeposit);
        
        
        
        add=new JButton("Add");
        add.setBounds(60, 390, 110, 25);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back=new JButton("Back");
        back.setBounds(190, 390, 110, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(270, 270,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(390,90,260,270);
        add(image);
        
        setBounds(290,125,700,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==add){
            String name=tfname.getText();
            String id=(String)cbid.getSelectedItem();
            String number=tfidnumber.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="male";
            }
            else if(rbfemale.isSelected()){
                gender="female";
            }
            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String time=jlcheckintime.getText();
            String deposit=tfdeposit.getText();
            
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Name Required");
                return;
            } else if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Id Number Required");
                return;
            }else if(gender == null){
                JOptionPane.showMessageDialog(null,"Error ! Gender Required");
                return;
            }else if(country.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Country Required");
                return;
            }else if(deposit.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Deposit Required");
                return;
            }
           
            try{
            String query="insert into addcustomer values('"+name+"','"+id+"','"+number+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
            String query2="update addroom Set Availability='occupied' where Room_Number='"+room+"'";
            conn c=new conn();
            c.s.executeUpdate(query);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
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
        new Addcustomerform();
    }
}
