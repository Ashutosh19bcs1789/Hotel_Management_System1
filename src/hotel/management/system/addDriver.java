/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addDriver extends JFrame implements ActionListener{
    
    JButton jbcancel,jbadddriver;
    JTextField tfname,tfage,tftype,tflocation;
    JLabel jladddriver,jlName,jlage,jlgender,jltype,jlavailable, jllocation;
    JRadioButton rbmale,rbfemale;
    JComboBox cbavailable;
    
    
    addDriver(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        jladddriver =new JLabel("Add Drivers");
        jladddriver.setFont(new Font("serrif",Font.BOLD,18));
        jladddriver.setBounds(120,20,200,40);
        add(jladddriver);
        
        jlName =new JLabel("Name");
        jlName.setFont(new Font("serrif",Font.PLAIN,14));
        jlName.setBounds(40,60,200,30);
        add(jlName);
        
        tfname=new JTextField();
        tfname.setBounds(120,65,180,25);
        add(tfname);
        
        
        jlage=new JLabel("Age");
        jlage.setFont(new Font("serrif",Font.PLAIN,14));
        jlage.setBounds(40,100,200,30);
        add(jlage);
        
        tfage=new JTextField();
        tfage.setBounds(120,105,180,25);
        add(tfage);
        
        jlgender=new JLabel("Gender");
        jlgender.setFont(new Font("serrif",Font.PLAIN,14));
        jlgender.setBounds(40,140,200,30);
        add(jlgender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setFont(new Font("serrif",Font.BOLD,14));
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(120, 145, 60, 30);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setFont(new Font("serrif",Font.BOLD,14));
        rbfemale.setBackground(Color.WHITE);
        rbfemale.setBounds(180, 145, 100, 30);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        
        jltype=new JLabel("Car Model");
        jltype.setFont(new Font("serrif",Font.PLAIN,14));
        jltype.setBounds(40,180,200,30);
        add(jltype);
        
        tftype=new JTextField();
        tftype.setBounds(120,185,180,25);
        add(tftype);
        
        jlavailable=new JLabel("Availability");
        jlavailable.setFont(new Font("serrif",Font.PLAIN,14));
        jlavailable.setBounds(40,220,200,30);
        add(jlavailable);
        
        String driverOption[]={"Available","Occupied"};
        cbavailable=new JComboBox(driverOption);
        cbavailable.setFont(new Font("serrif",Font.PLAIN,14));
        cbavailable.setBounds(120,225,180,25);
        add(cbavailable);

        
        jllocation=new JLabel("Location");
        jllocation.setFont(new Font("serrif",Font.PLAIN,14));
        jllocation.setBounds(40,260,200,30);
        add(jllocation);
        
        tflocation=new JTextField();
        tflocation.setBounds(120,265,180,25);
        add(tflocation);
        
        jbadddriver=new JButton("Add Driver");
        jbadddriver.setForeground(Color.WHITE);
        jbadddriver.setBackground(Color.BLACK);
        jbadddriver.addActionListener(this);
        jbadddriver.setBounds(80, 305, 100, 25);
        add(jbadddriver);
        
        
        jbcancel=new JButton("Cancel");
        jbcancel.setForeground(Color.WHITE);
        jbcancel.setBackground(Color.BLACK);
        jbcancel.addActionListener(this);

        jbcancel.setBounds(200, 305, 100, 25);
        add(jbcancel);
        
        
        
        
        
        
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));      
        Image i2=i1.getImage().getScaledInstance(380,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(320,30,440,280);

        add(image);
        
        setBounds(250,150,800,400);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==jbadddriver){
          String name=tfname.getText();
          String age=tfage.getText();
          String gender=null;
          if(rbmale.isSelected()){
              gender="male";
          }else{
              gender="female";
          }
          String carmodel=tftype.getText();
          String availability=(String)cbavailable.getSelectedItem();
          String location=tflocation.getText();
            
          
          try{
              conn c=new conn();
              String str="insert into adddriver values('"+name+"','"+age+"','"+gender+"','"+carmodel+"','"+availability+"','"+location+"')";
              c.s.executeUpdate(str);
              JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
              setVisible(false);
          }catch(Exception e){
              e.printStackTrace();
          }
      }else{
          setVisible(false);
      }
    }
public static void main(String[] args){
    new addDriver();
}
}
