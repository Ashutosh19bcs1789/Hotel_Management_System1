/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
   //made constructor
    Dashboard(){
    super("River`s Edge Hotel");
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
    Image i2=i1.getImage().getScaledInstance(1510, 710,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 1400, 700);
    add(image);
    
    
    JLabel text=new JLabel("River`s Edge Hotel Welcomes You");
    text.setBounds(400, 40, 1000, 45);
    text.setFont(new Font("railway",Font.BOLD,30)); 
    text.setForeground(Color.BLACK);
    image.add(text); 
    
    JMenuBar menu=new JMenuBar();
    menu.setBounds(0,0,1400,30);
    image.add(menu);
    
    
    JMenu hotel=new JMenu("  HOTEL MANAGEMENT");
    menu.add(hotel);
    
    JMenuItem reception=new JMenuItem("Reception");
    reception.addActionListener(this);
    hotel.add(reception);
    
    JMenu admin=new JMenu("  ADMIN");
    menu.add(admin);
    
    JMenuItem addemployee=new JMenuItem("Add Employee");
    addemployee.addActionListener(this);
    admin.add(addemployee);
    
    JMenuItem addrooms=new JMenuItem("Add Rooms");
    addrooms.addActionListener(this);
    admin.add(addrooms);
    
    JMenuItem adddrivers=new JMenuItem("Add Drivers");
    adddrivers.addActionListener(this);
    admin.add(adddrivers);
    
    
    JMenu contactus=new JMenu("  CONTACT US");
    menu.add(contactus);
    
    JMenuItem mcontactus=new JMenuItem("Contact us");
    mcontactus.addActionListener(this);
    contactus.add(mcontactus);
    
    
    
    JMenu exit=new JMenu("  EXIT");
    menu.add(exit);
    
    JMenuItem mexit=new JMenuItem("Exit");
    mexit.addActionListener(this);
    exit.add(mexit);
    
    setVisible(true);
   
    
}
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Employee")){
            new addEmploy();
        }
        else if(ae.getActionCommand().equals("Add Rooms")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("Reception")){
            setVisible(false);
            new Reception();//object bana dya reception class k
        }
        else if(ae.getActionCommand().equals("Add Drivers")){
            new addDriver();
        }else if(ae.getActionCommand().equals("Contact us")){
            setVisible(false);
            new contactus();
        }
        else if(ae.getActionCommand().equals("Exit")){
            setVisible(false);
            new Login();
        }
    }
public static void main(String[] args){
        new Dashboard();
}}
