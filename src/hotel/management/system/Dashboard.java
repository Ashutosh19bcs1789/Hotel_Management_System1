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
    //imageicon ss image lagta h lkin jb hm usko scale krte h to dirct nh laga skte h uske fr ss imageicon m covert krna pdega
    Image i2=i1.getImage().getScaledInstance(1510, 710,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 1400, 700);
    add(image);
    
    
    JLabel text=new JLabel("River`s Edge Hotel Welcomes You");
    text.setBounds(400, 40, 1000, 45);
    text.setFont(new Font("railway",Font.BOLD,30)); //set font ke andr font class ka obj bana k 3 argument lega
    text.setForeground(Color.BLACK);
    image.add(text); //qki iamge ke upr lkhna h to image.add kr k call kre g
    
    
    
    //predefined class hota h menubar k ly call kr k obj banao
    JMenuBar menu=new JMenuBar();
    menu.setBounds(0,0,1400,30);
    image.add(menu);
    
    //menuitem add hota h menu m ur menu add hota h menubar m
    
    JMenu hotel=new JMenu("  HOTEL MANAGEMENT");
    menu.add(hotel);
    
    JMenuItem reception=new JMenuItem("Reception");
    reception.addActionListener(this);
    hotel.add(reception);
    //aab menu ke andr dropdown banana hai to simmple jmenuitem kr k cls h uska obj bnao ho gy
    
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
            new Reception();//object bana dya reception class k
        }
        else if(ae.getActionCommand().equals("Add Drivers")){
            new addDriver();
        }
        else if(ae.getActionCommand().equals("Exit")){
            setVisible(false);
            new Login();
        }
    }
public static void main(String[] args){
        new Dashboard();
}}
