/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener{
    
    JLabel heading,JLabel ,lbroomno,lbavailable,lbclean,lbBedtype,lbprice;
    JComboBox cbavailableOption,cbcleaningOption,cbBedtypeOption;
    JButton jbadd,jbcancel;
    JTextField  tfroomno,tfprice;
    
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        heading=new JLabel("Add Rooms");
        heading.setBounds(360,20,200,20);
        heading.setFont(new Font("serrif",Font.BOLD,16));
        add(heading);
        
        lbroomno=new JLabel("Room Number");
        lbroomno.setBounds(60,60,200,30);
        lbroomno.setFont(new Font("serrif",Font.PLAIN,14));
        add(lbroomno);
        
        tfroomno=new JTextField();
        tfroomno.setBounds(200,65,200,25);
        add(tfroomno);
        
        lbavailable=new JLabel("Available");
        lbavailable.setBounds(60,100,200,30);
        lbavailable.setFont(new Font("serrif",Font.PLAIN,14));
        add(lbavailable);
        
        String availableOption[]={"Available","Occupied"};
        cbavailableOption=new JComboBox(availableOption);
        cbavailableOption.setBounds(200,105,200,25);
        cbavailableOption.setBackground(Color.WHITE);
        add(cbavailableOption);
        
        lbclean=new JLabel("Cleaning Status");
        lbclean.setBounds(60,140,200,30);
        lbclean.setFont(new Font("serrif",Font.PLAIN,14));
        add(lbclean);
        
        String cleaningOption[]={"Clean","Dirty"};
        cbcleaningOption=new JComboBox(cleaningOption);
        cbcleaningOption.setBounds(200,145,200,25);
        cbcleaningOption.setBackground(Color.WHITE);
        add(cbcleaningOption);
        
        
        lbBedtype=new JLabel("Bed Type");
        lbBedtype.setBounds(60,180,200,30);
        lbBedtype.setFont(new Font("serrif",Font.PLAIN,14));
        add(lbBedtype);
        
        String BedtypeOption[]={"Single Bed","Double Bed","Triple Bed"};
        cbBedtypeOption=new JComboBox(BedtypeOption);
        cbBedtypeOption.setBounds(200,185,200,25);
        cbBedtypeOption.setBackground(Color.WHITE);
        add(cbBedtypeOption);
        
        lbprice=new JLabel("Price");
        lbprice.setBounds(60,220,200,30);
        lbprice.setFont(new Font("serrif",Font.PLAIN,14));
        add(lbprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,225,200,25);
        add(tfprice);
        
        jbadd=new JButton("Add Room");
        jbadd.setBounds(180, 290 , 100, 25);
        jbadd.setBackground(Color.BLACK);
        jbadd.setForeground(Color.WHITE);
        jbadd.addActionListener(this);
        add(jbadd);
        
        
        
        jbcancel=new JButton("Cancel");
        jbcancel.setBounds(300, 290 , 100, 25);
        jbcancel.setBackground(Color.BLACK);
        jbcancel.setForeground(Color.WHITE);
        jbcancel.addActionListener(this);
        add(jbcancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(330,450, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 65, 350, 250);
        add(image);
        
        
        
        
        setBounds(220,150,850,450);
        setVisible(true);
    }
    
    //ActionEvent jo h wo hame ye batata hai ki jo button click hua h use source kaya h 
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==jbadd){
        String roomnumber=tfroomno.getText();
        String availability=(String)cbavailableOption.getSelectedItem();//combo box hamsesa ek obj retun krta h to hmko string me tyepcast krwana pdega + getselectionitem ek method hai usse hamse chckbox ka data niklate h
        String cleaning_status=(String)cbcleaningOption.getSelectedItem();
        String Bed_type=(String)cbBedtypeOption.getSelectedItem();
        String price=tfprice.getText();
    
        
        if(roomnumber.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Room Number Required");
                return;
            } else if(price.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Price Required");
                return;
                
            }
        try{
            conn c=new conn();
            String str="insert into addroom values('"+roomnumber+"','"+availability+"','"+cleaning_status+"','"+Bed_type+"','"+price+"')";
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null, "New room added successfully");
            setVisible(false);        
        }catch(Exception e){
            e.printStackTrace();
        }
        }else{
            setVisible(false);
        }
    }
   public static void main(String[] args){
       new AddRooms();
   } 
}
