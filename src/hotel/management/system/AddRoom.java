package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class AddRoom extends JFrame implements ActionListener{

    JButton add,cancel;
    JTextField  tfroom,tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    
  AddRoom(){
      setBounds(330,200,940,470);
      getContentPane().setBackground(Color.WHITE); 
      setLayout(null);
      
      JLabel lblheading=new JLabel("Add Room");
      lblheading.setFont(new Font ("Tahoma",Font.BOLD,18));
      lblheading.setBounds(150,20,200,20);
      add(lblheading);
      
      JLabel lblroomno=new JLabel("Room Number");
      lblroomno.setFont(new Font ("Tahoma",Font.PLAIN,18));
      lblroomno.setBounds(60,80,120,20);
      add(lblroomno);
      
      tfroom=new JTextField();
     tfroom.setBounds(200,80,150,30);
     add(tfroom);
     
     JLabel lblavailable=new JLabel("Available");
      lblavailable.setFont(new Font ("Tahoma",Font.PLAIN,18));
      lblavailable.setBounds(60,130,120,20);
      add(lblavailable);
      
      String availableOptions[]={"Available","Occupied"};
       availablecombo=new JComboBox(availableOptions); 
      availablecombo.setBounds(200,130,150,30);
      availablecombo.setBackground((Color.WHITE));
      add(availablecombo);
      
      JLabel lblclean=new JLabel("Clean Status");
     lblclean.setFont(new Font ("Tahoma",Font.PLAIN,18));
      lblclean.setBounds(60,180,120,20);
      add(lblclean);
      
      String cleanOptions[]={"Cleaned","Dirty"};
       cleancombo=new JComboBox(cleanOptions); 
      cleancombo.setBounds(200,180,150,30);
      cleancombo.setBackground((Color.WHITE));
      add(cleancombo);
      
      JLabel lblprice=new JLabel("Price");
      lblprice.setFont(new Font ("Tahoma",Font.PLAIN,18));
      lblprice.setBounds(60,230,120,20);
      add(lblprice);
      
      tfprice=new JTextField();
    tfprice.setBounds(200,230,150,30);
     add(tfprice);
     
      JLabel lbltype=new JLabel("Bed Type");
      lbltype.setFont(new Font ("Tahoma",Font.PLAIN,18));
      lbltype.setBounds(60,280,120,20);
      add(lbltype);
      
       String typeOptions[]={"Single Bed","Double Bed"};
       typecombo=new JComboBox(typeOptions); 
      typecombo.setBounds(200,280,150,30);
      typecombo.setBackground((Color.WHITE));
      add(typecombo);
      
      add=new JButton("ADD ROOM");
      add.setForeground(Color.white);
      add.setBackground(Color.BLACK);
      add.setBounds(60,350,130,30);
      add.addActionListener(this);
      add(add);
      
       cancel=new JButton("Cancel");
      cancel.setForeground(Color.white);
      cancel.setBackground(Color.BLACK);
      cancel.setBounds(220,350,130,30);
      cancel.addActionListener(this);
      add(cancel);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
      JLabel image=new JLabel(i1);
      image.setBounds(400,30,500,300);
      add(image);
      
      setVisible(true);
      
  }
  public void actionPerformed(ActionEvent ae){
      if(ae.getSource() ==  add){
          
        String roomnumber=tfroom.getText();
        String availability= (String) availablecombo.getSelectedItem();
        String status= (String) cleancombo.getSelectedItem();
        String price=tfprice.getText();
        String type=(String) typecombo.getSelectedItem();
        try{
            Conn conn=new Conn();
                String str="insert into room values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
                
          
            conn.s.executeUpdate(str);
            
            JOptionPane.showMessageDialog(null,"NewRoom added Successfully");
             setVisible(false);
        }catch (Exception e) {
            e.printStackTrace();
        }
      }
      else{
          setVisible(false);
      }
  }
  
  public static void main(String[] args){
      new AddRoom();
  }
}