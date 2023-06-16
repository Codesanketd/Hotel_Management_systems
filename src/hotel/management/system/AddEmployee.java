package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;

public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname,tfage,tfgender,tfsalary,tfphone,tfaadhar,tfemail;
    JRadioButton rbmale,rbfemale,rbtransgender;
    JButton submit;
    JComboBox cbjob;
    
    AddEmployee(){
       setLayout(null);
       
       JLabel lblname=new JLabel("NAME");
       lblname.setBounds(60,30,120,30);
       lblname.setFont(new Font("Tahoma",Font.PLAIN,17));  
       add(lblname);
       
        tfname=new JTextField();
       tfname.setBounds(200,30,150,30);
       setBounds(350,200,850,540);
       add(tfname);
       
       JLabel lblage=new JLabel("AGE");
       lblage.setBounds(60,80,120,30);
       lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
    getContentPane().setBackground(Color.WHITE);
       add(lblage);
        
      tfage=new JTextField();
       tfage.setBounds(200,80,150,30);
       add(tfage);
       
       JLabel lblgender=new JLabel("GENDER");
       lblgender.setBounds(60, 130, 120, 30);
       lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lblgender);
       
        rbmale =new JRadioButton("Male");
       rbmale.setBounds(200,130,70,30);
       rbmale.setFont(new Font("Tahoma",Font.PLAIN,14 ));
       rbmale.setBackground(Color.WHITE);
       add(rbmale);
       
        rbfemale =new JRadioButton("Female");
       rbfemale.setBounds(280,130,70,30);
       rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14 ));
       rbfemale.setBackground(Color.WHITE);
       add(rbfemale);
       
        rbtransgender =new JRadioButton("TransG");
       rbtransgender.setBounds(360,130,70,30);
       rbtransgender.setFont(new Font("Tahoma",Font.PLAIN,14 ));
       rbtransgender.setBackground(Color.WHITE);
       add(rbtransgender);
       
       ButtonGroup bg=new ButtonGroup();
       bg.add(rbmale);
       bg.add(rbfemale);
       bg.add(rbtransgender);
       
       JLabel lbljob=new JLabel("JOB");
       lbljob.setBounds(60, 180, 150, 30);
       lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(lbljob);
       
       String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","chef","Waiter/Waitress","Manager","Accountant"};
        cbjob=new JComboBox(str);
       cbjob.setBounds(200,180,150,30);
       cbjob.setBackground(Color.WHITE);
       add(cbjob);
       
       JLabel lblsalary=new JLabel("SALARY");
       lblsalary.setBounds(60,230,120,30);
       lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));  
       add(lblsalary); 
       
        tfsalary=new JTextField();
       tfsalary.setBounds(200,230,150,30);
       add(tfsalary);
       
       JLabel lblphone=new JLabel("PHONE");
       lblphone.setBounds(60,280,120,30);
       lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));  
       add(lblphone);
       
        tfphone=new JTextField();
       tfphone.setBounds(200,280,150,30);
       add(tfphone);
       
       tfphone=new JTextField();
       tfphone.setBounds(200,280,150,30);
       add(tfphone);
       
       JLabel lblemail=new JLabel("EMAIL");
       lblemail.setBounds(60,330,120,30);
       lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));  
       add(lblemail);
       
       tfemail=new JTextField();
       tfemail.setBounds(200,330,150,30);
       add(tfemail);
       
        JLabel lblaadhar=new JLabel("AADHAR");
       lblaadhar.setBounds(60,380,120,30);
       lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));  
       add(lblaadhar);
       
       tfaadhar =new JTextField();
       tfphone.setBounds(200,380,150,30);
       add(tfphone);
       
       
       
       submit=new JButton("SUBMIT");
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.setBounds(200,430,150,30);
       submit.addActionListener(this);
       add(submit);
       
      ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
         Image i2=il.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(380,60,450,370);
         add(image); 
         
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,540);
       setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age =tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();
//        int aadharno = Integer.parseInt(aadhar);
        String gender=null;
        System.out.println(name);
        System.out.println(aadhar);
        if(rbmale.isSelected()){
            gender="Male";
        }else if(rbfemale.isSelected()){
            gender="Female";
        }else if(rbtransgender.isSelected()){
            gender="Transgender";
        }
        
        String job=(String) cbjob.getSelectedItem();
         try{
             Conn conn=new Conn();
             
             String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
             System.out.println(query);
             System.out.println(name);
             System.out.println(aadhar);
             conn.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Employee added successfully");
         }catch (Exception e){
             e.printStackTrace();
         }
        
    }
    
    public static void main(String[] args){
        new AddEmployee();
    }
}
