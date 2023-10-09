/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Searchforroom extends JFrame implements ActionListener{
    JTable table;
    JButton back,check,print;
    JComboBox cbbedtype;
    JCheckBox cbavailable;
    Searchforroom(){
        super("Search For Rooms");
        
        setLayout(null);
        getContentPane().setBackground(new Color(240,231,247));
        
        
        JLabel lbheader=new JLabel("Search For Room");
        lbheader.setBounds(310,15,  200, 30);
        lbheader.setFont(new Font("Monospaced",Font.BOLD,18));
        add(lbheader);
        
        JLabel bedtype=new JLabel("Bed Type");
        bedtype.setBounds(30,60,70,30);
        add(bedtype);
        
        String bedtypeoption[]={"Single Bed","Double Bed","Triple Bed"};
        cbbedtype=new JComboBox(bedtypeoption);
        cbbedtype.setBounds(100,65,130,25);
        cbbedtype.setBackground(new Color(249,255,205));
        cbbedtype.setForeground(Color.BLACK);
        add(cbbedtype);
        
        
        cbavailable=new JCheckBox("Only Display Available");
        cbavailable.setBounds(300,60,200,35);
        cbavailable.setBackground(new Color(240,231,247));
        add(cbavailable);
        
        
        check=new JButton("Check");
        check.setForeground(Color.BLACK);
        check.setBackground(new Color(249,255,205));
        check.addActionListener(this);
        check.setBounds(515,60,80,28);
        add(check);
        
        print=new JButton("Print");
        print.setForeground(Color.BLACK);
        print.setBackground(new Color(249,255,205));
        print.addActionListener(this);
        print.setBounds(600,60,80,28);
        add(print);
        
        back=new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(249,255,205));
        back.addActionListener(this);
        back.setBounds(685,60,80,28);
        add(back);
        
 
        table=new JTable();
       
        try{
            conn c=new conn();
            String str="Select * from addroom ";
            ResultSet rs=c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp=new JScrollPane(table);
        sp.setBounds(0,100,790,370);
        add(sp);
        
        setBounds(255,125,800,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==check){
            try{
                
                String str1="Select * from addroom where bed_type='"+cbbedtype.getSelectedItem()+"'";
                String str2="Select * from addroom where Availability='Available' AND bed_type='"+cbbedtype.getSelectedItem()+"'";            
               conn c=new conn();
               ResultSet rs;
                if(cbavailable.isSelected()){
                    rs=c.s.executeQuery(str2);
                }else{
                    rs=c.s.executeQuery(str1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
        else{
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
public static void main(String[] args){
    new Searchforroom();
}    
}
