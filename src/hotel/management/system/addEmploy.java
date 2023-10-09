/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class addEmploy extends JFrame implements ActionListener{
   //har cz locally declared h to action listioner pr click hoga to sb ko globally declared krna prega yha 
       JTextField tfname,tfage,tfsalary,tfadhar,tfemail,tfphone;
       //qki text field ka data jo bh h usko database m bhna h submit pr click kr k
       JRadioButton rbmale,rbfemale;
       JButton submit;
       JComboBox cbjob;
    
    addEmploy(){
       setLayout(null);
       
       
       JLabel jlname=new JLabel("NAME");
       jlname.setBounds(60,30,120,30);
       jlname.setFont(new Font("serif",Font.PLAIN,12));
       add(jlname);
       
       tfname=new JTextField();
       tfname.setBounds(150, 35, 180, 25);
       add(tfname);
       
       JLabel jlage=new JLabel("AGE");
       jlage.setBounds(60,70,120,30);
       jlage.setFont(new Font("serif",Font.PLAIN,12));
       add(jlage);
       
       tfage=new JTextField();
       tfage.setBounds(150, 75, 180, 25);
       add(tfage);
       
       JLabel jlgender=new JLabel("GENDER");
       jlgender.setBounds(60,110,120,30);
       jlgender.setFont(new Font("serif",Font.PLAIN,12));
       add(jlgender);
       
       rbmale=new JRadioButton("Male");
       rbmale.setBounds(150, 115, 70, 25);
       rbmale.setFont(new Font("serrif",Font.PLAIN,14));
       rbmale.setBackground(Color.WHITE);
       add(rbmale);
       
       rbfemale=new JRadioButton("Female");
       rbfemale.setBounds(240, 115, 100, 25);
       rbfemale.setFont(new Font("serrif",Font.PLAIN,14));
       rbfemale.setBackground(Color.WHITE);
       add(rbfemale);
       
       ButtonGroup bg=new ButtonGroup();
       bg.add(rbmale);
       bg.add(rbfemale);
       
       JLabel jljob=new JLabel("JOB");
       jljob.setBounds(60,150,120,30);
       jljob.setFont(new Font("serif",Font.PLAIN,12));
       add(jljob);
       
       //here we need drop down it can be done with JComboBox.
       //job bh value apko dkhana h dropdown m jo ass aa aray of string dkhna pdega
       String str[]={"Manager","Accountant","Front Desk Clerks","Porters","House Keeping","Room Service","Chefs","Waiter/ Waitress", "Manager","Accountant","Washman"};
       cbjob=new JComboBox(str);
       cbjob.setBounds(150, 155, 180, 25);
       cbjob.setBackground(Color.WHITE);
       add(cbjob);
       
       JLabel jlsalary=new JLabel("SALARY");
      jlsalary.setBounds(60,190,120,30);
       jlsalary.setFont(new Font("serif",Font.PLAIN,12));
       add(jlsalary);
       
       tfsalary=new JTextField();
       tfsalary.setBounds(150, 195, 180, 25);
       add(tfsalary);
       
      JLabel jlphone=new JLabel("PHONE");
      jlphone.setBounds(60,230,120,30);
       jlphone.setFont(new Font("serif",Font.PLAIN,12));
       add(jlphone);
       
       tfphone=new JTextField();
       tfphone.setBounds(150, 235, 180, 25);
       add(tfphone);
       
       
        JLabel jladhar=new JLabel("ADHAR NO.");
       jladhar.setBounds(60,270,120,30);
       jladhar.setFont(new Font("serif",Font.PLAIN,12));
       add(jladhar);
       
       
       tfadhar=new JTextField();
       tfadhar.setBounds(150, 275, 180, 25);
       add(tfadhar);
       
       JLabel jlemail=new JLabel("EMAIL");
       jlemail.setBounds(60,310,120,30);
       jlemail.setFont(new Font("serif",Font.PLAIN,12));
       add(jlemail);
       
       tfemail=new JTextField();
       tfemail.setBounds(150, 315, 180, 25);
       add(tfemail);
       
       
       submit=new JButton("SUMMIT");
       submit.setBounds(150, 360, 180, 35);
       submit.setForeground(Color.WHITE);
       submit.setBackground(Color.BLACK);
       //qki submit ss actionlistner work kre g to usko hme yha add krna h --function call kre g
       submit.addActionListener(this);
       add(submit);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
      Image i2=i1.getImage().getScaledInstance(380, 450, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2); 
      JLabel image=new JLabel(i3);
       image.setBounds(335, 10,450,380);  //image crop bh kr skte h
       add(image);
       
       
       
       
       getContentPane().setBackground(Color.WHITE); //isse layout k color seet hoga
       setBounds(250,150,790,460);
       setVisible(true);
   }
   
   
    public void actionPerformed(ActionEvent ae ){
        //ab hame value nikalna h sb data k
        String name=tfname.getText();
        String age=tfage.getText();
        
        
          //ab hame gender mane ki radio button se data niklana h to iske ly hm ek string banay g
        // jo ki intial value null lega uske bd fr check kre g if else ss 
        //mtlb isme ek isselected kr k ek function hota h usko rbmale.isselected... kr k kre g fr chck kre g.
        String gender=null;
        if(rbmale.isSelected()){
            gender="Male";
    } else if(rbfemale.isSelected()){
        gender="Female";
    }
        
        //wse hi combobox ss value niklne k ly hm ek string job bnay ur isme ek funx hota h .getselecteditem kr k uska use kr k nikle g        
        String job=(String)cbjob.getSelectedItem(); //ye getselected obj ko return krta h ur hm string m return krwa rhe h to type cast kr rh h string m
       
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String adhar=tfadhar.getText();
        String email=tfemail.getText();
        
        
      if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Name Required");
                return;
            } else if(age.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Age Required");
                return;
            }else if(gender == null){
                JOptionPane.showMessageDialog(null,"Error ! Gender Required");
                return;
            }else if(salary.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Salary Required");
                return;
            }else if(phone.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Phone number Required");
                return;
            }else if(adhar.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Adhar Required");
                return;
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"Error ! Email Required");
                return;
            } 
    //ab data ko database m dalna h sme externl source use hota to exception k chance h try catch use hoga
    try{
    conn c = new conn(); //ab query mysql p banae k bd con banana h
    //conn baane k ly 1step hai ki conn k obj bana do sidha uske bd ek string query(str) lo ur value insert krwa do
    String  str = "INSERT INTO employee VALUES ( '"+name+"', '"+age+"', '"+gender+"','"+job+"','"+salary+"', '"+phone+"','"+adhar+"', '"+email+"')";
    //ab query ko properly execute bh krwana h login wale m hm ddl command k use kr rh th mtlb table ss table le rh th
    //but yaha hm jo hai insert kre g database update kre g
    //use kre g hm ye-
    c.s.executeUpdate(str);
    //isme ss hame return koi  value nh chiye login jaisa to isme resultset banane ki jrurat nh h bs ek popup dkha dena h
    // ur pop up k ly JOPtionPane.showMessage------- k use kre g
    JOptionPane.showMessageDialog(null,"Employee added successfully");
    setVisible(false);
    } 
    catch(Exception e){
    e.printStackTrace();
    }//ja k mysql m query banao phel database taable
    
    }
   public static void main(String[] args){
       new addEmploy();
   }
    
}
