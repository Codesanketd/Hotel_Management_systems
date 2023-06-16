
package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField username,password;
    JButton Login,Cancel;
    
    Login(){
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500,200,600,300); 
        JLabel user=new JLabel("Username");
         user.setBounds(40,20,100,30);
         add(user);
         
          username=new JTextField();
         username.setBounds(150,20,150,30);
         add(username);
         
          JLabel pass=new JLabel("Password");
         pass.setBounds(40,70,100,30);
         add(pass);
         
          password=new JTextField();
         password.setBounds(150,70,150,30);
         add(password);
         
          Login=new JButton("Login");
         Login.setBounds(40, 150, 120, 30);
         Login.setBackground(Color.BLACK);
         Login.setForeground(Color.WHITE);
         Login.addActionListener(this);
         add(Login);
         
         Cancel=new JButton("Cancel");
         Cancel.setBounds(200, 150, 120, 30);
         Cancel.setBackground(Color.BLACK);
         Cancel.setForeground(Color.WHITE);
         Cancel.addActionListener(this);
         add(Cancel);
         
         ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
         Image i2=il.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(350,10,200,200);
         add(image);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){// login button click get user and pass
        if(ae.getSource()==Login){
          String user=  username.getText();
          String pass= password.getText();
          try{
              Conn c=new Conn();
              String query="select * from login where username='"+user +"' and password='"+pass+"'";
//              System.out.println(query);
               ResultSet rs=c.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Dashboard();
              }else{
                  JOptionPane.showMessageDialog(null, "Invalid username or password");
                  setVisible(false);
              }
          }catch(Exception e){
              e.printStackTrace();
          }
          if(ae.getSource()==Login){
              
          }
        }else if(ae.getSource()==Cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login() ;
            
        
    }
}
